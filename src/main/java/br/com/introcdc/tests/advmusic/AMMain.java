package br.com.introcdc.tests.advmusic;

import br.com.introcdc.tests.Main;

import java.io.File;
import java.util.List;

public class AMMain {

    public static void main(String[] args) throws Exception {
        AMScreen screen = new AMScreen();
        screen.setVisible(true);

        List<String> selected;
        if (args.length == 0) {
            selected = List.of("Mister IA", "IA");
        } else {
            selected = List.of(Main.arg(args).split(";"));
        }
        List<File> musicFolders = GameLogic.getMusicFolders("F:/Musicas/", selected);
        List<File> musicFiles = GameLogic.getMusicFiles(musicFolders);

        GameLogic gameLogic = new GameLogic(screen, musicFiles);
        screen.setGameLogic(gameLogic);
    }

}
