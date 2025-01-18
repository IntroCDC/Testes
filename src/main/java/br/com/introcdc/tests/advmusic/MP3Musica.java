package br.com.introcdc.tests.advmusic;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import com.mpatric.mp3agic.*;

public class MP3Musica extends Thread {

    private File mp3;
    private Player player;
    private ImageIcon coverImage;

    public void tocar(File mp3) {
        this.mp3 = mp3;
        extractCoverImage(mp3);
    }

    private void extractCoverImage(File mp3) {
        try {
            Mp3File mp3file = new Mp3File(mp3);
            if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                byte[] imageData = id3v2Tag.getAlbumImage();
                if (imageData != null) {
                    coverImage = new ImageIcon(imageData);
                } else {
                    coverImage = null;
                }
            }
        } catch (Exception e) {
            coverImage = null;
            e.printStackTrace();
        }
    }

    public ImageIcon getCoverImage() {
        return coverImage;
    }

    public void run() {
        try (FileInputStream fis = new FileInputStream(mp3);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            this.player = new Player(bis);
            this.player.play();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tocar a música: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void stopPlaying() {
        if (player != null) {
            player.close();
        }
    }
}
