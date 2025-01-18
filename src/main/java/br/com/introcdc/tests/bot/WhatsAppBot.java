package br.com.introcdc.tests.bot;
/*
 * Written by IntroCDC, Bruno Coêlho at 09/03/2024 - 04:34
 */

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class WhatsAppBot {

    private static Robot robot;
    public static String lastClipboard = "";

    public static void main(String[] args) throws Exception {
        robot.mouseMove(773, 801);
        Thread.sleep(10);
        for (int i = 1; i <= 3; i++) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(10);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String clipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);
        if (clipboardContent.equalsIgnoreCase(lastClipboard)) {
            Thread.sleep(5000);
            main(args);
            return;
        }
        lastClipboard = clipboardContent;

        String reply = BotBrain.replyTo(clipboardContent);
        StringSelection selection = new StringSelection(reply);
        clipboard.setContents(selection, null);

        robot.mouseMove(766, 960);
        Thread.sleep(10);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);
        main(args);
    }

}
