package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coêlho at 09/03/2024 - 04:37
 */

import br.com.introcdc.tests.database.FileComponents;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MusicOrganizer {

    public static void main(String[] args) throws Exception {
        fullApply(new File("C:/Users/Bruno/Downloads"), new File("C:/Users/Bruno/Downloads"));
    }

    public static void applyAlbum(File folder) throws Exception {
        for (File file : folder.listFiles()) {
            if (!file.getName().endsWith(".mp3")) {
                continue;
            }

            System.out.println("Processando: " + file.getName());
            try {
                Mp3File mp3file = new Mp3File(file.getAbsolutePath());
                if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    System.out.println("1: " + id3v1Tag.getAlbum());
                    if (id3v1Tag.getAlbum() == null || id3v1Tag.getAlbum().isEmpty()) {
                        continue;
                    }
                    id3v1Tag.setAlbum("");
                }
                if (mp3file.hasId3v2Tag()) {
                    ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                    System.out.println("2: " + id3v2Tag.getAlbum());
                    if (id3v2Tag.getAlbum() == null || id3v2Tag.getAlbum().isEmpty()) {
                        continue;
                    }
                    id3v2Tag.setAlbum("");
                } else {
                    ID3v2 id3v2Tag = new ID3v24Tag();
                    System.out.println("3: " + id3v2Tag.getAlbum());
                    if (id3v2Tag.getAlbum() == null || id3v2Tag.getAlbum().isEmpty()) {
                        break;
                    }
                    id3v2Tag.setAlbum("");
                    mp3file.setId3v2Tag(id3v2Tag);
                }
                mp3file.save(file.getAbsolutePath().replace(".mp3", "temp.mp3"));
                FileComponents.deleteFile(file);
                new File(file.getAbsolutePath().replace(".mp3", "temp.mp3")).renameTo(new File(file.getParentFile(), file.getName()));
            } catch (Exception ignored) {
            }
        }
    }

    public static void fullApplySetup(File music, File image) {
        if (!music.exists() || !music.isDirectory() || !image.exists() || !image.isDirectory()) {
            System.out.println("Um dos arquivos não existem ou não são pastas");
            return;
        }
        fullApply(music, image);
    }

    public static void fullApply(File mp3folder, File pngfolder) {
        for (File file : mp3folder.listFiles()) {
            if (!file.getName().endsWith(".mp3") || !file.getName().contains(" - ")) {
                System.out.println("não tem mp3 " + file.getName());
                continue;
            }
            if (!file.getName().contains("IA - ")) {
                System.out.println("não tem IA " + file.getName());
                continue;
            }
            String fileName = file.getName().toLowerCase().split(" - ")[1];
            for (int i = 20; i >= 0; i--) {
                fileName = fileName.replace(" " + i + ".mp3", ".mp3");
            }
            fileName = fileName.split(" \\(")[0];
            fileName = fileName.replace(".mp3", ".png");
            File cover = new File(file.getName().startsWith("Mister IA") ? pngfolder.getParentFile() : pngfolder, fileName.replace("ç", "c") + (fileName.endsWith(".png") ? "" : ".png"));
            if (!cover.exists()) {
                System.out.println("cover não encontrado " + file.getName() + " - " + cover.getName());
                continue;
            }
            applyCover(file, cover);
            updateFile(file);
        }
    }

    public static void applyCover(File filemp3, File filepng) {
        try {
            Mp3File mp3File = new Mp3File(filemp3);

            ID3v2 id3v2Tag;
            if (mp3File.hasId3v2Tag()) {
                id3v2Tag = mp3File.getId3v2Tag();
            } else {
                id3v2Tag = new ID3v24Tag();
                mp3File.setId3v2Tag(id3v2Tag);
            }

            byte[] albumArt = Files.readAllBytes(Paths.get(filepng.getAbsolutePath()));
            id3v2Tag.setAlbumImage(albumArt, "image/png");

            mp3File.save(filemp3.getAbsolutePath().replace(".mp3", "temp.mp3"));
            FileComponents.deleteFile(filemp3);
            new File(filemp3.getAbsolutePath().replace(".mp3", "temp.mp3")).renameTo(new File(filemp3.getParentFile(), filemp3.getName()));
            System.out.println("Capa aplicada com sucesso ao arquivo MP3!");
        } catch (Exception e) {
            System.err.println("Erro ao aplicar a capa: " + e.getMessage());
        }
    }

    public static void updateFile(File file) {
        try {
            String author = file.getName().split(" - ")[0];
            String musicName = file.getName().split(" - ")[1].replace(".mp3", "");
            Mp3File mp3file = new Mp3File(file.getAbsolutePath());
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                if (id3v1Tag.getArtist() != null && id3v1Tag.getArtist().equals(author) && id3v1Tag.getTitle().equals(musicName)) {
                    return;
                }
                id3v1Tag.setArtist(author);
                id3v1Tag.setTitle(musicName);
            }
            if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                if (id3v2Tag.getArtist() != null && id3v2Tag.getArtist().equals(author) && id3v2Tag.getTitle().equals(musicName)) {
                    return;
                }
                id3v2Tag.setArtist(author);
                id3v2Tag.setTitle(musicName);
            } else {
                ID3v2 id3v2Tag = new ID3v24Tag();
                if (id3v2Tag.getArtist() != null && id3v2Tag.getArtist().equals(author) && id3v2Tag.getTitle().equals(musicName)) {
                    return;
                }
                id3v2Tag.setArtist(author);
                id3v2Tag.setTitle(musicName);
                mp3file.setId3v2Tag(id3v2Tag);
            }
            mp3file.save(file.getAbsolutePath().replace(".mp3", "temp.mp3"));
            FileComponents.deleteFile(file);
            new File(file.getAbsolutePath().replace(".mp3", "temp.mp3")).renameTo(new File(file.getParentFile(), file.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAlbum(File file, String album) {
        try {
            Mp3File mp3file = new Mp3File(file.getAbsolutePath());
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                id3v1Tag.setAlbum(album);
            }
            if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                id3v2Tag.setAlbum(album);
            } else {
                ID3v2 id3v2Tag = new ID3v24Tag();
                id3v2Tag.setAlbum(album);
                mp3file.setId3v2Tag(id3v2Tag);
            }
            mp3file.save(file.getAbsolutePath().replace(".mp3", "temp.mp3"));
            FileComponents.deleteFile(file);
            new File(file.getAbsolutePath().replace(".mp3", "temp.mp3")).renameTo(new File(file.getParentFile(), file.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveToFolders() {
        for (File file : new File("F:\\Musicas").listFiles()) {
            if (!file.isFile()) {
                continue;
            }
            if (!file.getName().endsWith(".mp3")) {
                continue;
            }
            String fileName = file.getName().replace(".mp3", "");
            String[] arg = fileName.split(" - ");
            if (arg.length != 2) {
                continue;
            }
            String author = arg[0];
            updateFile(file);
            File folder = new File("F:\\Musicas\\" + author);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            file.renameTo(new File(folder, file.getName()));
        }
    }

}
