package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 16/09/2025 - 20:48
 */

import java.sql.*;
import java.util.*;

/**
 * Soma as views do schema "icdcboard.forums_topics" (colunas: tid, views)
 * no schema "introcdc.topics" (colunas: id, views), batendo por id/tid.
 *
 * ATENÇÃO: rode apenas uma vez (cada execução soma novamente!).
 */
public class MergeTopicViews {

    // ===== Ajusta aqui =====
    private static final String DB_HOST = "localhost";
    private static final int    DB_PORT = 3306;
    // Conecta em um schema (pode ser o "introcdc") e referencia os outros com nome qualificado.
    private static final String DB_NAME = "introcdc";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Op9927198041";

    // Modo simulação: true = não comita nada (só mostra quantos atualizaria)
    private static final boolean DRY_RUN = false;

    // Batch de updates por rodada
    private static final int BATCH_SIZE = 1000;

    public static void main(String[] args) {
        String url = String.format(
                "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8"
                        + "&serverTimezone=America/Fortaleza&useSSL=false"
                        + "&rewriteBatchedStatements=true&useCursorFetch=true&allowMultiQueries=false",
                DB_HOST, DB_PORT, DB_NAME
        );

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver do MySQL não encontrado. Adicione mysql-connector-j ao classpath.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            System.out.println("Iniciando leitura de tópicos existentes em introcdc.topics…");
            Set<Integer> existingIds = loadExistingTopicIds(conn);
            System.out.println("Tópicos existentes carregados: " + existingIds.size());

            System.out.println("Lendo views de icdcboard.forums_topics…");
            Map<Integer, Long> boardViews = loadBoardViews(conn);

            // Estatísticas
            long totalCandidates = boardViews.size();
            long totalMatched = 0;
            long totalMissing = 0;
            long totalViewsSum = 0;

            // Prep update
            String updateSql = "UPDATE introcdc.topics SET views = views + ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {

                int batchCount = 0;

                for (Map.Entry<Integer, Long> e : boardViews.entrySet()) {
                    int topicId = e.getKey();
                    long addViews = Math.max(0, e.getValue() == null ? 0L : e.getValue());

                    if (!existingIds.contains(topicId)) {
                        totalMissing++;
                        continue;
                    }

                    // pular quando addViews == 0 pra evitar update inútil
                    if (addViews <= 0) continue;

                    ps.setLong(1, addViews);
                    ps.setInt(2, topicId);
                    ps.addBatch();
                    batchCount++;
                    totalMatched++;
                    totalViewsSum += addViews;

                    if (batchCount >= BATCH_SIZE) {
                        if (!DRY_RUN) ps.executeBatch();
                        ps.clearBatch();
                        batchCount = 0;
                    }
                }

                if (batchCount > 0) {
                    if (!DRY_RUN) ps.executeBatch();
                    ps.clearBatch();
                }
            }

            if (DRY_RUN) {
                System.out.println("DRY_RUN ativo: nenhuma alteração foi gravada.");
                conn.rollback();
            } else {
                conn.commit();
            }

            System.out.println("===== RELATÓRIO =====");
            System.out.println("Total lido em icdcboard.forums_topics: " + totalCandidates);
            System.out.println("Encontrados em introcdc.topics:       " + totalMatched);
            System.out.println("Não encontrados (ignorados):           " + totalMissing);
            System.out.println("Views somadas no total:                " + totalViewsSum);
            System.out.println(DRY_RUN ? "Nenhuma mudança aplicada (simulação)." : "Transação confirmada. Tudo certo! c:");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erro SQL. Fazendo rollback…");
            // Tenta dar rollback se possível (em caso de autoCommit false)
            // Obs: se a conexão tiver caído, pode não rolar.
        }
    }

    private static Set<Integer> loadExistingTopicIds(Connection conn) throws SQLException {
        Set<Integer> ids = new HashSet<>(1024);
        String sql = "SELECT id FROM introcdc.topics";
        // Cursor fetch para evitar carregar tudo de uma vez em drivers antigos
        try (PreparedStatement ps = conn.prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY)) {
            ps.setFetchSize(Integer.MIN_VALUE); // ativa streaming em alguns drivers
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ids.add(rs.getInt(1));
                }
            }
        }
        return ids;
    }

    private static Map<Integer, Long> loadBoardViews(Connection conn) throws SQLException {
        Map<Integer, Long> map = new HashMap<>(4096);
        String sql = "SELECT tid, COALESCE(views,0) AS views FROM icdcboard.forums_topics";
        try (PreparedStatement ps = conn.prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY)) {
            ps.setFetchSize(Integer.MIN_VALUE);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int tid = rs.getInt("tid");
                    long views = rs.getLong("views");
                    map.put(tid, views);
                }
            }
        }
        return map;
    }
}
