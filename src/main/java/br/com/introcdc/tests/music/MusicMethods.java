package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Co�lho at 15/02/2025 - 00:05
 */

import com.google.gson.JsonObject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicMethods {

    public static void main(String[] args) throws Exception {
        discordUnlocker();
    }

    public static void discordUnlocker() {
        List<Music> unlocked = new ArrayList<>(
                List.of(Music.REINOS_DE_JOGO,
                        Music.VOCE_FEZ_COCO,
                        Music.RAFAEL_AULER_3_5,
                        Music.RITUAL_DAS_GATINHAS,
                        Music.JINGLE_DAS_GATINHAS,
                        Music.BODE,
                        Music.KINDOME,
                        Music.COCO_NA_ARARIUS,
                        Music.HACKINGS,
                        Music.ENGRACADAO,
                        Music.ENGRACADAO_VERSAO_PISEIRO,
                        Music.SANIDADE_MENTAL,
                        Music.STILL_WATER,
                        Music.AMOR_DE_JOGO,
                        Music.GOSTO_DE_COCO,
                        Music.CHEGOU_O_REMEDIO,
                        Music.ONI_CHAN,
                        Music.CLAUDINHO,
                        Music.DESTROY_EVERYTHING,
                        Music.ARROCHA_DO_JOVEM_DINAMICO,
                        Music.KIRITO_O_BODE,
                        Music.THE_IMPOSSIBLE,
                        Music.THE_IMPOSSIBLE_VERSAO_METAL,
                        Music.OLD_BURNING_LOVE,
                        Music.PARABENS_ANA,
                        Music.NAO_SABE_PULAR,
                        Music.GAROTAS_PALHACO)
        );
        Map<Integer, Integer> amount = new HashMap<>();
        System.out.println("\uD83D\uDD13 As Desbloqueadas: (" + unlocked.size() + "/" + Music.values().length + ")");
        for (Music music : unlocked) {
            amount.put(music.getAlbum(), amount.getOrDefault(music.getAlbum(), 0) + 1);
            System.out.println(" - " + music.getMusicName() + " (" + music.getShortAlbumName() + " #" + music.getNumber() + (music.isMisterIA() ? " / Mister IA" : "") + ") / " + music.getCreation());
        }
        System.out.println();
        System.out.println("�lbuns:");
        for (int i = 0; i <= 2; i++) {
            System.out.println(" - " + Music.albumName(i) + ": " + amount.get(i) + "/" + Music.getMusicsAmountInAlbum(i));
        }
    }

    public static void printPerAlbum() {
        for (int i = 0; i <= 2; i++) {
            List<Music> musicList = new ArrayList<>();
            for (Music music : Music.values()) {
                if (music.getAlbum() == i) {
                    musicList.add(music);
                }
            }
            System.out.println("�lbum " + Music.albumName(i) + ": " + musicList.size() + " m�sicas");
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
