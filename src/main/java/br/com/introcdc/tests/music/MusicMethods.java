package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coêlho at 15/02/2025 - 00:05
 */

import com.google.gson.JsonObject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MusicMethods {

    public static void main(String[] args) throws Exception {
        jsonCreator();
    }

    public static void printPerAlbum() {
        for (int i = 0; i <= 2; i++) {
            List<Music> musicList = new ArrayList<>();
            for (Music music : Music.values()) {
                if (music.getAlbum() == i) {
                    musicList.add(music);
                }
            }
            System.out.println("Álbum " + Music.albumName(i) + ": " + musicList.size() + " músicas");
            for (Music music : musicList) {
                System.out.println(" - " + music.getMusicName());
            }
            System.out.println();
        }
    }

    public static void verifyMusics() {
    }

    public static void jsonCreator() throws Exception {
        JsonObject jsonObject = new JsonObject();
        for (Music music : Music.values()) {
            JsonObject musicObject = new JsonObject();
            musicObject.addProperty("creation", music.getCreation());
            musicObject.addProperty("album", music.getAlbumName());
            jsonObject.add(music.getMusicName(), musicObject);
        }
        System.out.println(jsonObject);
        PrintWriter writer = new PrintWriter("F:/Musicas/assets/lyrics/info.json");
        writer.println(jsonObject);
        writer.flush();
        writer.close();
    }

}
