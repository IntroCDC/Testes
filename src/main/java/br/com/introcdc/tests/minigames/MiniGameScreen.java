package br.com.introcdc.tests.minigames;
/*
 * Written by IntroCDC, Bruno Coêlho at 27/06/2024 - 09:47
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MiniGameScreen {

    private final MiniGameMain main;
    private final List<MiniGameFrame> pendentFrames;

    public MiniGameScreen(MiniGameMain main) {
        this.main = main;
        pendentFrames = new ArrayList<>();
    }

    public MiniGameMain getMain() {
        return main;
    }

    public List<MiniGameFrame> getPendentFrames() {
        return pendentFrames;
    }

    public void startUpdater() {
        MiniGameMain.getTimer().scheduleAtFixedRate(this::printNextFrame, 0, 1000 / getMain().getFPS(), TimeUnit.MILLISECONDS);
    }

    public void printNextFrame() {
        if (getPendentFrames().isEmpty()) {
            return;
        }
        getPendentFrames().remove(0).print();
    }

}
