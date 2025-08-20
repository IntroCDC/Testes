package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 07/01/2025 - 23:25
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResolutionConverter {

    public static void resizeImage(File file, String outputImagePath, String format, int width, int height) throws Exception {
        BufferedImage inputImage = ImageIO.read(file);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width e height devem ser > 0");
        }

        // Define o formato de saída (prioriza o parâmetro; se vier nulo/vazio, usa a extensão do arquivo)
        String fmt = (format != null && !format.isBlank())
                ? format.trim().toLowerCase()
                : outputImagePath.substring(outputImagePath.lastIndexOf('.') + 1).toLowerCase();

        // Formatos sem alpha -> RGB; com alpha -> ARGB
        boolean supportsAlpha = fmt.equals("png") || fmt.equals("webp") || fmt.equals("gif");
        int imageType = supportsAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;

        BufferedImage outputImage = new BufferedImage(width, height, imageType);
        Graphics2D g2d = outputImage.createGraphics();

        // Qualidade top
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Faz o scale direto mantendo a qualidade
        g2d.drawImage(inputImage, 0, 0, width, height, null);
        g2d.dispose();

        // Garante diretório de saída
        File out = new File(outputImagePath);
        File parent = out.getParentFile();
        if (parent != null) parent.mkdirs();

        if (!ImageIO.write(outputImage, fmt, out)) {
            throw new IOException("Falha ao escrever a imagem no formato: " + fmt);
        }
    }

    public static void main(String[] args) throws Exception {
        String inputImagePath = "eternity.jpg";
        String outputImagePath = inputImagePath.substring(0, inputImagePath.lastIndexOf('.')) + ".png";
        int newWidth = 300;
        int newHeight = 300;

        try {
            resizeImage(new File(inputImagePath), outputImagePath, "png", newWidth, newHeight);
            System.out.println("Imagem redimensionada com sucesso!");
        } catch (IOException ex) {
            System.out.println("Erro ao redimensionar a imagem.");
            ex.printStackTrace();
        }
    }

}
