package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 15/09/2025 - 21:52
 */

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

/**
 * Lê um CSV com colunas:
 * topic_id;title;pid;video_id;youtube_url
 * e verifica no outro banco (tabela "topics", coluna "content_html")
 * se existe o token "{y:VIDEO_ID}" em QUALQUER tópico.
 * Se não tiver em nenhum, reporta no console e gera missing_youtube_embeds.csv.
 *
 * Nomes em inglês; logs/strings em português — padrão IntroCDC :)
 */
public class YouTubeEmbedVerifier {

    // ====== Config do BANCO #2 (onde está a tabela topics) ======
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/introcdc"
                    + "?useSSL=false"
                    + "&useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=America/Fortaleza"
                    + "&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Op9927198041";

    // ====== Config gerais ======
    private static final String INPUT_CSV = "youtube_videos.csv"; // ou passe via args[0]
    private static final String OUTPUT_MISSING_CSV = "missing_youtube_embeds.csv";

    // Campos esperados no CSV
    private static final String COL_TOPIC_ID = "topic_id";
    private static final String COL_TITLE = "title";
    private static final String COL_PID = "pid";
    private static final String COL_VIDEO_ID = "video_id";
    private static final String COL_YT_URL = "youtube_url";

    // Nome da tabela/colunas no BANCO #2
    private static final String TOPICS_TABLE = "topics";
    private static final String TOPIC_ID_COLUMN = "id";              // mantido caso você queira usar depois
    private static final String CONTENT_HTML_COLUMN = "content_html";

    public static void main(String[] args) {
        String csvPath = args != null && args.length > 0 ? args[0] : INPUT_CSV;
        System.out.println("Lendo CSV: " + csvPath + " ...");

        try {
            List<Map<String, String>> rows = loadCsv(csvPath);
            System.out.println("Linhas lidas (sem cabeçalho): " + rows.size());

            List<Map<String, String>> missing = verifyAgainstDatabase(rows);

            // Resumo + saída
            System.out.println();
            System.out.println("===== Resumo =====");
            System.out.println("Total no CSV: " + rows.size());
            System.out.println("Faltando embed no banco #2: " + missing.size());
            System.out.println("==================");

            if (!missing.isEmpty()) {
                writeMissingCsv(missing, OUTPUT_MISSING_CSV);
                System.out.println("Gerado: " + OUTPUT_MISSING_CSV + "  (com sugestão de token {y:...}) heuheuheu");
            } else {
                System.out.println("Tudo certo! Nenhum vídeo do CSV está faltando o {y:VIDEO_ID}. c:");
            }
        } catch (Exception e) {
            System.err.println("Erro geral: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Agora a verificação procura o token {y:ID} em QUALQUER tópico.
     * Se encontrar em qualquer linha de topics.content_html, considera OK.
     */
    private static List<Map<String, String>> verifyAgainstDatabase(List<Map<String, String>> rows) throws SQLException {
        List<Map<String, String>> missing = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            // Com ESCAPE explícito (MySQL padrão usa \ como escape)
            String sqlWithEscape = String.format(
                    "SELECT `%s` FROM `%s` WHERE `%s` LIKE ? ESCAPE '\\\\' LIMIT 1",
                    TOPIC_ID_COLUMN, TOPICS_TABLE, CONTENT_HTML_COLUMN
            );
            // Fallback se o servidor implicar com ESCAPE (ou sql_mode diferentão)
            String sqlNoEscape = String.format(
                    "SELECT `%s` FROM `%s` WHERE `%s` LIKE ? LIMIT 1",
                    TOPIC_ID_COLUMN, TOPICS_TABLE, CONTENT_HTML_COLUMN
            );

            PreparedStatement ps = null;
            boolean usingEscape = true;
            try {
                ps = conn.prepareStatement(sqlWithEscape);
            } catch (SQLException prepErr) {
                System.out.println("Aviso: falhou preparar com ESCAPE, caindo para LIKE sem ESCAPE: " + prepErr.getMessage());
                usingEscape = false;
                ps = conn.prepareStatement(sqlNoEscape);
            }

            int checked = 0, found = 0;

            for (Map<String, String> row : rows) {
                String topicIdCsv = row.getOrDefault(COL_TOPIC_ID, "").trim(); // apenas informativo/relatório
                String titleCsv   = row.getOrDefault(COL_TITLE, "").trim();
                String videoId    = row.getOrDefault(COL_VIDEO_ID, "").trim();
                if (videoId.isEmpty()) continue;

                // Token esperado em QUALQUER local: {y:VIDEO_ID}
                String token = "{y:" + videoId + "}";
                String like = "%" + escapeForLike(token) + "%";

                try {
                    ps.clearParameters();
                    ps.setString(1, like);

                    Long foundTopicId = null;
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            foundTopicId = rs.getLong(1);
                        }
                    }

                    checked++;
                    if (foundTopicId != null && foundTopicId > 0) {
                        found++;
                    } else {
                        // Não achou em nenhum lugar — marcar como faltando
                        System.out.printf("FALTANDO EM QUALQUER LUGAR: video_id %s (CSV http://forum.introcdc.com/topic/%s-random http://icdc.me/%s \"%s\")%n",
                                videoId, topicIdCsv, topicIdCsv, titleCsv);

                        Map<String, String> miss = new LinkedHashMap<>();
                        miss.put(COL_TOPIC_ID, topicIdCsv);
                        miss.put(COL_TITLE, titleCsv);
                        miss.put(COL_PID, row.getOrDefault(COL_PID, ""));
                        miss.put(COL_VIDEO_ID, videoId);
                        miss.put(COL_YT_URL, row.getOrDefault(COL_YT_URL, ""));
                        miss.put("suggested_token", token);
                        missing.add(miss);
                    }
                } catch (SQLSyntaxErrorException syn) {
                    // Se der erro de sintaxe em tempo de execução, troca em runtime
                    if (usingEscape) {
                        System.out.println("Aviso: erro de sintaxe com ESCAPE, trocando para LIKE sem ESCAPE: " + syn.getMessage());
                        usingEscape = false;
                        try { ps.close(); } catch (Exception ignore) {}
                        ps = conn.prepareStatement(sqlNoEscape);
                        // tenta de novo a MESMA linha sem ESCAPE
                        // (não incrementamos 'checked' nessa exceção, então só continuar reprocessando)
                        // Reprocessar manualmente:
                        ps.clearParameters();
                        ps.setString(1, like);

                        Long foundTopicId = null;
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                foundTopicId = rs.getLong(1);
                            }
                        }

                        checked++;
                        if (foundTopicId != null && foundTopicId > 0) {
                            System.out.printf("OK: video_id %s encontrado em topic #%d (CSV http://forum.introcdc.com/topic/%s-random, \"%s\")%n",
                                    videoId, foundTopicId, topicIdCsv, titleCsv);
                            // found++ ajustado abaixo pra manter contagem consistente
                            // (vamos incrementar agora)
                            found++;
                        } else {
                            System.out.printf("FALTANDO EM QUALQUER LUGAR: video_id %s (CSV topic_id=%s, \"%s\")%n",
                                    videoId, topicIdCsv, titleCsv);

                            Map<String, String> miss = new LinkedHashMap<>();
                            miss.put(COL_TOPIC_ID, topicIdCsv);
                            miss.put(COL_TITLE, titleCsv);
                            miss.put(COL_PID, row.getOrDefault(COL_PID, ""));
                            miss.put(COL_VIDEO_ID, videoId);
                            miss.put(COL_YT_URL, row.getOrDefault(COL_YT_URL, ""));
                            miss.put("suggested_token", token);
                            missing.add(miss);
                        }
                    } else {
                        throw syn; // já estamos sem ESCAPE, propaga erro real
                    }
                }
            }

            System.out.printf(Locale.ROOT,
                    "Verificados: %d | Encontrados em algum lugar: %d | Faltando: %d%n",
                    checked, found, missing.size());
        }

        return missing;
    }

    // Escapa caracteres especiais para LIKE (%, _ e \)
    private static String escapeForLike(String raw) {
        if (raw == null) return null;
        String s = raw.replace("\\", "\\\\"); // primeiro escapa a própria barra
        s = s.replace("%", "\\%");
        s = s.replace("_", "\\_");
        return s;
    }

    private static List<Map<String, String>> loadCsv(String path) throws IOException {
        List<String> lines = readAllLinesSmart(Paths.get(path));
        if (lines.isEmpty()) return Collections.emptyList();

        // Cabeçalho
        String header = stripBom(lines.get(0)).trim();
        String[] cols = header.split(";", -1);
        Map<String, Integer> pos = new HashMap<>();
        for (int i = 0; i < cols.length; i++) {
            pos.put(cols[i].trim().toLowerCase(Locale.ROOT), i);
        }

        requireHeader(pos, COL_TOPIC_ID, COL_TITLE, COL_PID, COL_VIDEO_ID, COL_YT_URL);

        List<Map<String, String>> out = new ArrayList<>();
        for (int li = 1; li < lines.size(); li++) {
            String line = lines.get(li);
            if (line == null) continue;
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(";", -1);
            Map<String, String> row = new LinkedHashMap<>();
            row.put(COL_TOPIC_ID, get(parts, pos.get(COL_TOPIC_ID)));
            row.put(COL_TITLE,   get(parts, pos.get(COL_TITLE)));
            row.put(COL_PID,     get(parts, pos.get(COL_PID)));
            row.put(COL_VIDEO_ID,get(parts, pos.get(COL_VIDEO_ID)));
            row.put(COL_YT_URL,  get(parts, pos.get(COL_YT_URL)));
            out.add(row);
        }
        return out;
    }

    // Lê o arquivo tentando múltiplas codificações, com detecção de BOM.
    private static List<String> readAllLinesSmart(Path path) throws IOException {
        // 1) Tenta detectar BOM rapidamente
        try (InputStream in = Files.newInputStream(path)) {
            byte[] bom = new byte[3];
            int n = in.read(bom, 0, 3);
            if (n >= 3 && (bom[0] & 0xFF) == 0xEF && (bom[1] & 0xFF) == 0xBB && (bom[2] & 0xFF) == 0xBF) {
                System.out.println("Info: CSV com BOM UTF-8 detectado.");
                return readAllLinesWithCharset(path, StandardCharsets.UTF_8, /*skipBom=*/true);
            }
        }
        // 2) Sem BOM claro: tenta em ordem até funcionar
        List<Charset> candidates = Arrays.asList(
                StandardCharsets.UTF_8,
                StandardCharsets.UTF_16LE,
                StandardCharsets.UTF_16BE,
                java.nio.charset.Charset.forName("windows-1252"),
                StandardCharsets.ISO_8859_1
        );
        IOException last = null;
        for (Charset cs : candidates) {
            try {
                List<String> lines = readAllLinesWithCharset(path, cs, /*skipBom=*/false);
                System.out.println("Info: CSV lido com charset: " + cs.displayName());
                return lines;
            } catch (java.nio.charset.MalformedInputException mie) {
                last = mie;
            }
        }
        // Se nada deu certo, relança a última exceção
        throw last != null ? last : new IOException("Falha ao detectar encoding do CSV.");
    }

    private static List<String> readAllLinesWithCharset(Path path, Charset cs, boolean skipBom) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first && skipBom && !line.isEmpty() && line.charAt(0) == '\uFEFF') {
                    line = line.substring(1);
                }
                lines.add(line);
                first = false;
            }
        }
        return lines;
    }

    private static String stripBom(String s) {
        if (s != null && !s.isEmpty() && s.charAt(0) == '\uFEFF') {
            return s.substring(1);
        }
        return s;
    }

    private static void requireHeader(Map<String, Integer> pos, String... required) {
        for (String r : required) {
            if (!pos.containsKey(r)) {
                throw new IllegalArgumentException("CSV faltando coluna obrigatória: " + r
                        + " (esperado cabeçalho: topic_id;title;pid;video_id;youtube_url)");
            }
        }
    }

    private static String get(String[] parts, Integer idx) {
        if (idx == null || idx < 0 || idx >= parts.length) return "";
        return parts[idx] == null ? "" : parts[idx].trim();
    }

    private static void writeMissingCsv(List<Map<String, String>> missing, String outPath) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(Paths.get(outPath), StandardCharsets.UTF_8)) {
            w.write("topic_id;title;pid;video_id;youtube_url;suggested_token;update_hint");
            w.newLine();
            for (Map<String, String> m : missing) {
                String topicId = m.getOrDefault(COL_TOPIC_ID, "");
                String title   = safeCsv(m.getOrDefault(COL_TITLE, ""));
                String pid     = m.getOrDefault(COL_PID, "");
                String vid     = m.getOrDefault(COL_VIDEO_ID, "");
                String url     = m.getOrDefault(COL_YT_URL, "");
                String token   = m.getOrDefault("suggested_token", "");

                // Dica de atualização (manual), sem executar nada:
                String hint = String.format(
                        "PROCURE O(S) TÓPICO(S) ONDE O VÍDEO %s DEVERIA ESTAR e ADICIONE no HTML: %s",
                        vid, token
                );

                w.write(String.join(";", Arrays.asList(
                        topicId, title, pid, vid, url, token, safeCsv(hint)
                )));
                w.newLine();
            }
        }
    }

    private static String safeCsv(String s) {
        if (s == null) return "";
        // troca ; por , e remove quebras
        return s.replace(";", ",").replace("\r", " ").replace("\n", " ").trim();
    }
}
