package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 24/10/2024 - 13:26
 */

import br.com.introcdc.tests.Main;
import br.com.introcdc.tests.database.FileComponents;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {

    public static void main(String[] args) {
        for (File file : new File(args.length == 0 ? "C:/Users/Bruno/Downloads" : Main.arg(args)).listFiles()) {
            convertImage(file, "png", "jpg");
        }
    }

    public static void convertImage(File file, String from, String to) {
        if (!file.getName().endsWith("." + from)) {
            return;
        }
        try {
            System.out.println(file.getName());
            BufferedImage image = ImageIO.read(file);

            if (image == null) {
                System.out.println("Erro ao ler a imagem. Certifique-se de que o formato .webp está suportado.");
                return;
            }

            File search = new File(file.getAbsolutePath().replace("." + from, "." + to));
            if (search.exists()) {
                System.out.println("Arquivo já existente: " + search.getName());
                return;
            }
            ImageIO.write(image, to, search);
            FileComponents.deleteFile(file);
            System.out.println("Conversão concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro durante a conversão: " + e.getMessage());
        }
    }

}
