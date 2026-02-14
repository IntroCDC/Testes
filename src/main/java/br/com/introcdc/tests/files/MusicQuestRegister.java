package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 22/03/2025 - 06:18
 */

import br.com.introcdc.tests.database.FileComponents;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

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

public class MusicQuestRegister {

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

    public static void main(String[] args) {
        try {
            // Seleciona a pasta onde estão os arquivos MP3
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int opcao = chooser.showOpenDialog(null);
            if (opcao != JFileChooser.APPROVE_OPTION) {
                System.out.println("Pasta não selecionada. Encerrando...");
                return;
            }
            File pastaSelecionada = chooser.getSelectedFile();

            // Lista os arquivos MP3 na pasta selecionada
            File[] arquivos = pastaSelecionada.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".mp3");
                }
            });

            if (arquivos == null || arquivos.length == 0) {
                System.out.println("Nenhum arquivo MP3 encontrado na pasta selecionada.");
                return;
            }

            // Cria um Scanner para ler as entradas do usuário
            Scanner scanner = new Scanner(System.in);

// Carrega (ou cria) o arquivo musicquest.json
// Carrega (ou cria) o arquivo musicquest.json
            File jsonFile = new File("musicquest.json");
            System.out.println("=== DIAGNÓSTICO DO ARQUIVO ===");
            System.out.println("Caminho: " + jsonFile.getAbsolutePath());

            if (jsonFile.exists()) {
                System.out.println("Status: O arquivo EXISTE.");
                System.out.println("Tamanho em disco: " + jsonFile.length() + " bytes.");

                // Vamos ler na marra pra ver o que tem dentro
                String conteudoReal = readTextFile(jsonFile);
                System.out.println("--- CONTEÚDO QUE O JAVA LEU ---");
                System.out.println(conteudoReal); // AQUI VAI MOSTRAR A VERDADE
                System.out.println("-------------------------------");
            } else {
                System.out.println("Status: O arquivo NÃO EXISTE (O Java tá cegueta ou tu não criou nessa pasta).");
                System.out.println("Criando array vazio na memória...");
            }

            JSONArray musicasJson = loadJsonArray(jsonFile);
            System.out.println("Total de objetos entendidos pelo JSON: " + musicasJson.length());
            System.out.println("==============================");

            Set<String> existingKeys = new HashSet<>();
            for (int i = 0; i < musicasJson.length(); i++) {
                JSONObject obj = musicasJson.getJSONObject(i);
                String regAuthor = obj.optString("author", "");
                String regName = obj.optString("name", "");
                String key = buildSongKey(regAuthor, regName);

                // Printa só pra gente ver se a IA tá lá (pode comentar depois)
                if (regAuthor.equalsIgnoreCase("IA")) {
                    System.out.println("JSON LOAD -> " + regAuthor + " | " + regName + " => Key: [" + key + "]");
                }

                existingKeys.add(key);
            }

            // Determina o próximo ID com base no último registrado
            int nextID = 1;
            for (int i = 0; i < musicasJson.length(); i++) {
                JSONObject obj = musicasJson.getJSONObject(i);
                int id = obj.getInt("ID");
                if (id >= nextID) {
                    nextID = id + 1;
                }
            }

            // Processa cada arquivo MP3 encontrado
            for (File mp3 : arquivos) {
                String nomeArquivo = mp3.getName();
                // Remove a extensão ".mp3"
                String nomeSemExtensao = nomeArquivo.substring(0, nomeArquivo.lastIndexOf("."));
                // Divide o nome usando " - " para obter author e nome da música
                String[] partes = nomeSemExtensao.split("\\s+[-–]\\s+", 2);
                if (partes.length < 2) {
                    System.out.println("Formato do nome inválido: " + nomeArquivo);
                    continue;
                }
                String autor = partes[0].trim();
                String nomeMusica = partes[1].trim();

                // Se o nome da música contiver "(", corta a parte adicional
                if (nomeMusica.contains("(")) {
                    nomeMusica = nomeMusica.substring(0, nomeMusica.indexOf("(")).trim();
                }
                if (nomeMusica.contains("[")) {
                    nomeMusica = nomeMusica.substring(0, nomeMusica.indexOf("[")).trim();
                }

                // Verifica se já existe uma música registrada com o mesmo author e name
                String newKey = buildSongKey(autor, nomeMusica);
                System.out.println("DEBUG -> Key Arquivo: [" + newKey + "]");

                if (existingKeys.contains(newKey) && Boolean.FALSE) {
                    System.out.println("Música já registrada: " + autor + " - " + nomeMusica);
                    FileComponents.deleteFile(mp3);
                    continue;
                }

                Desktop.getDesktop().open(mp3);
                // Solicita o tempo inicial para o corte (formato mm:ss ou segundos) para o arquivo atual
                System.out.println("Arquivo: " + nomeArquivo);
                System.out.print("Informe o tempo inicial para o corte (mm:ss ou apenas segundos): ");
                String tempoInicial = scanner.nextLine().trim();
                // Se o usuário digitar apenas um número, converte para mm:ss
                if (!tempoInicial.contains(":")) {
                    try {
                        int totalSegundos = Integer.parseInt(tempoInicial);
                        int minutos = totalSegundos / 60;
                        int segundos = totalSegundos % 60;
                        tempoInicial = String.format("%02d:%02d", minutos, segundos);
                    } catch (NumberFormatException e) {
                        System.out.println("Formato de tempo inválido para o arquivo: " + nomeArquivo);
                        continue;
                    }
                }

                // Define o nome do arquivo de saída (15 segundos)
                String nomeSaida = "music" + nextID + ".mp3";

                // Prepara o comando do FFmpeg para cortar 15 segundos a partir do tempo informado e reencodar para 128kbps
                // Comando: ffmpeg -ss [tempoInicial] -i input.mp3 -t 15 -b:a 128k output.mp3
                ProcessBuilder pb = new ProcessBuilder("ffmpeg", "-ss", tempoInicial, "-i", mp3.getAbsolutePath(), "-t", "15", "-b:a", "128k", nomeSaida);
                pb.inheritIO(); // Redireciona a saída do processo para o console
                Process process = pb.start();
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Arquivo processado: " + nomeSaida);
                } else {
                    System.out.println("Erro ao processar o arquivo: " + nomeArquivo);
                    continue;
                }

                // Cria uma nova entrada para o JSON
                JSONObject novaEntrada = new JSONObject();
                novaEntrada.put("author", autor);
                novaEntrada.put("name", nomeMusica);
                novaEntrada.put("ID", nextID);
                musicasJson.put(novaEntrada);

                nextID++; // Incrementa o ID para o próximo arquivo
                existingKeys.add(newKey);

                // Salva o arquivo musicquest.json atualizado
                writeTextFile(jsonFile, musicasJson.toString(4));
                FileComponents.deleteFile(mp3);
            }

            // Salva o arquivo musicquest.json atualizado
            writeTextFile(jsonFile, musicasJson.toString(4));

            System.out.println("Processamento concluído.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readTextFile(File file) throws Exception {
        if (!file.exists()) {
            return "";
        }

        byte[] bytes = Files.readAllBytes(file.toPath());

        // 1. Tenta ler como UTF-8 (Padrãozão)
        String texto = new String(bytes, StandardCharsets.UTF_8);

        // Se o texto parecer "bêbado" (cheio de losangos ou caracteres nulos), tenta UTF-16LE
        // O caractere '' ou muitos espaços vazios indicam que lemos errado.
        if (texto.contains("\u0000") || texto.contains("†") || !texto.trim().startsWith("[")) {
            System.out.println("DEBUG: O arquivo parece estar em UTF-16 (Coisa de Windows). Tentando converter...");
            texto = new String(bytes, StandardCharsets.UTF_16LE);
        }

        // Se ainda assim não começar com [ ou {, tenta UTF-16BE (Big Endian)
        if (!texto.trim().startsWith("[") && !texto.trim().startsWith("{")) {
            texto = new String(bytes, StandardCharsets.UTF_16BE);
        }

        return texto;
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
            // se até isso falhar (muito raro), cai pra ISO-8859-1
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

    private static JSONArray cleanupAndCompactIds(File jsonFile, File outputFolder, Integer baseIdOverride) throws Exception {
        if (!jsonFile.exists()) {
            return new JSONArray();
        }

        JSONArray input = loadJsonArray(jsonFile);

        ArrayList<JSONObject> items = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Object v = input.get(i);
            if (v instanceof JSONObject obj) {
                items.add(obj);
            }
        }

        // Ordena por ID atual
        items.sort(Comparator.comparingInt(o -> o.optInt("ID", Integer.MAX_VALUE)));

        // 1) Remove inválidos + apaga mp3 inválido
        ArrayList<JSONObject> valid = new ArrayList<>();
        for (JSONObject obj : items) {
            int id = obj.optInt("ID", -1);
            String author = obj.optString("author", "").trim();
            String name = obj.optString("name", "").trim();

            File mp3File = new File(outputFolder, "music" + id + ".mp3");

            boolean invalid =
                    id <= 0 ||
                            author.isEmpty() ||
                            name.isEmpty() ||
                            looksCorrupted(author) ||
                            looksCorrupted(name) ||
                            !mp3File.exists(); // se sumiu o mp3, remove do JSON também pra ficar consistente

            if (invalid) {
                try {
                    java.nio.file.Files.deleteIfExists(mp3File.toPath());
                    System.out.println("Removido inválido: ID " + id + " | " + author + " - " + name);
                } catch (Exception e) {
                    System.out.println("Falha ao apagar mp3 inválido: " + mp3File.getName());
                    e.printStackTrace();
                }
                continue;
            }

            valid.add(obj);
        }

        JSONArray result = new JSONArray();
        if (valid.isEmpty()) {
            writeTextFile(jsonFile, result.toString(4));
            System.out.println("Não sobrou nenhuma música válida. x-x");
            return result;
        }

        // 2) Define base: ou a que tu passou, ou o menor ID válido existente
        int baseId = (baseIdOverride != null) ? baseIdOverride : valid.get(0).optInt("ID");

        // 3) Planeja renomeações e atualiza JSON
        ArrayList<RenamePlan> renamePlans = new ArrayList<>();
        int newId = baseId;

        for (JSONObject obj : valid) {
            int oldId = obj.optInt("ID");
            int targetId = newId;

            if (oldId != targetId) {
                File from = new File(outputFolder, "music" + oldId + ".mp3");
                File to = new File(outputFolder, "music" + targetId + ".mp3");
                renamePlans.add(new RenamePlan(from, to));

                obj.put("ID", targetId);
            }

            result.put(obj);
            newId++;
        }

        // 4) Renomeia em 2 fases (evita colisão tipo 1233->1232 enquanto 1232 ainda existe)
        for (RenamePlan plan : renamePlans) {
            String tmpName = plan.from.getName() + ".tmp_" + UUID.randomUUID();
            plan.tmp = new File(outputFolder, tmpName);

            java.nio.file.Files.move(
                    plan.from.toPath(),
                    plan.tmp.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
        }

        for (RenamePlan plan : renamePlans) {
            java.nio.file.Files.move(
                    plan.tmp.toPath(),
                    plan.to.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Renomeado: " + plan.from.getName() + " -> " + plan.to.getName());
        }

        // 5) Salva JSON atualizado
        writeTextFile(jsonFile, result.toString(4));
        System.out.println("Compactação concluída. Total: " + result.length() + " músicas. KKKKKKKKKKKKK");

        return result;
    }

    private static JSONArray loadJsonArray(File jsonFile) throws Exception {
        if (!jsonFile.exists()) {
            return new JSONArray();
        }

        String text = readTextFile(jsonFile);
        text = sanitizeJsonText(text);

        if (text.isEmpty()) {
            return new JSONArray();
        }

        Object parsed = new JSONTokener(text).nextValue();

        if (parsed instanceof JSONArray array) {
            return array;
        }

        if (parsed instanceof JSONObject object) {
            // Se por algum motivo alguém salvou como objeto, tenta achar um array dentro
            if (object.has("songs") && object.get("songs") instanceof JSONArray a) {
                return a;
            }
            if (object.has("musics") && object.get("musics") instanceof JSONArray a) {
                return a;
            }
            if (object.has("musicas") && object.get("musicas") instanceof JSONArray a) {
                return a;
            }
            // Se for um objeto único, embrulha num array pra não quebrar
            return new JSONArray().put(object);
        }

        // Se não deu pra entender, volta vazio
        return new JSONArray();
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

        // Se aparecer CJK/Hangul/Hiragana/Katakana, costuma ser “N?...”
        // Se tu tiver músicas com japonês/chinês de propósito, remove esse bloco.
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
        File tmp;

        RenamePlan(File from, File to) {
            this.from = from;
            this.to = to;
        }
    }

}
