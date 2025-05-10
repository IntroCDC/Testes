package br.com.introcdc.tests.minigames;
/*
 * Written by IntroCDC, Bruno Coelho at 27/06/2024 - 09:51
 */

import java.util.ArrayList;
import java.util.List;

public class MiniGameFrame {

    private final MiniGameMain main;
    private final List<Character> pixelList;

    public MiniGameFrame(MiniGameMain main) {
        this.main = main;
        pixelList = new ArrayList<>();
    }

    public MiniGameMain getMain() {
        return main;
    }

    public List<Character> getPixelList() {
        return pixelList;
    }

    public void print() {
        System.out.println("========================================");
        for (int y = (getMain().getyBase() + getMain().getY()); y > getMain().getyBase(); y--) {
            for (int x = getMain().getxBase(); x < (getMain().getxBase() + getMain().getX()); x++) {
                System.out.print(getPixelList().remove(0));
            }
            System.out.println();
        }
    }

}
