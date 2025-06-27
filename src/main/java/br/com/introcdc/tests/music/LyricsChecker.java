package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 27/06/2025 - 20:38
 */

import java.io.File;

public class LyricsChecker {

    public static void main(String[] args) {
        File lyricsFolder = new File("F:/Musicas/assets/lyrics");

        if (!lyricsFolder.isDirectory()) {
            System.out.println("Pasta n�o encontrada: " + lyricsFolder.getAbsolutePath());
            return;
        }

        // Pega todos os arquivos .txt existentes
        String[] existingFiles = lyricsFolder.list((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (existingFiles == null) {
            System.out.println("Erro ao listar arquivos na pasta.");
            return;
        }

        System.out.println("Verificando letras das m�sicas no Kindome...\n");

        for (Music music : Music.values()) {
            String lyricsPath = music.getLyricsPath().replace("/", "\\"); // Para garantir consist�ncia no Windows

            File lyricsFile = new File("F:/Musicas/" + lyricsPath);

            if (!lyricsFile.exists()) {
                System.out.println("FALTA: " + lyricsFile.getName());
            }
        }

        System.out.println("\nVerifica��o conclu�da!");
    }
}

