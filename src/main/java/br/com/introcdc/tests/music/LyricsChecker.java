package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 27/06/2025 - 20:38
 */

import java.io.File;

public class LyricsChecker {

    public static void main(String[] args) {
        File lyricsFolder = new File("F:/Musicas/assets/lyrics");

        if (!lyricsFolder.isDirectory()) {
            System.out.println("Pasta não encontrada: " + lyricsFolder.getAbsolutePath());
            return;
        }

        // Pega todos os arquivos .txt existentes
        String[] existingFiles = lyricsFolder.list((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (existingFiles == null) {
            System.out.println("Erro ao listar arquivos na pasta.");
            return;
        }

        System.out.println("Verificando letras das músicas no Kindome...\n");

        for (Music music : Music.values()) {
            String lyricsPath = music.getLyricsPath().replace("/", "\\"); // Para garantir consistência no Windows

            File lyricsFile = new File("F:/Musicas/" + lyricsPath);

            if (!lyricsFile.exists()) {
                System.out.println("FALTA: " + lyricsFile.getName());
            }
        }

        System.out.println("\nVerificação concluída!");
    }
}

