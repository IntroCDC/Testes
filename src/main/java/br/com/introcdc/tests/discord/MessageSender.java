package br.com.introcdc.tests.discord;
/*
 * Written by IntroCDC, Bruno Coêlho at 29/11/2024 - 02:05
 */

import br.com.introcdc.tests.audio.Audio;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MessageSender {

    public static void main(String[] args) throws Exception {
        System.out.println("Enviando em 20 segundos!");
        Robot robot = new Robot();
        for (int i = 1; i <= 20; i++) {
            Audio.generateBeep(1000, 100 * i);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("ENVIADA!");
        Audio.generateBeep(10000, 3000);
    }

}
