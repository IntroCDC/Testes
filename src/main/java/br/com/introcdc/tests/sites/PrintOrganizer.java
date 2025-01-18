package br.com.introcdc.tests.sites;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PrintOrganizer {

    public static void main(String[] args) {
        String prefix = "Screenshot_";
        String suffix = ".png";
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i < 5000; i++) {
            if (!(new File("F:\\Imagens\\Lightshot\\" + prefix + i + suffix).exists())) {
                available.add(i);
            }
        }
        int current = 0;
        for (File file : new File("C:/Users/bruno/Desktop").listFiles()) {
            if (!file.getName().startsWith(prefix)) {
                continue;
            }
            String path = file.getAbsolutePath().replace(file.getName(), prefix + available.get(current) + suffix);
            System.out.println(path);
            file.renameTo(new File(path));
            current++;
        }
        System.out.println("Pronto!");
    }

}
