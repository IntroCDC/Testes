package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coêlho at 11/02/2025 - 03:45
 */

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.PrintWriter;

public class TextCreator {

    public static void main(String[] args) throws Exception {
        String lastClip = setClipboard("Iniciando...");
        Thread.sleep(100);
        File file = new File("F:/Musicas/Mister IA");
        for (File music : file.listFiles()) {
            Thread.sleep(100);
            File lyrics = new File("F:/Musicas/assets/lyrics/" + music.getName().toLowerCase() + ".txt");
            if (lyrics.exists()) {
                continue;
            }
            System.out.println("Música: " + music.getName());
            lastClip = setClipboard(music.getName().split(" - ")[1].replace(".mp3", ""));
            while (true) {
                Thread.sleep(100);
                String clip = clipboard();
                if (clip == null || clip.equals(lastClip)) {
                    continue;
                }
                PrintWriter writer = new PrintWriter(lyrics);
                writer.println(clip
                        .replace("[Verse 1]\n", "")
                        .replace("[Verse 2]\n", "")
                        .replace("[Verse 3]\n", "")
                        .replace("[Verse 4]\n", "")
                        .replace("[Verse 5]\n", "")
                        .replace("[Verse 6]\n", "")
                        .replace("[Verse 7]\n", "")
                        .replace("[Verse 8]\n", "")
                        .replace("[Verse 9]\n", "")
                        .replace("[Verse 10]\n", "")
                        .replace("[Verse]\n", "")
                        .replace("[Chorus]\n", "")
                        .replace("[Pre-chorus]\n", "")
                        .replace("[Bridge]\n", "")
                        .replace("[Final]\n", ""));
                writer.flush();
                writer.close();
                lastClip = clip;
                break;
            }
        }
    }

    public static String clipboard() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);
                return clipboardText;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String setClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return text;
    }

}
