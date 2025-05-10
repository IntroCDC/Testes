package br.com.introcdc.tests.discord;
/*
 * Written by IntroCDC, Bruno Coelho at 26/12/2022 - 13:53
 */

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SpoteffChecker {

    private final Robot robot;

    public SpoteffChecker() throws Exception {
        robot = new Robot();
    }

    public Robot getRobot() {
        return robot;
    }

    public boolean checkAndApply() throws Exception {
        if (stop()) {
            System.exit(0);
            return false;
        }
        getRobot().mouseMove(401, 938);
        getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
        getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
        getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_C);
        Thread.sleep(10);
        getRobot().keyRelease(KeyEvent.VK_C);
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(50);

        String data = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
        if (data.contains("5554")) {
            getRobot().keyPress(KeyEvent.VK_5);
            getRobot().keyRelease(KeyEvent.VK_5);
            Thread.sleep(10);
            getRobot().keyPress(KeyEvent.VK_5);
            getRobot().keyRelease(KeyEvent.VK_5);
            Thread.sleep(10);
            getRobot().keyPress(KeyEvent.VK_5);
            getRobot().keyRelease(KeyEvent.VK_5);
            Thread.sleep(10);
            getRobot().keyPress(KeyEvent.VK_5);
            getRobot().keyRelease(KeyEvent.VK_5);
            Thread.sleep(10);
            getRobot().keyPress(KeyEvent.VK_ENTER);
            getRobot().keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10);
            System.exit(0);
            return true;
        }
        return false;
    }

    public boolean stop() {
        return new File("F:/IntroCDC/stop").exists();
    }

}
