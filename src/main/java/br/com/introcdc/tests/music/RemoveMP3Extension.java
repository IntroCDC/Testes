package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 27/06/2025 - 20:22
 */

import java.io.File;

public class RemoveMP3Extension {
    public static void main(String[] args) {
        // Caminho da pasta com os arquivos
        File folder = new File("F:\\Musicas\\assets\\lyrics");

        // Verifica se é pasta
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();

                    // Se o nome contém ".mp3.txt", renomeia
                    if (fileName.contains(".mp3.txt")) {
                        String newFileName = fileName.replace(".mp3.txt", ".txt");

                        // Cria novo arquivo com o nome modificado no mesmo diretório
                        File newFile = new File(folder, newFileName);

                        boolean success = file.renameTo(newFile);

                        if (success) {
                            System.out.println("Renomeado: " + fileName + " -> " + newFileName);
                        } else {
                            System.out.println("Falha ao renomear: " + fileName);
                        }
                    }
                }
            } else {
                System.out.println("Pasta vazia.");
            }
        } else {
            System.out.println("Caminho inválido.");
        }
    }
}

