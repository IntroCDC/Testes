package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 30/05/2025 - 03:37
 */

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.List;

public class AutoPoster {

    // ? Ajuste se necessário
    private static final Path dir = Paths.get("C:\\Users\\Bruno\\Downloads\\MiniGames");
    private static final String jsonFile = "info.json";
    private static final int imageCount = 200;       // 1.png … 200.png
    private static final int waitUploadMs = 3_000;     // 3 s pro upload

    private static class Info {
        String name;
        String description;
    }

    public static void main(String[] args) throws Exception {
        List<Info> infos = loadInfo();

        if (infos.size() < imageCount)
            throw new IllegalStateException("JSON tem menos entradas que imagens!");

        Robot robot = new Robot();
        robot.setAutoDelay(120); // delay padrão entre teclas

        for (int i = 1; i <= imageCount; i++) {
            Info info = infos.get(i - 1);

            // 1??  Copia texto “# Nome\nDescrição”
            String text = "# " + info.name + System.lineSeparator() + info.description;
            copyToClipboard(text);

            // 1??  Ctrl+V (cola texto)
            paste(robot);

            // 2??  Copia a imagem correspondente
            Path imgPath = dir.resolve(i + ".png");
            copyImageToClipboard(imgPath);

            // 2??  Ctrl+V (cola imagem)
            paste(robot);

            // 3??  Espera upload e dá Enter
            robot.delay(waitUploadMs);
            pressEnter(robot);

            // 4??  Pequena pausa entre ciclos (opcional)
            robot.delay(500);
        }

        System.out.println("Postagem automática concluída! :)");
    }

    /* ---------- utilitários ---------- */

    private static List<Info> loadInfo() throws IOException {
        try (Reader r = Files.newBufferedReader(dir.resolve(jsonFile))) {
            Type listType = new TypeToken<List<Info>>() {
            }.getType();
            return new Gson().fromJson(r, listType);
        }
    }

    private static void copyToClipboard(String data) {
        StringSelection selection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

    private static void copyImageToClipboard(Path imgPath) throws IOException {
        BufferedImage img = ImageIO.read(imgPath.toFile());
        Transferable t = new Transferable() {
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.imageFlavor};
            }

            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return DataFlavor.imageFlavor.equals(flavor);
            }

            public Object getTransferData(DataFlavor flavor) {
                return img;
            }
        };
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
    }

    private static void paste(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private static void pressEnter(Robot robot) {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}

