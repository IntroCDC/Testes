package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 01/11/2024 - 00:47
 */

import br.com.introcdc.tests.advmusic.MP3Musica;

import java.io.File;
import java.util.*;

public class MusicVerifier {

    public static Map<String, Integer> note = new HashMap<>();
    public static MP3Musica mp3;
    public static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Dê notas de 0 a 100!");
        mp3 = new MP3Musica();
        scanner = new Scanner(System.in);
        List<File> toSee = new ArrayList<>();
        for (File file : new File("F:/Musicas/IA").listFiles()) {
            if (!file.getName().endsWith(".mp3")) {
                continue;
            }
            if (verify(file)) {
                continue;
            }
            toSee.add(file);
        }

        System.out.println("Músicas para analisar: " + toSee.size());
        for (File file : toSee) {
            verifyMusic(file);
        }

        System.out.print("Quantas músicas mostrar? ");
        List<String> ignore = new ArrayList<>();
        for (int i = 1; i <= scanner.nextInt(); i++) {
            String more = null;
            int moreN = -1;
            for (String key : note.keySet()) {
                if (ignore.contains(key)) {
                    continue;
                }
                if (note.get(key) > moreN) {
                    more = key;
                    moreN = note.get(key);
                }
            }

            ignore.add(more);
            System.out.println(i + "º: " + more);
        }
    }

    public static void verifyMusic(File file) {
        mp3.stopPlaying();
        mp3 = new MP3Musica();
        mp3.tocar(file);
        mp3.start();
        System.out.print(file.getName() + ": ");
        note.put(file.getName(), scanner.nextInt());
    }

    public static boolean verify(File file) {
        String fileName = file.getName().split(" - ")[1];
        for (int i = 20; i >= 1; i--) {
            fileName = fileName.replace(" " + i, "");
        }
        File check = new File("F:/Musicas/Mister IA/Mister IA - " + fileName);
        if (check.exists()) {
            return true;
        }
        for (int i = 20; i > 1; i--) {
            if (file.getName().endsWith(i + ".mp3")) {
                return true;
            }
        }
        return false;
    }

}
