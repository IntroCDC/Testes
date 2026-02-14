package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 14/02/2026 - 02:42
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.*;

/**
 * Verifica duplicados no musicquest.json baseado em (author + name).
 * - Ignora diferença de maiúsculas/minúsculas
 * - Normaliza espaços
 * - Pode ignorar acentos (configurável)
 */
public class MusicQuestDuplicatesChecker {

    public static void main(String[] args) {
        try {
            File jsonFile = new File("musicquest.json");
            if (!jsonFile.exists()) {
                System.out.println("Arquivo musicquest.json não encontrado. x-x");
                return;
            }

            // true = ignora acento (Não == Nao)
            // false = considera acento (Não != Nao)
            boolean accentInsensitive = true;

            DuplicateReport report = findDuplicates(jsonFile, accentInsensitive);

            if (report.duplicates.isEmpty()) {
                System.out.println("Nenhum duplicado encontrado. :D");
                return;
            }

            System.out.println("=== DUPLICADOS ENCONTRADOS (" + report.duplicates.size() + " grupos) ===");
            for (DuplicateGroup group : report.duplicates) {
                System.out.println();
                System.out.println("Autor: " + group.author);
                System.out.println("Nome : " + group.name);
                System.out.println("IDs  : " + group.ids);
            }

            System.out.println();
            System.out.println("Total de entradas analisadas: " + report.totalEntries);
            System.out.println("Total de entradas duplicadas (somando repetições): " + report.totalDuplicateEntries);
            System.out.println("Fim. KKKKKKKKKKKKK");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DuplicateReport findDuplicates(File jsonFile, boolean accentInsensitive) throws Exception {
        String raw = readTextFile(jsonFile).trim();
        JSONArray array = raw.isEmpty() ? new JSONArray() : new JSONArray(raw);

        Map<String, List<SongRef>> groups = new LinkedHashMap<>();

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String author = obj.optString("author", "").trim();
            String name = obj.optString("name", "").trim();
            int id = obj.optInt("ID", -1);

            // Se quiser, tu pode escolher ignorar entradas quebradas
            if (author.isEmpty() || name.isEmpty() || id <= 0) {
                continue;
            }

            String key = buildKey(author, name, accentInsensitive);
            groups.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new SongRef(author, name, id));
        }

        List<DuplicateGroup> duplicates = new ArrayList<>();
        int duplicateEntriesCount = 0;

        for (List<SongRef> list : groups.values()) {
            if (list.size() > 1) {
                list.sort(Comparator.comparingInt(s -> s.id));

                SongRef first = list.get(0);
                List<Integer> ids = new ArrayList<>();
                for (SongRef s : list) ids.add(s.id);

                duplicates.add(new DuplicateGroup(first.author, first.name, ids));
                duplicateEntriesCount += list.size();
            }
        }

        // Ordena grupos pelo primeiro ID pra ficar bonitinho
        duplicates.sort(Comparator.comparingInt(g -> g.ids.get(0)));

        return new DuplicateReport(array.length(), duplicates, duplicateEntriesCount);
    }

    private static String buildKey(String author, String name, boolean accentInsensitive) {
        String authorKey = normalizeText(author, accentInsensitive);
        String nameKey = normalizeText(name, accentInsensitive);
        return authorKey + "||" + nameKey;
    }

    private static String normalizeText(String text, boolean accentInsensitive) {
        String t = (text == null) ? "" : text;

        // Normaliza unicode (resolve variações estranhas)
        t = Normalizer.normalize(t, Normalizer.Form.NFKC);

        // Tira espaços repetidos e espaços nas pontas
        t = t.trim().replaceAll("\\s+", " ");

        // Lowercase estável
        t = t.toLowerCase(Locale.ROOT);

        if (accentInsensitive) {
            // Remove acentos: "Não" -> "Nao"
            String noMarks = Normalizer.normalize(t, Normalizer.Form.NFD);
            t = noMarks.replaceAll("\\p{M}+", "");
        }

        return t;
    }

    private static String readTextFile(File file) throws Exception {
        try {
            String s = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            System.out.println("Lendo JSON como UTF-8.");
            return s;
        } catch (Throwable ignored) {
            try {
                String s = Files.readString(file.toPath(), Charset.forName("windows-1252"));
                System.out.println("Lendo JSON como windows-1252 (ANSI).");
                return s;
            } catch (Throwable ignored2) {
                String s = Files.readString(file.toPath(), StandardCharsets.ISO_8859_1);
                System.out.println("Lendo JSON como ISO-8859-1 (fallback).");
                return s;
            }
        }
    }


    // ======= Modelos simples =======

    private static class SongRef {
        final String author;
        final String name;
        final int id;

        SongRef(String author, String name, int id) {
            this.author = author;
            this.name = name;
            this.id = id;
        }
    }

    public static class DuplicateGroup {
        public final String author;
        public final String name;
        public final List<Integer> ids;

        public DuplicateGroup(String author, String name, List<Integer> ids) {
            this.author = author;
            this.name = name;
            this.ids = ids;
        }
    }

    public static class DuplicateReport {
        public final int totalEntries;
        public final List<DuplicateGroup> duplicates;
        public final int totalDuplicateEntries;

        public DuplicateReport(int totalEntries, List<DuplicateGroup> duplicates, int totalDuplicateEntries) {
            this.totalEntries = totalEntries;
            this.duplicates = duplicates;
            this.totalDuplicateEntries = totalDuplicateEntries;
        }
    }
}

