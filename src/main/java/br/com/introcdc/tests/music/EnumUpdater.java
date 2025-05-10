package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 18/02/2025 - 08:46
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EnumUpdater {

    // Mapa global que relaciona cada objeto Music com o n�mero sequencial calculado
    public static Map<Music, Integer> map = new HashMap<>();

    // M�todo que gera a string atualizada da constante do enum com o novo n�mero inserido
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
        // Agrupar m�sicas por �lbum
        Map<Integer, List<Music>> albumGroups = new HashMap<>();
        for (Music entry : Music.values()) {
            albumGroups.computeIfAbsent(entry.getAlbum(), k -> new ArrayList<>()).add(entry);
        }

        // Formato da data usado no enum ("dd/MM/yyyy - HH:mm")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");

        // Para cada grupo (�lbum):
        // 1. Ordena as m�sicas pela data de cria��o (do mais antigo para o mais novo);
        // 2. Cria um Map<Integer, Date> para salvar (por este �lbum) a rela��o [n�mero sequencial] -> [data];
        // 3. Define no mapa global (map) o n�mero sequencial para cada m�sica.
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

            // Cria o map do �lbum: [sequencial] -> [data]
            Map<Integer, Date> albumDateMap = new LinkedHashMap<>();
            int seq = 1;
            for (Music music : list) {
                try {
                    Date creationDate = sdf.parse(music.getCreation());
                    albumDateMap.put(seq, creationDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // Atualiza o mapa global com o n�mero sequencial para cada m�sica
                map.put(music, seq++);
            }

            // Exemplo de sa�da para cada �lbum (opcional)
            System.out.println("Sequ�ncia para o �lbum " + group.getKey() + ":");
            for (Map.Entry<Integer, Date> entry : albumDateMap.entrySet()) {
                System.out.println(sdf.format(entry.getValue()) + " : " + entry.getKey());
            }
            System.out.println();
        }

        // Exibe as entradas do enum atualizadas com o novo n�mero inserido
        for (Music music : Music.values()) {
            System.out.println(toEnumConstantString(music));
        }
    }
}
