package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 18/06/2025 - 07:58
 */

import java.io.File;

public class MusicConversor {

    public static boolean MISTER_IA = true;

    public static void main(String[] args) {
        File directory = new File("C:/Users/Bruno/Downloads");
        if (!directory.isDirectory()) {
            System.out.println("O caminho não é uma pasta válida.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Não consegui listar os arquivos.");
            return;
        }

        for (File file : files) {
            String name = file.getName();
            String renamed = null;

            if (MISTER_IA) {
                if (name.startsWith("IA - ")) {
                    renamed = "Mister IA - " + name.substring(5);
                } else if (name.startsWith("ia - ")) {
                    renamed = "mister ia - " + name.substring(5);
                }
            } else {
                if (name.startsWith("Mister IA - ")) {
                    renamed = "IA - " + name.substring(12);
                } else if (name.startsWith("mister ia - ")) {
                    renamed = "ia - " + name.substring(12);
                }
            }

            if (renamed != null) {
                File dst = new File(directory, renamed);
                if (file.renameTo(dst)) {
                    System.out.println("? \"" + name + "\" ? \"" + renamed + "\"");
                } else {
                    System.out.println("? Falha ao renomear \"" + name + "\"");
                }
            }
        }

        System.out.println("Renomeação finalizada");
    }

}
