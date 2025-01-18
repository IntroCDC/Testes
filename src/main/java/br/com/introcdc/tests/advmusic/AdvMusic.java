package br.com.introcdc.tests.advmusic;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;
import java.util.Timer;

import javax.swing.*;

import br.com.introcdc.tests.Main;
import javazoom.jl.player.Player;

public class AdvMusic {

    public static AMScreen screen;
    public static Random random = new Random();
    public static List<File> files = new ArrayList<>();
    public static MP3Musica currentMusic = null;
    public static String musicName = null;
    public static int wins = 0;
    public static int total = 0;
    public static int fails = 0;
    public static int oks = 0;

    public static String last = "";

    public static void main(String[] args) throws Exception {
        screen = new AMScreen();
        screen.frame.setVisible(true);
        List<File> musics = new ArrayList<>();

        List<String> selected;
        if (args.length == 0) {
            selected = List.of("Mister IA");
        } else {
            selected = List.of(Main.arg(args).split(";"));
        }
        for (File file : new File("F:/Musicas/").listFiles()) {
            if (file.isDirectory() && !file.getName().equalsIgnoreCase("assets")) {
                if (!selected.isEmpty() && !selected.contains(file.getName())) {
                    continue;
                }
                musics.add(file);
            }
        }

        for (File musicsFolder : musics) {
            for (File subFile : musicsFolder.listFiles()) {
                if (subFile.getName().endsWith(".mp3")) {
                    files.add(subFile);
                }
            }
        }
    }

    public static void nextMusic() {
        if (currentMusic != null) {
            currentMusic.stop();
        }

        boolean end = false;
        File selectedMusic = null;
        while (selectedMusic == null || !selectedMusic.getName().endsWith(".mp3")) {
            if (files.isEmpty()) {
                end = true;
                JOptionPane.showMessageDialog(null, "Não há mais músicas no cachê...", "Erro", 0);
            } else {
                selectedMusic = files.remove(random.nextInt(files.size()));
            }
        }

        if (end) {
            screen.authorText.setText("Autor: *");
            screen.musicText.setText("**");
            screen.percentText.setText("0%");
            screen.tryField.setText("");
            screen.tryField.setEnabled(false);
            screen.okButton.setEnabled(false);
            screen.nextMusicButton.setEnabled(false);
            System.exit(0);
            return;
        }

        String author = "Unknown";
        String music = selectedMusic.getName();
        if (music.contains("-")) {
            author = music.split("-")[0];
            music = music.split("-")[1];
        }
        while (author.endsWith(" ")) {
            author = author.substring(0, author.length() - 1);
        }
        while (author.startsWith(" ")) {
            author = author.substring(1, author.length());
        }
        if (music.contains("(")) {
            music = music.split("\\(")[0];
        }
        if (music.contains("[")) {
            music = music.split("\\[")[0];
        }
        while (music.endsWith(" ")) {
            music = music.substring(0, music.length() - 1);
        }
        while (music.startsWith(" ")) {
            music = music.substring(1, music.length());
        }
        while (music.endsWith(".mp3")) {
            music = music.substring(0, music.length() - 4);
        }

        File mp3File = new File(selectedMusic.getAbsolutePath());
        MP3Musica musica = new MP3Musica();
        currentMusic = musica;
        musica.tocar(mp3File);
        musica.start();
        musicName = music;

        checkString("?");
        screen.authorText.setText("Autor: " + author);
        screen.musicText.setText("" + last.toString());
        screen.percentText.setText("0%");
    }

    public static int checkString(String name) {
        String music = musicName;
        int percentagem = music.length();
        String teste;
        if (name.length() >= music.length()) {
            teste = name.substring(0, music.length());
        } else {
            teste = name + "********************************************************************************"
                    .subSequence(name.length(), music.length());
        }
        StringBuilder result = new StringBuilder();
        for (int key = 0; key < teste.length(); key++) {
            if (!String.valueOf(teste.toCharArray()[key]).equalsIgnoreCase(String.valueOf(music.toCharArray()[key]))) {
                percentagem--;
                result.append("*");
            } else {
                result.append("").append(String.valueOf(music.toCharArray()[key]));
            }
        }
        last = result.toString();
        return percentagem * 100 / music.length();
    }

    public static String convertToBarProgress(long max, long use) {
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
        healthbar = new StringBuilder("[" + healthbar + "]");
        return healthbar.toString();
    }

    public static class MP3Musica extends Thread {

        private File mp3;
        private Player player;

        public void tocar(File mp3) {
            this.mp3 = mp3;
        }

        public void run() {
            try {
                FileInputStream fis = new FileInputStream(mp3);
                BufferedInputStream bis = new BufferedInputStream(fis);
                this.player = new Player(bis);
                this.player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class AMScreen {

        public JFrame frame;
        public JTextField tryField;
        public JTextPane title = new JTextPane();
        public JTextPane authorText = new JTextPane();
        public JTextPane musicText = new JTextPane();
        public JTextPane percentText = new JTextPane();
        public JButton okButton = new JButton("OK");
        public JButton nextMusicButton = new JButton("Próxima Música");
        public JButton startButton = new JButton("Iniciar");
        private final JSeparator separator_3 = new JSeparator();
        private final JTextPane winsText = new JTextPane();

        public static java.util.Timer timer = new Timer();
        private final JTextPane percentBarText = new JTextPane();

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        AMScreen window = new AMScreen();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the application.
         */
        public AMScreen() {
            initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frame = new JFrame();
            frame.setTitle("AdvMusic");
            frame.setResizable(false);
            frame.setBounds(100, 100, 330, 295);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            title.setEditable(false);

            title.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
            title.setText("AdvMusic");
            title.setBounds(115, 0, 90, 28);
            frame.getContentPane().add(title);

            frame.getContentPane().add(separator_3);
            winsText.setText("Acertos: 0 - 0 ||| Erros: 0 - Falta: 0");
            winsText.setEditable(false);
            winsText.setBounds(10, 210, 294, 20);

            frame.getContentPane().add(winsText);

            JSeparator separator = new JSeparator();
            separator.setBounds(0, 30, 320, 1);
            frame.getContentPane().add(separator);
            authorText.setEditable(false);

            authorText.setText("Autor: *");
            authorText.setBounds(10, 35, 294, 20);
            frame.getContentPane().add(authorText);
            musicText.setEditable(false);

            musicText.setText("**");
            musicText.setBounds(10, 55, 294, 20);
            frame.getContentPane().add(musicText);
            percentText.setEditable(false);

            percentText.setText("0%");
            percentText.setBounds(10, 75, 294, 20);
            frame.getContentPane().add(percentText);

            JSeparator separator_1 = new JSeparator();
            separator_1.setBounds(0, 100, 320, 1);
            frame.getContentPane().add(separator_1);

            tryField = new JTextField();
            tryField.setEnabled(false);
            tryField.setBounds(10, 106, 294, 20);
            frame.getContentPane().add(tryField);
            tryField.setColumns(10);

            okButton.setEnabled(false);
            okButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (tryField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Digite um nome...", "Erro", 0);
                        return;
                    }
                    int did = AdvMusic.checkString(tryField.getText());
                    if (did >= 90) {
                        AdvMusic.wins++;
                        AdvMusic.total++;
                        musicText.setText(AdvMusic.last);
                        percentText.setText("Você acertou! (" + did + "%)");
                        tryField.setText("");
                        tryField.setEnabled(false);
                        okButton.setEnabled(false);
                        nextMusicButton.setEnabled(false);
                        timer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                tryField.setText("");
                                tryField.setEnabled(true);
                                okButton.setEnabled(true);
                                nextMusicButton.setEnabled(true);
                                AdvMusic.nextMusic();
                            }
                        }, 3000);
                    } else if (did >= 70) {
                        musicText.setText(AdvMusic.last);
                        percentText.setText("Você quase acertou! (" + did + "%)");
                        AdvMusic.wins = 0;
                        AdvMusic.fails++;
                    } else {
                        musicText.setText(AdvMusic.last);
                        percentText.setText("Você errou! (" + did + "%)");
                        AdvMusic.wins = 0;
                        AdvMusic.fails++;
                    }
                    AdvMusic.oks++;
                    winsText.setText("Acertos: " + AdvMusic.total + " - " + AdvMusic.wins + " ||| Erros: " + AdvMusic.fails + " - Falta: " + AdvMusic.files.size());
                    percentBarText.setText(AdvMusic.convertToBarProgress(AdvMusic.oks, AdvMusic.total));
                }
            });
            okButton.setBounds(10, 130, 145, 23);
            frame.getContentPane().add(okButton);

            nextMusicButton.setEnabled(false);
            nextMusicButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    AdvMusic.wins = 0;
                    AdvMusic.fails++;
                    AdvMusic.oks++;
                    tryField.setText("");
                    winsText.setText("Acertos: " + AdvMusic.total + " - " + AdvMusic.wins + " ||| Erros: " + AdvMusic.fails + " - Falta: " + AdvMusic.files.size());
                    percentBarText.setText(AdvMusic.convertToBarProgress(AdvMusic.oks, AdvMusic.total));

                    musicText.setText(AdvMusic.musicName);
                    percentText.setText("Você passou a próxima música...");
                    tryField.setText("");
                    tryField.setEnabled(false);
                    okButton.setEnabled(false);
                    nextMusicButton.setEnabled(false);
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            tryField.setText("");
                            tryField.setEnabled(true);
                            okButton.setEnabled(true);
                            nextMusicButton.setEnabled(true);
                            AdvMusic.nextMusic();
                        }
                    }, 3000);
                }
            });
            nextMusicButton.setBounds(159, 130, 145, 23);
            frame.getContentPane().add(nextMusicButton);

            JSeparator separator_2 = new JSeparator();
            separator_2.setBounds(0, 160, 320, 1);
            frame.getContentPane().add(separator_2);

            startButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    tryField.setText("");
                    tryField.setEnabled(true);
                    okButton.setEnabled(true);
                    nextMusicButton.setEnabled(true);
                    startButton.setEnabled(false);
                    AdvMusic.nextMusic();
                }
            });
            startButton.setBounds(10, 170, 294, 23);
            frame.getContentPane().add(startButton);
            separator_3.setBounds(0, 200, 320, 1);
            percentBarText.setText("[*********************************************]");
            percentBarText.setEditable(false);
            percentBarText.setBounds(10, 230, 294, 20);

            frame.getContentPane().add(percentBarText);
        }
    }

}
