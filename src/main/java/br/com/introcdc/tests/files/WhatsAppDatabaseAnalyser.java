package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 01/09/2020 - 04:13
 */

import java.io.File;
import java.util.*;

public class WhatsAppDatabaseAnalyser {

    public static void main(String[] args) {
        Map<Long, List<String>> sizes = new HashMap<>();
        long deleted = 0;
        for (File file : new File("F:\\Documentos\\Backups\\Videos Cel\\WhatsApp Video").listFiles()) {
            if (!file.getName().startsWith("VID-")) {
                continue;
            }
            if (sizes.containsKey(file.length())) {
                deleted++;
                String fileName = file.getName().replace("VID-", "").split("-")[0];
                String fileNameFrom = sizes.get(file.length()).get(0).replace("VID-", "").split("-")[0];
                if (!fileName.equals(fileNameFrom)) {
                    continue;
                }
                sizes.get(file.length()).add(file.getName());
                file.renameTo(new File(file.getParentFile().getAbsolutePath() + "\\duplicadas", file.getName()));
                continue;
            }
            sizes.put(file.length(), new ArrayList<>(Collections.singletonList(file.getName())));
        }
        System.out.println("Imagens deletadas: " + deleted);
    }

}
