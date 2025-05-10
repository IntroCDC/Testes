package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 10/01/2025 - 15:02
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public static void main(String[] args) {
        try {
            // Caminho para a imagem de fundo e o arquivo de saída
            File backgroundImageFile = new File("src/main/resources/background.png"); // Imagem de fundo (1024x1024)

            // Chamada ao método que cria a imagem
            createImageWithText("Texto Bonito", backgroundImageFile);
            System.out.println("Imagem gerada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createImageWithText(String text, File backgroundImageFile) throws IOException {
        // Carrega a imagem de fundo
        BufferedImage backgroundImage = ImageIO.read(backgroundImageFile);
        int width = backgroundImage.getWidth();
        int height = backgroundImage.getHeight();

        // Cria uma nova imagem baseada na imagem de fundo
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();

        // Desenha a imagem de fundo
        g2d.drawImage(backgroundImage, 0, 0, null);

        // Ajusta dinamicamente o tamanho da fonte
        int fontSize = calculateFontSize(g2d, text, width, height);
        g2d.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        g2d.setColor(Color.BLACK); // Cor do texto

        // Obtém as dimensões do texto para centralizá-lo
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        int x = (width - textWidth) / 2;
        int y = (height - textHeight) / 2 + fm.getAscent();

        // Desenha o texto na imagem
        g2d.drawString(text, x, y);

        // Finaliza os recursos gráficos
        g2d.dispose();

        // Salva a imagem em um arquivo
        File outputFile = new File(text.toLowerCase() + ".png");
        ImageIO.write(outputImage, "png", outputFile);
    }

    private static int calculateFontSize(Graphics2D g2d, String text, int width, int height) {
        int fontSize = 1; // Inicia com um tamanho mínimo
        FontMetrics fm;

        do {
            g2d.setFont(new Font("SansSerif", Font.BOLD, fontSize));
            fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getHeight();

            // Verifica se o texto ainda cabe dentro da imagem
            if (textWidth > width * 0.9 || textHeight > height * 0.9) {
                break;
            }

            fontSize++;
        } while (fontSize < height); // Limita para não ultrapassar o tamanho da imagem

        return fontSize - 1; // Retorna o maior tamanho de fonte que se encaixa
    }

}
