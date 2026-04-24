package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 24/04/2026 - 05:41
 */

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegionCleaner {

    public static void main(String[] args) {
        // Coloque aqui a pasta "region" do mundo
        File regionFolder = new File("C:/Kindome/servers/Creative/world/entities");

        // true = apenas mostra o que seria deletado
        // false = deleta de verdade
        boolean dryRun = false;

        int minRegion = -5;
        int maxRegion = 4;

        Pattern pattern = Pattern.compile("r\\.(-?\\d+)\\.(-?\\d+)\\.mca");

        if (!regionFolder.exists() || !regionFolder.isDirectory()) {
            System.out.println("A pasta region não existe ou não é uma pasta válida.");
            return;
        }

        File[] files = regionFolder.listFiles();

        if (files == null) {
            System.out.println("Não foi possível listar os arquivos da pasta region.");
            return;
        }

        int kept = 0;
        int deleted = 0;
        int ignored = 0;

        for (File file : files) {
            String fileName = file.getName();

            Matcher matcher = pattern.matcher(fileName);

            if (!matcher.matches()) {
                ignored++;
                continue;
            }

            int regionX = Integer.parseInt(matcher.group(1));
            int regionZ = Integer.parseInt(matcher.group(2));

            boolean insideArea =
                    regionX >= minRegion && regionX <= maxRegion &&
                            regionZ >= minRegion && regionZ <= maxRegion;

            if (insideArea) {
                kept++;
                System.out.println("[MANTER] " + fileName);
                continue;
            }

            if (dryRun) {
                deleted++;
                System.out.println("[DELETARIA] " + fileName);
            } else {
                if (file.delete()) {
                    deleted++;
                    System.out.println("[DELETADO] " + fileName);
                } else {
                    System.out.println("[ERRO] Não foi possível deletar: " + fileName);
                }
            }
        }

        System.out.println();
        System.out.println("Resumo:");
        System.out.println("Arquivos mantidos: " + kept);
        System.out.println("Arquivos que seriam/deletados: " + deleted);
        System.out.println("Arquivos ignorados: " + ignored);

        if (dryRun) {
            System.out.println();
            System.out.println("Modo teste ativado. Para deletar de verdade, troque dryRun para false.");
        }
    }

}
