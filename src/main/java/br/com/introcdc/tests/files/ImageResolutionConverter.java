package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coêlho at 07/01/2025 - 23:25
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResolutionConverter {

    public static void resizeImage(String inputImagePath, String outputImagePath, int width, int height) throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));

        Image tmpImage = inputImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(tmpImage, 0, 0, null);
        g2d.dispose();

        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
        ImageIO.write(outputImage, "png", new File(outputImagePath));
    }

    public static void main(String[] args) {
        String inputImagePath = "eternity.jpg";
        String outputImagePath = inputImagePath.substring(0, inputImagePath.lastIndexOf('.')) + ".png";
        int newWidth = 300;
        int newHeight = 300;

        try {
            resizeImage(inputImagePath, outputImagePath, newWidth, newHeight);
            System.out.println("Imagem redimensionada com sucesso!");
        } catch (IOException ex) {
            System.out.println("Erro ao redimensionar a imagem.");
            ex.printStackTrace();
        }
    }

}
