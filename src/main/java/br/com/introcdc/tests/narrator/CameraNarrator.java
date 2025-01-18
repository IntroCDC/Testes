package br.com.introcdc.tests.narrator;
/*
 * Written by IntroCDC, Bruno Coêlho at 22/08/2024 - 18:29
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CameraNarrator {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Passo 1: Espera 5 segundos para iniciar o programa
            System.out.println("O programa começará em 5 segundos...");
            Thread.sleep(5000);

            // Passo 2: Captura a tela do segundo monitor e coloca no clipboard
            BufferedImage screenFullImage = captureScreen(robot);
            copyImageToClipboard(screenFullImage);
            System.out.println("Captura de tela do segundo monitor realizada e copiada para o clipboard!");

            // Passo 3: Ctrl + 1 para ir para a primeira aba do navegador
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println("Navegador alternado para a primeira aba.");

            Thread.sleep(500);
            // Passo 4: Move o mouse para a posição X=811, Y=989
            int targetX = 811;
            int targetY = 989;
            robot.mouseMove(targetX, targetY);
            System.out.println("Mouse movido para: X=" + targetX + ", Y=" + targetY);

            // Passo 5: Clica para copiar o texto
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Texto copiado.");

            // Passo 6: Ctrl + V para colar a imagem no chat
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println("Imagem colada no chat.");

            // Passo 7: Espera 5 segundos antes de enviar a imagem
            Thread.sleep(5000);

            // Passo 8: Enter para enviar a imagem
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Imagem enviada.");

            // Passo 9: Espera 30 segundos para o texto ser gerado
            Thread.sleep(30000);

            // Passo 10: Move o mouse para a posição X=796, Y=872
            targetX = 796;
            targetY = 872;
            robot.mouseMove(targetX, targetY);
            System.out.println("Mouse movido para: X=" + targetX + ", Y=" + targetY);

            // Passo 11: Scrola para baixo umas 5 vezes
            for (int i = 0; i < 5; i++) {
                robot.mouseWheel(5);
                Thread.sleep(500);
            }
            System.out.println("Scroll para baixo realizado.");

            // Passo 12: Clica para copiar o texto
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Texto copiado.");

            Thread.sleep(500);

            // Passo 13: Abre o URL da API de voz no navegador
            String copiedText = getTextFromClipboard();
            openUrlInBrowser(copiedText);
            System.out.println("Texto enviado para a API de voz e aberto no navegador!");

            // Passo 14: Espera 5 segundos para a voz ler o texto e repete o loop
            Thread.sleep(5000);

            // Loop infinito para repetir o processo
            main(args);

        } catch (AWTException | InterruptedException | IOException | UnsupportedFlavorException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    private static BufferedImage captureScreen(Robot robot) throws AWTException {
        // Obtém o segundo monitor
        Rectangle screenRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1].getDefaultConfiguration().getBounds();
        return robot.createScreenCapture(screenRect);
    }

    private static void copyImageToClipboard(BufferedImage image) throws IOException {
        File tempFile = new File("screencapture.png");
        ImageIO.write(image, "png", tempFile);
        ImageSelection imgSel = new ImageSelection(image);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(imgSel, null);
    }

    private static String getTextFromClipboard() throws UnsupportedFlavorException, IOException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            String text = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            return new String(text.getBytes(), StandardCharsets.UTF_8);
        }
        return "";
    }

    private static void openUrlInBrowser(String text) {
        try {
            // URL da API
            String apiUrl = "http://api.kindome.com.br/voice/";
            String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
            URI uri = new URI(apiUrl + encodedText);

            // Abre o URL no navegador padrão
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
