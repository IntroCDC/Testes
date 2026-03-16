package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 22/03/2025 - 06:18
 */

import br.com.introcdc.tests.database.FileComponents;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.Normalizer;
import java.util.*;
import java.util.List;

public class MusicQuestRegister {

    private static final Gson GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();

    private static String normalizeForCompare(String text) {
        if (text == null) {
            return "";
        }

        String t = Normalizer.normalize(text, Normalizer.Form.NFKC);

        // Mata BOM, zero-width e afins
        t = t.replaceAll("[\\u200B-\\u200D\\uFEFF]", "");

        // NBSP vira espaço normal
        t = t.replace('\u00A0', ' ');

        // Colapsa qualquer tipo de separador/whitespace em 1 espaço
        t = t.replaceAll("[\\p{Z}\\s]+", " ").trim();

        return t.toLowerCase(Locale.ROOT);
    }

    private static String buildSongKey(String author, String name) {
        // MUDANÇA: Agora eu removo TUDO que não é letra ou número. Adeus espaços!
        // "8 Bit Piano" vira "8bitpiano".
        String cleanName = normalizeForCompare(name).replaceAll("[^a-z0-9]", "");
        return canonicalAuthor(author) + "||" + cleanName;
    }

    private static String canonicalAuthor(String author) {
        String a = normalizeForCompare(author);

        // remove pontuação pra pegar "misteria", "mister ia", "mr. ia"
        a = a.replaceAll("[^a-z0-9 ]", "");
        a = a.replaceAll("\\s+", " ").trim();

        // Canoniza variações do teu autor
        // (tu pode adicionar mais apelidos aqui se quiser)
        if (a.equals("ia") || a.equals("mister ia") || a.equals("misteria") || a.equals("mr ia")) {
            return "ia";
        }

        return a;
    }

    // Helpers to replace org.json's optString and optInt
    private static String optString(JsonObject obj, String key, String fallback) {
        if (obj.has(key) && !obj.get(key).isJsonNull()) {
            return obj.get(key).getAsString();
        }
        return fallback;
    }

    private static int optInt(JsonObject obj, String key, int fallback) {
        if (obj.has(key) && !obj.get(key).isJsonNull()) {
            return obj.get(key).getAsInt();
        }
        return fallback;
    }

    public static void main(String[] args) {
        try {
            // Seleciona a pasta onde estão os arquivos MP3
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int chooserOption = chooser.showOpenDialog(null);

            if (chooserOption != JFileChooser.APPROVE_OPTION) {
                System.out.println("Pasta não selecionada. Encerrando...");
                return;
            }
            File selectedFolder = chooser.getSelectedFile();

            // Lista os arquivos MP3 na pasta selecionada
            File[] mp3Files = selectedFolder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".mp3");
                }
            });

            if (mp3Files == null || mp3Files.length == 0) {
                System.out.println("Nenhum arquivo MP3 encontrado na pasta selecionada.");
                return;
            }

            // Cria um Scanner para ler as entradas do usuário
            Scanner inputScanner = new Scanner(System.in);

            // Carrega (ou cria) o arquivo musicquest.json
            File jsonFile = new File("musicquest.json");
            System.out.println("=== DIAGNÓSTICO DO ARQUIVO ===");
            System.out.println("Caminho: " + jsonFile.getAbsolutePath());

            if (jsonFile.exists()) {
                System.out.println("Status: O arquivo EXISTE.");
                System.out.println("Tamanho em disco: " + jsonFile.length() + " bytes.");

                // Vamos ler na marra pra ver o que tem dentro
                String realContent = readTextFile(jsonFile);
                System.out.println("--- CONTEÚDO QUE O JAVA LEU ---");
                System.out.println(realContent); // AQUI VAI MOSTRAR A VERDADE
                System.out.println("-------------------------------");
            } else {
                System.out.println("Status: O arquivo NÃO EXISTE (O Java tá cegueta ou tu não criou nessa pasta).");
                System.out.println("Criando array vazio na memória...");
            }

            JsonArray songsJsonArray = loadJsonArray(jsonFile);
            System.out.println("Total de objetos entendidos pelo JSON: " + songsJsonArray.size());
            System.out.println("==============================");

            Set<String> existingKeys = new HashSet<>();
            for (int i = 0; i < songsJsonArray.size(); i++) {
                JsonObject obj = songsJsonArray.get(i).getAsJsonObject();
                String regAuthor = optString(obj, "author", "");
                String regName = optString(obj, "name", "");
                String key = buildSongKey(regAuthor, regName);

                // Printa só pra gente ver se a IA tá lá (pode comentar depois)
                if (regAuthor.equalsIgnoreCase("IA")) {
                    System.out.println("JSON LOAD -> " + regAuthor + " | " + regName + " => Key: [" + key + "]");
                }

                existingKeys.add(key);
            }

            // Determina o próximo ID com base no último registrado
            int nextID = 1;
            for (int i = 0; i < songsJsonArray.size(); i++) {
                JsonObject obj = songsJsonArray.get(i).getAsJsonObject();
                int id = optInt(obj, "ID", 0);
                if (id >= nextID) {
                    nextID = id + 1;
                }
            }

            // Processa cada arquivo MP3 encontrado
            for (File mp3File : mp3Files) {
                String fileName = mp3File.getName();
                // Remove a extensão ".mp3"
                String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
                // Divide o nome usando " - " para obter author e nome da música
                String[] nameParts = nameWithoutExtension.split("\\s+[-–]\\s+", 2);

                if (nameParts.length < 2) {
                    System.out.println("Formato do nome inválido: " + fileName);
                    continue;
                }
                String authorName = nameParts[0].trim();
                String songName = nameParts[1].trim();

                // Se o nome da música contiver "(", corta a parte adicional
                if (songName.contains("(")) {
                    songName = songName.substring(0, songName.indexOf("(")).trim();
                }
                if (songName.contains("[")) {
                    songName = songName.substring(0, songName.indexOf("[")).trim();
                }

                // Verifica se já existe uma música registrada com o mesmo author e name
                String newKey = buildSongKey(authorName, songName);
                System.out.println("DEBUG -> Key Arquivo: [" + newKey + "]");

                if (existingKeys.contains(newKey) && Boolean.FALSE) {
                    System.out.println("Música já registrada: " + authorName + " - " + songName);
                    FileComponents.deleteFile(mp3File);
                    continue;
                }

                Desktop.getDesktop().open(mp3File);
                // Solicita o tempo inicial para o corte (formato mm:ss ou segundos) para o arquivo atual
                System.out.println("Arquivo: " + fileName);
                System.out.print("Informe o tempo inicial para o corte (mm:ss ou apenas segundos): ");
                String startTime = inputScanner.nextLine().trim();

                // Se o usuário digitar apenas um número, converte para mm:ss
                if (!startTime.contains(":")) {
                    try {
                        int totalSeconds = Integer.parseInt(startTime);
                        int minutes = totalSeconds / 60;
                        int seconds = totalSeconds % 60;
                        startTime = String.format("%02d:%02d", minutes, seconds);
                    } catch (NumberFormatException e) {
                        System.out.println("Formato de tempo inválido para o arquivo: " + fileName);
                        continue;
                    }
                }

                // Define o nome do arquivo de saída (15 segundos)
                String outputFileName = "music" + nextID + ".mp3";

                // Prepara o comando do FFmpeg para cortar 15 segundos a partir do tempo informado e reencodar para 128kbps
                // Comando: ffmpeg -ss [startTime] -i input.mp3 -t 15 -b:a 128k output.mp3
                ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-ss", startTime, "-i", mp3File.getAbsolutePath(), "-t", "15", "-b:a", "128k", outputFileName);
                processBuilder.inheritIO(); // Redireciona a saída do processo para o console
                Process process = processBuilder.start();
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("Arquivo processado: " + outputFileName);
                } else {
                    System.out.println("Erro ao processar o arquivo: " + fileName);
                    continue;
                }

                // Cria uma nova entrada para o JSON
                JsonObject newEntryObj = new JsonObject();
                newEntryObj.addProperty("author", authorName);
                newEntryObj.addProperty("name", songName);
                newEntryObj.addProperty("ID", nextID);
                songsJsonArray.add(newEntryObj);

                nextID++; // Incrementa o ID para o próximo arquivo
                existingKeys.add(newKey);

                // Salva o arquivo musicquest.json atualizado formatado
                writeTextFile(jsonFile, GSON_PRETTY.toJson(songsJsonArray));
                FileComponents.deleteFile(mp3File);
            }

            // Salva o arquivo musicquest.json atualizado formatado no final também
            writeTextFile(jsonFile, GSON_PRETTY.toJson(songsJsonArray));

            System.out.println("Processamento concluído.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readTextFile(File file) throws Exception {
        if (!file.exists()) {
            return "";
        }

        byte[] fileBytes = Files.readAllBytes(file.toPath());

        // 1. Tenta ler como UTF-8 (Padrãozão)
        String textContent = new String(fileBytes, StandardCharsets.UTF_8);

        // Se o texto parecer "bêbado" (cheio de losangos ou caracteres nulos), tenta UTF-16LE
        if (textContent.contains("\u0000") || textContent.contains("†") || !textContent.trim().startsWith("[")) {
            System.out.println("DEBUG: O arquivo parece estar em UTF-16 (Coisa de Windows). Tentando converter...");
            textContent = new String(fileBytes, StandardCharsets.UTF_16LE);
        }

        // Se ainda assim não começar com [ ou {, tenta UTF-16BE (Big Endian)
        if (!textContent.trim().startsWith("[") && !textContent.trim().startsWith("{")) {
            textContent = new String(fileBytes, StandardCharsets.UTF_16BE);
        }

        return textContent;
    }

    private static String decodeStrict(byte[] bytes, Charset charset) throws Exception {
        var decoder = charset.newDecoder();
        decoder.onMalformedInput(CodingErrorAction.REPORT);
        decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return decoder.decode(ByteBuffer.wrap(bytes)).toString();
    }

    private static String decodeLenient(byte[] bytes, Charset charset) {
        try {
            var decoder = charset.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPLACE);
            decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            return decoder.decode(ByteBuffer.wrap(bytes)).toString();
        } catch (Throwable t) {
            return new String(bytes, StandardCharsets.ISO_8859_1);
        }
    }

    private static void writeTextFile(File file, String content) throws Exception {
        Files.writeString(
                file.toPath(),
                content,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    private static JsonArray cleanupAndCompactIds(File jsonFile, File outputFolder, Integer baseIdOverride) throws Exception {
        if (!jsonFile.exists()) {
            return new JsonArray();
        }

        JsonArray inputJsonArray = loadJsonArray(jsonFile);

        List<JsonObject> jsonItems = new ArrayList<>();
        for (int i = 0; i < inputJsonArray.size(); i++) {
            JsonElement element = inputJsonArray.get(i);
            if (element.isJsonObject()) {
                jsonItems.add(element.getAsJsonObject());
            }
        }

        // Ordena por ID atual
        jsonItems.sort(Comparator.comparingInt(o -> optInt(o, "ID", Integer.MAX_VALUE)));

        // 1) Remove inválidos + apaga mp3 inválido
        List<JsonObject> validItems = new ArrayList<>();
        for (JsonObject obj : jsonItems) {
            int currentId = optInt(obj, "ID", -1);
            String currentAuthor = optString(obj, "author", "").trim();
            String currentName = optString(obj, "name", "").trim();

            File mp3File = new File(outputFolder, "music" + currentId + ".mp3");

            boolean isInvalid =
                    currentId <= 0 ||
                            currentAuthor.isEmpty() ||
                            currentName.isEmpty() ||
                            looksCorrupted(currentAuthor) ||
                            looksCorrupted(currentName) ||
                            !mp3File.exists();

            if (isInvalid) {
                try {
                    Files.deleteIfExists(mp3File.toPath());
                    System.out.println("Removido inválido: ID " + currentId + " | " + currentAuthor + " - " + currentName);
                } catch (Exception e) {
                    System.out.println("Falha ao apagar mp3 inválido: " + mp3File.getName());
                    e.printStackTrace();
                }
                continue;
            }

            validItems.add(obj);
        }

        JsonArray resultJsonArray = new JsonArray();
        if (validItems.isEmpty()) {
            writeTextFile(jsonFile, GSON_PRETTY.toJson(resultJsonArray));
            System.out.println("Não sobrou nenhuma música válida. x-x");
            return resultJsonArray;
        }

        // 2) Define base: ou a que tu passou, ou o menor ID válido existente
        int baseId = (baseIdOverride != null) ? baseIdOverride : optInt(validItems.get(0), "ID", 1);

        // 3) Planeja renomeações e atualiza JSON
        List<RenamePlan> renamePlans = new ArrayList<>();
        int newId = baseId;

        for (JsonObject obj : validItems) {
            int oldId = optInt(obj, "ID", -1);
            int targetId = newId;

            if (oldId != targetId && oldId != -1) {
                File fromFile = new File(outputFolder, "music" + oldId + ".mp3");
                File toFile = new File(outputFolder, "music" + targetId + ".mp3");
                renamePlans.add(new RenamePlan(fromFile, toFile));

                obj.addProperty("ID", targetId);
            }

            resultJsonArray.add(obj);
            newId++;
        }

        // 4) Renomeia em 2 fases (evita colisão tipo 1233->1232 enquanto 1232 ainda existe)
        for (RenamePlan plan : renamePlans) {
            String tempName = plan.from.getName() + ".tmp_" + UUID.randomUUID();
            plan.tmpFile = new File(outputFolder, tempName);

            Files.move(
                    plan.from.toPath(),
                    plan.tmpFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
        }

        for (RenamePlan plan : renamePlans) {
            Files.move(
                    plan.tmpFile.toPath(),
                    plan.to.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Renomeado: " + plan.from.getName() + " -> " + plan.to.getName());
        }

        // 5) Salva JSON atualizado
        writeTextFile(jsonFile, GSON_PRETTY.toJson(resultJsonArray));
        System.out.println("Compactação concluída. Total: " + resultJsonArray.size() + " músicas. KKKKKKKKKKKKK");

        return resultJsonArray;
    }

    private static JsonArray loadJsonArray(File jsonFile) throws Exception {
        if (!jsonFile.exists()) {
            return new JsonArray();
        }

        String textContent = readTextFile(jsonFile);
        textContent = sanitizeJsonText(textContent);

        if (textContent.isEmpty()) {
            return new JsonArray();
        }

        try {
            JsonElement parsedElement = JsonParser.parseString(textContent);

            if (parsedElement.isJsonArray()) {
                return parsedElement.getAsJsonArray();
            }

            if (parsedElement.isJsonObject()) {
                JsonObject jsonObject = parsedElement.getAsJsonObject();

                // Se por algum motivo alguém salvou como objeto, tenta achar um array dentro
                if (jsonObject.has("songs") && jsonObject.get("songs").isJsonArray()) {
                    return jsonObject.get("songs").getAsJsonArray();
                }
                if (jsonObject.has("musics") && jsonObject.get("musics").isJsonArray()) {
                    return jsonObject.get("musics").getAsJsonArray();
                }
                if (jsonObject.has("musicas") && jsonObject.get("musicas").isJsonArray()) {
                    return jsonObject.get("musicas").getAsJsonArray();
                }

                // Se for um objeto único, embrulha num array pra não quebrar
                JsonArray fallbackArray = new JsonArray();
                fallbackArray.add(jsonObject);
                return fallbackArray;
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Erro cabuloso ao ler o JSON: " + e.getMessage());
        }

        // Se não deu pra entender, volta vazio
        return new JsonArray();
    }

    private static String sanitizeJsonText(String text) {
        if (text == null) {
            return "";
        }

        String t = text;

        // Remove BOM no início (o demônio invisível KKKKKKKKKKKKK)
        if (!t.isEmpty() && t.charAt(0) == '\uFEFF') {
            t = t.substring(1);
        }

        // Às vezes vem BOM perdido no meio, raro, mas tira também
        t = t.replace("\uFEFF", "");

        // Remove NULs (quando alguém salvou em UTF-16 e tu leu errado em algum momento)
        t = t.replace("\u0000", "");

        return t.trim();
    }

    private static boolean looksCorrupted(String text) {
        if (text == null || text.isBlank()) {
            return true;
        }

        // Marca clássica de texto quebrado
        if (text.indexOf('\uFFFD') >= 0) return true; // "?"
        if (text.contains("?")) return true;

        for (int i = 0; i < text.length(); i++) {
            Character.UnicodeBlock block = Character.UnicodeBlock.of(text.charAt(i));
            if (block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ||
                    block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ||
                    block == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ||
                    block == Character.UnicodeBlock.HIRAGANA ||
                    block == Character.UnicodeBlock.KATAKANA ||
                    block == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                    block == Character.UnicodeBlock.HANGUL_JAMO) {
                return true;
            }
        }

        return false;
    }

    private static class RenamePlan {
        final File from;
        final File to;
        File tmpFile;

        RenamePlan(File from, File to) {
            this.from = from;
            this.to = to;
        }
    }

}