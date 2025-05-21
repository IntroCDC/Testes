package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 14/05/2025 - 11:13
 */

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegionFileCleaner {

    // Limites de coordenadas de região a manter
    private static final int MIN_COORD = -10;
    private static final int MAX_COORD = 9;

    // Regex pra capturar "r.<x>.<z>.mca"
    private static final Pattern REGION_PATTERN =
            Pattern.compile("r\\.(-?\\d+)\\.(-?\\d+)\\.mca");

    public static void main(String[] args) {
        String folderPath = "C:/Kindome/servers/Content/world/region";

        File regionFolder = new File(folderPath);
        if (!regionFolder.exists() || !regionFolder.isDirectory()) {
            System.err.println("? Pasta não encontrada ou não é diretório: " + folderPath);
            return;
        }

        File[] files = regionFolder.listFiles((dir, name) -> name.endsWith(".mca"));
        if (files == null) {
            System.err.println("? Erro ao listar arquivos na pasta: " + folderPath);
            return;
        }

        for (File file : files) {
            Matcher m = REGION_PATTERN.matcher(file.getName());
            if (m.matches()) {
                int regionX = Integer.parseInt(m.group(1));
                int regionZ = Integer.parseInt(m.group(2));

                // Se estiver fora do intervalo [-10, 9], deleta
                if (regionX < MIN_COORD || regionX > MAX_COORD
                        || regionZ < MIN_COORD || regionZ > MAX_COORD) {
                    if (file.delete()) {
                        System.out.println("Deletado: " + file.getName());
                    } else {
                        System.err.println("Falha ao deletar: " + file.getName());
                    }
                }

            } else {
                // Se não bate com o padrão, só ignora
                System.out.println("Ignorando não-mca: " + file.getName());
            }
        }

        System.out.println("Limpeza de region files concluída! :D");
    }
}

