package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 18/02/2025 - 08:46
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EnumUpdater {

    // Mapa global que relaciona cada objeto Music com o número sequencial calculado
    public static Map<Music, Integer> map = new HashMap<>();

    // Método que gera a string atualizada da constante do enum com o novo número inserido
    public static String toEnumConstantString(Music music) {
        StringBuilder sb = new StringBuilder();
        sb.append(music.name()).append("(\"").append(music.getMusicName()).append("\", ");
        sb.append(music.isMisterIA()).append(", \"").append(music.getCreation()).append("\", ");
        sb.append(music.getAlbum()).append(", ");
        sb.append(map.get(music)).append(", ");
        sb.append(music.getSubVersions());
        for (String alt : music.getAlternativeVersions()) {
            sb.append(", \"").append(alt).append("\"");
        }
        sb.append("),");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Agrupar músicas por álbum
        Map<Integer, List<Music>> albumGroups = new HashMap<>();
        for (Music entry : Music.values()) {
            albumGroups.computeIfAbsent(entry.getAlbum(), k -> new ArrayList<>()).add(entry);
        }

        // Formato da data usado no enum ("dd/MM/yyyy - HH:mm")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");

        // Para cada grupo (álbum):
        // 1. Ordena as músicas pela data de criação (do mais antigo para o mais novo);
        // 2. Cria um Map<Integer, Date> para salvar (por este álbum) a relação [número sequencial] -> [data];
        // 3. Define no mapa global (map) o número sequencial para cada música.
        for (Map.Entry<Integer, List<Music>> group : albumGroups.entrySet()) {
            List<Music> list = group.getValue();
            // Ordena convertendo a string da data para Date
            list.sort(Comparator.comparing(m -> {
                try {
                    return sdf.parse(m.getCreation());
                } catch (ParseException e) {
                    e.printStackTrace();
                    return new Date(0);
                }
            }));

            // Cria o map do álbum: [sequencial] -> [data]
            Map<Integer, Date> albumDateMap = new LinkedHashMap<>();
            int seq = 1;
            for (Music music : list) {
                try {
                    Date creationDate = sdf.parse(music.getCreation());
                    albumDateMap.put(seq, creationDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // Atualiza o mapa global com o número sequencial para cada música
                map.put(music, seq++);
            }

            // Exemplo de saída para cada álbum (opcional)
            System.out.println("Sequência para o álbum " + group.getKey() + ":");
            for (Map.Entry<Integer, Date> entry : albumDateMap.entrySet()) {
                System.out.println(sdf.format(entry.getValue()) + " : " + entry.getKey());
            }
            System.out.println();
        }

        // Exibe as entradas do enum atualizadas com o novo número inserido
        for (Music music : Music.values()) {
            System.out.println(toEnumConstantString(music));
        }
    }
}
