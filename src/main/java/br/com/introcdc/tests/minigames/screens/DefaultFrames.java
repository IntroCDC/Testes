package br.com.introcdc.tests.minigames.screens;
/*
 * Written by IntroCDC, Bruno Coêlho at 27/06/2024 - 10:14
 */

import br.com.introcdc.tests.minigames.MiniGameFrame;
import br.com.introcdc.tests.minigames.MiniGameMain;

import java.util.ArrayList;
import java.util.List;

public class DefaultFrames {

    private final MiniGameMain main;
    private final char O;
    private final char F;

    public DefaultFrames(MiniGameMain main) {
        this.main = main;
        this.O = main.getON();
        this.F = main.getOFF();
    }

    public MiniGameMain getMain() {
        return main;
    }

    public void initialFrames() {
        toFrame(5,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F,
                O, O, O, O, O, O, O, O, O, O,
                F, F, F, F, F, F, F, F, F, F);
    }

    public void toFrame(int frames, char... charArray) {
        for (int i = 0; i < frames; i++) {
            MiniGameFrame frame = new MiniGameFrame(getMain());
            frame.getPixelList().addAll(toList(charArray));
            getMain().getScreen().getPendentFrames().add(frame);
        }
    }

    public List<Character> toList(char... charArray) {
        List<Character> list = new ArrayList<>();
        for (char charInfo : charArray) {
            list.add(charInfo);
        }
        return list;
    }

}
