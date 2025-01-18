package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coêlho at 09/03/2024 - 04:37
 */

import br.com.introcdc.tests.database.StringComponents;

import java.io.File;
import java.util.List;

public class VideoFrames {

    public static final List<String> FRAMES = StringComponents.arrayList();
    public static boolean THUMBNAIL = false;

    public static void main(String[] args) {
        THUMBNAIL = args.length > 0;
        System.out.println("Lendo...");
        readFolder(new File("H:\\Videos\\Canal\\"));
        System.out.println(StringComponents.commas(FRAMES, ", "));
        System.out.println("Frames: " + FRAMES.size());
    }

    public static void readFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                continue;
            }
            checkIfIsVideo(file);
        }
    }

    public static void checkIfIsVideo(File folder) {
        List<String> frames = StringComponents.arrayList();
        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {
                if (THUMBNAIL) {
                    if (!file.getName().toLowerCase().contains("thumb")) {
                        continue;
                    }
                } else {
                    if (file.getName().toLowerCase().contains("thumb")) {
                        continue;
                    }
                }
                frames.add("\"" + file.getAbsolutePath() + "\"");
            }
        }
        if (frames.isEmpty()) {
            readFolder(folder);
            return;
        }
        FRAMES.addAll(frames);
    }

}
