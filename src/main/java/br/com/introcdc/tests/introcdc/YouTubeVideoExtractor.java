package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 15/09/2025 - 21:46
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YouTubeVideoExtractor {

    // ====== Config do banco (ajuste aqui) ======
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/icdcboard"
                    + "?useSSL=false"
                    + "&useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=America/Fortaleza"
                    + "&allowPublicKeyRetrieval=true"
                    // Para varredura eficiente de muitos registros (Connector/J 8+):
                    + "&useCursorFetch=true&defaultFetchSize=1000";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Op9927198041";

    // ====== Regex robusto p/ YouTube (vários formatos) ======
    // Captura ID (11 chars) em:
    // - youtu.be/ID
    // - youtube.com/watch?v=ID
    // - youtube.com/embed/ID
    // - youtube.com/shorts/ID
    // - youtube.com/live/ID
    // - youtube-nocookie.com/embed/ID
    private static final Pattern YT_PATTERN = Pattern.compile(
            "(?i)(?:https?:\\/\\/(?:www\\.|m\\.)?)?"
                    + "(?:youtu\\.be\\/|youtube(?:-nocookie)?\\.com\\/(?:watch\\?.*?v=|embed\\/|shorts\\/|live\\/))"
                    + "([A-Za-z0-9_-]{11})"
    );

    public static void main(String[] args) {
        System.out.println("Iniciando varredura de vídeos do YouTube no fórum... heuheuheu");
        try {
            runExtraction();
            System.out.println("Concluído! Arquivo gerado: youtube_videos.csv  :D");
        } catch (Exception e) {
            System.err.println("Deu ruim na extração: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void runExtraction() throws SQLException, IOException {
        // Dica: filtra posts que provavelmente têm link do YT p/ acelerar.
        // Se quiser varrer tudo, remova o WHERE.
        final String sql =
                "SELECT p.pid, p.topic_id, p.post, t.title " +
                        "FROM forums_posts p " +
                        "JOIN forums_topics t ON t.tid = p.topic_id " +
                        "WHERE p.post LIKE '%youtu%' OR p.post LIKE '%youtube%'";

        int scanned = 0;
        int matchedPosts = 0;
        int totalIds = 0;

        // Para CSV
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(sql,
                     ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY);
             BufferedWriter csv = new BufferedWriter(new FileWriter("youtube_videos.csv"))) {

            // Streaming (com useCursorFetch=true no URL)
            ps.setFetchSize(1000);

            // Cabeçalho do CSV
            csv.write("topic_id;title;pid;video_id;youtube_url");
            csv.newLine();

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    scanned++;

                    long pid = rs.getLong("pid");
                    long topicId = rs.getLong("topic_id");
                    String postHtml = rs.getString("post");
                    String title = rs.getString("title");

                    Set<String> ids = extractVideoIds(postHtml);
                    if (!ids.isEmpty()) {
                        matchedPosts++;
                        for (String id : ids) {
                            totalIds++;
                            String url = "https://youtu.be/" + id;
                            // Print no console
                            System.out.printf("Tópico #%d | \"%s\" | PID %d | ID %s | %s%n",
                                    topicId, title, pid, id, url);
                            // Linha no CSV
                            csv.write(topicId + ";" + escapeCsv(title) + ";" + pid + ";" + id + ";" + url);
                            csv.newLine();
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println("===== Resumo =====");
        System.out.println("Posts varridos: " + scanned);
        System.out.println("Posts com vídeos: " + matchedPosts);
        System.out.println("Total de IDs encontrados: " + totalIds);
        System.out.println("==================");
    }

    private static Set<String> extractVideoIds(String html) {
        Set<String> ids = new LinkedHashSet<>();
        if (html == null || html.isEmpty()) return ids;

        // 1) Regex principal (pega embed/shorts/live/watch e youtu.be)
        Matcher m = YT_PATTERN.matcher(html);
        while (m.find()) {
            String id = m.group(1);
            if (isValidYouTubeId(id)) {
                ids.add(id);
            }
        }

        // 2) Fallback: casos raros onde só aparece "v=" perdido após "youtube.com"
        //    Ex.: ...youtube.com/watch?foo=bar&v=XXXXXXXXXXX&...
        //    Vamos fazer um parse leve: procurar "youtube.com" e, na janela próxima, capturar "v=".
        if (ids.isEmpty() && html.toLowerCase().contains("youtube.com")) {
            ids.addAll(extractByVParamHeuristic(html));
        }

        return ids;
    }

    private static boolean isValidYouTubeId(String id) {
        return id != null && id.length() == 11 && id.matches("[A-Za-z0-9_-]+");
    }

    // Heurística opcional para capturar v=ID quando o link está muito “quebrado”
    private static Set<String> extractByVParamHeuristic(String html) {
        Set<String> ids = new LinkedHashSet<>();
        String lower = html.toLowerCase(Locale.ROOT);
        int idx = 0;
        while ((idx = lower.indexOf("youtube.com", idx)) != -1) {
            int end = Math.min(idx + 300, html.length()); // janela local
            String window = html.substring(idx, end);
            // procurar v=XXXXXXXXXXX
            Matcher vm = Pattern.compile("v=([A-Za-z0-9_-]{11})").matcher(window);
            while (vm.find()) {
                String id = vm.group(1);
                if (isValidYouTubeId(id)) ids.add(id);
            }
            idx = idx + 10;
        }
        return ids;
    }

    private static String escapeCsv(String s) {
        if (s == null) return "";
        // CSV simples com ; como separador — escapando quebras de linha e ;
        String out = s.replace("\r", " ").replace("\n", " ").trim();
        out = out.replace(";", ",");
        return out;
    }

}
