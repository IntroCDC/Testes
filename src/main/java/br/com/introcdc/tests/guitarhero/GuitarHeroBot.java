package br.com.introcdc.tests.guitarhero;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GuitarHeroBot {

    // Robot para simular o teclado
    public static Robot robot;
    // Tolerância para detecção de cores
    public static final int COLOR_THRESHOLD = 15;
    // Intervalo entre verificações (em milissegundos)
    public static final int LOOP_DELAY = 1;

    public static void main(String[] args) throws Exception {
        // Inicializando o Robot
        robot = new Robot();

        // Garantir que todas as teclas estejam liberadas no início
        for (GuitarHeroKey key : GuitarHeroKey.values()) {
            robot.keyRelease(key.getKey());
        }

        System.out.println("Bot iniciado! Certifique-se de que o jogo está rodando.");

        // Loop principal do bot
        while (true) {
            for (GuitarHeroKey key : GuitarHeroKey.values()) {
                key.verify(robot); // Verificar e pressionar/release as teclas
            }
            Thread.sleep(LOOP_DELAY); // Evitar sobrecarga no sistema
        }
    }

    // Enum para representar as teclas e suas coordenadas/cor
    public enum GuitarHeroKey {
        VERDE(701, 894, KeyEvent.VK_A, new Color(9, 12, 9)),      // Coordenadas e cor ajustadas
        VERMELHO(839, 894, KeyEvent.VK_S, new Color(23, 22, 22)), // Vermelho
        AMARELO(956, 894, KeyEvent.VK_J, new Color(14, 14, 12)),  // Amarelo
        AZUL(1082, 894, KeyEvent.VK_K, new Color(10, 11, 12)),    // Azul
        LARANJA(1207, 894, KeyEvent.VK_L, new Color(12, 11, 10)); // Laranja

        private final int x;
        private final int y;
        private final int key;
        private final Color targetColor; // Cor esperada
        private boolean pressed = false; // Estado da tecla

        GuitarHeroKey(int x, int y, int key, Color targetColor) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.targetColor = targetColor;
        }

        public int getKey() {
            return key;
        }

        public void verify(Robot robot) {
            // Capturar a cor do pixel na coordenada
            Color colorAtPixel = robot.getPixelColor(x, y);

            // Verificar se a cor do pixel está dentro do limite de tolerância
            if (isColorMatch(colorAtPixel, targetColor)) {
                if (!pressed) {
                    robot.keyRelease(key); // Pressionar a tecla
                    pressed = true;
                    System.out.println("Tecla pressionada: " + name());
                }
            } else {
                if (pressed) {
                    robot.keyPress(key); // Liberar a tecla
                    pressed = false;
                    System.out.println("Tecla liberada: " + name());
                }
            }
        }

        // Verifica se duas cores são semelhantes dentro de um limite de tolerância
        private boolean isColorMatch(Color c1, Color c2) {
            int rDiff = Math.abs(c1.getRed() - c2.getRed());
            int gDiff = Math.abs(c1.getGreen() - c2.getGreen());
            int bDiff = Math.abs(c1.getBlue() - c2.getBlue());
            return rDiff <= COLOR_THRESHOLD && gDiff <= COLOR_THRESHOLD && bDiff <= COLOR_THRESHOLD;
        }
    }
}
