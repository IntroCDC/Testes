package br.com.introcdc.tests.sites;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VoterClient {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public static Robot robot;
    public static int f5 = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando instancia do bot de teclado e mouse...");
        robot = new Robot();
        System.out.println("Instanciado!");
        System.out.println("Iniciando loop em 5 segundos...");
        scheduler.schedule(new Runnable() {
            public void run() {
                System.out.println("Iniciado!");
                loop();
            }
        }, 5, TimeUnit.SECONDS);
    }

    public static void loop() {
        click();
        scheduler.schedule(new Runnable() {
            public void run() {
                f5++;
                if (f5 > 5) {
                    f5 = 0;
                    f5();
                } else {
                    esc();
                }
                scheduler.schedule(new Runnable() {
                    public void run() {
                        System.out.println("Votando novamente...");
                        loop();
                    }
                }, 1000, TimeUnit.MILLISECONDS);
            }
        }, 1000, TimeUnit.MILLISECONDS);
    }

    public static void click() {
        System.out.println("Clicando...");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        System.out.println("Clicado!");
    }

    public static void f5() {
        System.out.println("Atualizando página...");
        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);
        System.out.println("Atualizado!");
    }

    public static void esc() {
        System.out.println("Apertando esc...");
        robot.keyPress(27);
        robot.keyRelease(27);
        System.out.println("Apertado Esc!");
    }

}
