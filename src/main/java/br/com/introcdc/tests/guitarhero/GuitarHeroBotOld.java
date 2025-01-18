package br.com.introcdc.tests.guitarhero;
/*
 * Written by IntroCDC, Bruno Coêlho at 14/05/2021 - 15:55
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuitarHeroBotOld {

    public static Robot robot;
    public static List<Integer> jafoi = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        robot = new Robot();
        for (; ; ) {
            loop();
        }
    }

    public static void loop() {
        for (GuitarHeroButton button : GuitarHeroButton.values()) {
            Color color = robot.getPixelColor(button.getX(), button.getY());
            int rgb = color.getRGB();
            if (rgb != button.getIgnoreColor()) {
                if (!jafoi.contains(rgb)) {
                    jafoi.add(rgb);
                    if (!button.getToPress().contains(rgb)) {
                        // System.out.print(", " + rgb);
                    }
                }
            }
            button.checkPress(rgb);
        }
    }

}
