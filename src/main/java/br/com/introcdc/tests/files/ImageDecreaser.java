package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 12/08/2025 - 01:11
 */

import br.com.introcdc.tests.database.FileComponents;

import java.io.File;

public class ImageDecreaser {

    public static void main(String[] args) throws Exception {
        for (File file : new File("C:/Users/Bruno/Downloads").listFiles()) {
            if (!file.getName().endsWith(".png")) {
                continue;
            }
            ImageResolutionConverter.resizeImage(file, "C:/Users/Bruno/Downloads/" + file.getName().replace(".png", ".jpg"), "jpg", 256, 256);
            FileComponents.deleteFile(file);
        }
    }

}
