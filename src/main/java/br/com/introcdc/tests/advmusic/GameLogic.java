package br.com.introcdc.tests.advmusic;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogic {

    private AMScreen screen;
    private List<File> files;
    private MP3Musica currentMusic = null;
    private String musicName = null;
    private int wins = 0;
    private int total = 0;
    private int fails = 0;
    private int oks = 0;
    private String last = "";
    private Random random = new Random();

    public GameLogic(AMScreen screen, List<File> files) {
        this.screen = screen;
        this.files = files;
    }

    public static List<File> getMusicFolders(String path, List<String> selected) {
        List<File> musics = new ArrayList<>();
        for (File file : new File(path).listFiles()) {
            if (file.isDirectory() && !file.getName().equalsIgnoreCase("assets")) {
                if (!selected.isEmpty() && !selected.contains(file.getName())) {
                    continue;
                }
                musics.add(file);
            }
        }
        return musics;
    }

    public static List<File> getMusicFiles(List<File> musicFolders) {
        List<File> files = new ArrayList<>();
        for (File musicsFolder : musicFolders) {
            for (File subFile : musicsFolder.listFiles()) {
                if (subFile.getName().endsWith(".mp3")) {
                    files.add(subFile);
                }
            }
        }
        return files;
    }

    public void startGame() {
        nextMusic();
    }

    public void nextMusic() {
        if (currentMusic != null) {
            currentMusic.stopPlaying();
        }

        boolean end = false;
        File selectedMusic = null;
        while (selectedMusic == null || !selectedMusic.getName().endsWith(".mp3")) {
            if (files.isEmpty()) {
                end = true;
                JOptionPane.showMessageDialog(null, "Não há mais músicas no cachê...", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                selectedMusic = files.remove(random.nextInt(files.size()));
            }
        }

        if (end) {
            screen.updateUI("*", "**", "0%", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), "[*********************************************]", null);
            screen.disableInput();
            System.exit(0);
            return;
        }

        String author = "Unknown";
        String music = selectedMusic.getName();
        if (music.contains("-")) {
            author = music.split("-")[0];
            music = music.split("-")[1];
        }
        author = author.trim();
        if (music.contains("(")) {
            music = music.split("\\(")[0];
        }
        if (music.contains("[")) {
            music = music.split("\\[")[0];
        }
        music = music.trim().replace(".mp3", "");

        currentMusic = new MP3Musica();
        currentMusic.tocar(selectedMusic);
        currentMusic.start();
        musicName = music;

        checkString("?");
        screen.updateUI(author, last, "0%", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), convertToBarProgress(oks, total), currentMusic.getCoverImage());
    }

    public int checkString(String name) {
        String music = musicName;
        int percentage = music.length();
        String test;
        if (name.length() >= music.length()) {
            test = name.substring(0, music.length());
        } else {
            test = name + "********************************************************************************"
                    .subSequence(name.length(), music.length());
        }
        StringBuilder result = new StringBuilder();
        for (int key = 0; key < test.length(); key++) {
            if (!String.valueOf(test.toCharArray()[key]).equalsIgnoreCase(String.valueOf(music.toCharArray()[key]))) {
                percentage--;
                result.append("*");
            } else {
                result.append(music.toCharArray()[key]);
            }
        }
        last = result.toString();
        return percentage * 100 / music.length();
    }

    public void checkAnswer(String name) {
        int did = checkString(name);
        if (did >= 90) {
            wins++;
            total++;
            screen.updateUI(screen.authorText.getText(), last, "Você acertou! (" + did + "%)", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), convertToBarProgress(oks, total), currentMusic.getCoverImage());
            screen.clearInput();
            screen.disableInput();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    screen.clearInput();
                    screen.enableInput();
                    nextMusic();
                }
            }, 3000);
        } else if (did >= 70) {
            screen.updateUI(screen.authorText.getText(), last, "Você quase acertou! (" + did + "%)", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), convertToBarProgress(oks, total), currentMusic.getCoverImage());
            wins = 0;
            fails++;
        } else {
            screen.updateUI(screen.authorText.getText(), last, "Você errou! (" + did + "%)", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), convertToBarProgress(oks, total), currentMusic.getCoverImage());
            wins = 0;
            fails++;
        }
        oks++;
    }

    public void skipMusic() {
        wins = 0;
        fails++;
        oks++;
        screen.clearInput();
        screen.updateUI(screen.authorText.getText(), musicName, "Você passou a próxima música...", "Acertos: " + total + " - " + wins + " ||| Erros: " + fails + " - Falta: " + files.size(), convertToBarProgress(oks, total), currentMusic.getCoverImage());
        screen.disableInput();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                screen.clearInput();
                screen.enableInput();
                nextMusic();
            }
        }, 3000);
    }

    public String convertToBarProgress(long max, long use) {
        double currentHealth = Math.max(use, 0);
        double healthPercentage = currentHealth / max * 100.0D;
        String onSpacer = "*";
        String offSpacer = "-";
        int coloredDisplay = (int) Math.ceil(55 * (healthPercentage / 100.0D));
        StringBuilder healthbar = new StringBuilder();
        for (int i = 0; i < 55; i++) {
            if (coloredDisplay > 0) {
                healthbar.append(onSpacer);
                coloredDisplay--;
            } else {
                healthbar.append(offSpacer);
            }
        }
        healthbar.insert(0, "[");
        healthbar.append("]");
        return healthbar.toString();
    }
}
