package br.com.introcdc.tests.minigames;
/*
 * Written by IntroCDC, Bruno Coêlho at 27/06/2024 - 09:46
 */

import br.com.introcdc.tests.minigames.screens.DefaultFrames;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MiniGameMain {

    private static final ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);

    public static ScheduledExecutorService getTimer() {
        return scheduledExecutorService;
    }

    // Main
    public static void main(String[] args) {
        new MiniGameMain(0, 0);
    }

    // Screen Resolution
    private final int X = 10;
    private final int Y = 20;

    // Screen Config
    private final int FPS = 1;
    private final char ON = 'X';
    private final char OFF = 'O';

    // Screen Instance
    public MiniGameScreen screen;
    public final int xBase;
    public final int yBase;

    public MiniGameMain(int xBase, int yBase) {
        this.xBase = xBase;
        this.yBase = yBase;
        screen = new MiniGameScreen(this);
        getScreen().startUpdater();

        DefaultFrames defaultFrames = new DefaultFrames(this);
        defaultFrames.initialFrames();
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getFPS() {
        return FPS;
    }

    public char getON() {
        return ON;
    }

    public char getOFF() {
        return OFF;
    }

    public MiniGameScreen getScreen() {
        return screen;
    }

    public int getxBase() {
        return xBase;
    }

    public int getyBase() {
        return yBase;
    }

}
