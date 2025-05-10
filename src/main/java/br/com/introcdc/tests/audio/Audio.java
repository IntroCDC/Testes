package br.com.introcdc.tests.audio;
/*
 * Written by IntroCDC, Bruno Coelho at 01/10/2024 - 16:52
 */

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Audio {

    public static void main(String[] args) {
        new Thread(() -> {
            int millis = 50;
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    generateBeep(millis, 1500);
                } else {
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    public static void generateBeep(int durationMs, int frequencyHz) {
        try {
            float sampleRate = 44100;
            byte[] buffer = new byte[1];
            AudioFormat format = new AudioFormat(sampleRate, 8, 1, true, true);

            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();

            for (int i = 0; i < durationMs * (sampleRate / 1000); i++) {
                double angle = i / (sampleRate / frequencyHz) * 2.0 * Math.PI;
                buffer[0] = (byte) (Math.sin(angle) * 127);
                line.write(buffer, 0, 1);
            }

            line.drain();
            line.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
