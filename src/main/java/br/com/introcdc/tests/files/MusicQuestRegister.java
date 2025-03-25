package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coêlho at 22/03/2025 - 06:18
 */

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Scanner;
import javax.swing.JFileChooser;

import br.com.introcdc.tests.advmusic.MP3Musica;
import br.com.introcdc.tests.database.FileComponents;
import org.json.JSONArray;
import org.json.JSONObject;

public class MusicQuestRegister {

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
            File jsonFile = new File("musicquest.json");
            JSONArray musicasJson;
            if (jsonFile.exists()) {
                String conteudo = new String(Files.readAllBytes(jsonFile.toPath()));
                musicasJson = new JSONArray(conteudo);
            } else {
                musicasJson = new JSONArray();
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
                String[] partes = nomeSemExtensao.split(" - ");
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
                boolean jaRegistrada = false;
                for (int i = 0; i < musicasJson.length(); i++) {
                    JSONObject obj = musicasJson.getJSONObject(i);
                    String regAutor = obj.getString("author");
                    String regNome = obj.getString("name");
                    if (regAutor.equalsIgnoreCase(autor) && regNome.equalsIgnoreCase(nomeMusica)) {
                        jaRegistrada = true;
                        break;
                    }
                }
                if (jaRegistrada) {
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

                // Salva o arquivo musicquest.json atualizado
                try (FileWriter fw = new FileWriter(jsonFile)) {
                    fw.write(musicasJson.toString(4)); // formata com indentação
                }
                FileComponents.deleteFile(mp3);
            }

            // Salva o arquivo musicquest.json atualizado
            try (FileWriter fw = new FileWriter(jsonFile)) {
                fw.write(musicasJson.toString(4)); // formata com indentação
            }

            System.out.println("Processamento concluído.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
