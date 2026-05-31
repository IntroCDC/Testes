package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 22/05/2026 - 23:18
 */

import java.io.File;

public class ImageVerifier {

    public static void main(String[] args) {
        for (File file : new File("C:/Users/Bruno/Downloads").listFiles()) {
            File verify = new File("C:/Kindome/site/assets/images/maps/" + file.getName().replace(".png", ".jpg"));
            if (!verify.exists()) {
                System.out.println("Arquivo não encontrado: " + file.getName());
            }
        }
    }

}
