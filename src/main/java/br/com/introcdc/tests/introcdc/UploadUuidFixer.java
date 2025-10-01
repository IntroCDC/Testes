package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 16/09/2025 - 20:00
 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class UploadUuidFixer {

    /* =========================
       CONFIGURAÇÕES – AJUSTA AQUI
       ========================= */
    private static final String UPLOADS_DIR = "F:/IntroCDC/assets/uploads";
    // Nome da tabela de uploads (a da tua screenshot)
    private static final String UPLOADS_TABLE = "files";
    // Tabela e coluna onde estão os tokens {a:arquivo.ext}
    private static final String TOPICS_TABLE = "topics";
    private static final String TOPICS_CONTENT_COL = "content_html";

    // JDBC (ajusta conforme teu ambiente)
    private static final String DB_URL  = "jdbc:mysql://localhost:3306/introcdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/Fortaleza";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Op9927198041";

    // Modo simulação (true = NÃO altera nada; só mostra o que faria)
    private static final boolean DRY_RUN = false;

    /* =========================
       IMPLEMENTAÇÃO
       ========================= */

    private static final Pattern UUID_V4_PATTERN = Pattern.compile(
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$"
    );

    public static void main(String[] args) {
        System.out.println("Iniciando varredura em: " + UPLOADS_DIR + (DRY_RUN ? " (MODO SIMULAÇÃO)" : ""));
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            Path root = Paths.get(UPLOADS_DIR);
            if (!Files.isDirectory(root)) {
                System.err.println("Diretório não existe: " + root.toAbsolutePath());
                return;
            }

            List<Action> actions = new ArrayList<>();

            // 1) Descobrir arquivos candidatos
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    try {
                        if (!attrs.isRegularFile()) return FileVisitResult.CONTINUE;

                        String name = file.getFileName().toString();
                        // Ignorar index.php
                        if (name.equalsIgnoreCase("index.php")) return FileVisitResult.CONTINUE;

                        String ext = getExtension(name).toLowerCase(Locale.ROOT);
                        String base = getBaseName(name);

                        // Só mexe se base < 36
                        if (base.length() < 36 || !UUID_V4_PATTERN.matcher(base).matches()) {
                            // Gera um novo UUID v4
                            String newUuid = UUID.randomUUID().toString();
                            String newName = newUuid + (ext.isEmpty() ? "" : "." + ext);
                            Path target = file.resolveSibling(newName);

                            // Evitar colisão por via das dúvidas
                            while (Files.exists(target)) {
                                newUuid = UUID.randomUUID().toString();
                                newName = newUuid + (ext.isEmpty() ? "" : "." + ext);
                                target = file.resolveSibling(newName);
                            }

                            long size = Files.size(file);
                            String type = inferType(ext);
                            String format = ext;

                            actions.add(new Action(file, target, name, newName, newUuid, type, format, size));
                        }
                    } catch (IOException e) {
                        System.err.println("Falha ao ler arquivo: " + file + " -> " + e.getMessage());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            if (actions.isEmpty()) {
                System.out.println("Nenhum arquivo para renomear/registrar. Tudo certo por aqui. :D");
                return;
            }

            // 2) Preparar statements
            String upsertSql =
                    "INSERT INTO " + UPLOADS_TABLE + " (uuid, type, format, original_name, size_bytes, created_at) " +
                            "VALUES (?, ?, ?, ?, ?, NOW()) " +
                            "ON DUPLICATE KEY UPDATE " +
                            "  type = VALUES(type), " +
                            "  format = VALUES(format), " +
                            "  original_name = VALUES(original_name), " +
                            "  size_bytes = VALUES(size_bytes)";

            String updateTopicsSql =
                    "UPDATE " + TOPICS_TABLE + " " +
                            "SET " + TOPICS_CONTENT_COL + " = REPLACE(" + TOPICS_CONTENT_COL + ", ?, ?) " +
                            "WHERE " + TOPICS_CONTENT_COL + " LIKE ?";

            try (PreparedStatement psUpsert = conn.prepareStatement(upsertSql);
                 PreparedStatement psTopics = conn.prepareStatement(updateTopicsSql)) {

                int renamed = 0, inserted = 0, topicsTouched = 0;

                for (Action a : actions) {
                    System.out.println("-> Vai renomear: " + a.oldName + "  ?  " + a.newName);

                    // 2.1 Renomear no disco
                    if (!DRY_RUN) {
                        try {
                            Files.move(a.src, a.dst, StandardCopyOption.ATOMIC_MOVE);
                        } catch (AtomicMoveNotSupportedException e) {
                            Files.move(a.src, a.dst, StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                    renamed++;

                    // 2.2 Registrar/atualizar na tabela de uploads
                    psUpsert.clearParameters();
                    psUpsert.setString(1, a.newUuid);
                    psUpsert.setString(2, a.type);
                    psUpsert.setString(3, a.format);
                    psUpsert.setString(4, a.oldName); // original_name = nome antigo completo (com extensão)
                    psUpsert.setLong(5, a.sizeBytes);

                    if (!DRY_RUN) {
                        inserted += psUpsert.executeUpdate();
                    } else {
                        System.out.println("   (simulação) Inseriria no banco: uuid=" + a.newUuid + ", type=" + a.type + ", format=" + a.format + ", original_name=" + a.oldName + ", size=" + a.sizeBytes);
                    }

                    // 2.3 Atualizar tokens {a:oldFile} -> {a:newFile} no topics.content_html
                    String oldToken = "{a:" + a.oldName + "}";
                    String newToken = "{a:" + a.newName + "}";

                    psTopics.clearParameters();
                    psTopics.setString(1, oldToken);
                    psTopics.setString(2, newToken);
                    psTopics.setString(3, "%" + oldToken + "%");

                    if (!DRY_RUN) {
                        int affected = psTopics.executeUpdate();
                        topicsTouched += affected;
                        if (affected > 0) {
                            System.out.println("   Atualizados " + affected + " registro(s) em topics para " + a.oldName + " ? " + a.newName);
                        }
                    } else {
                        System.out.println("   (simulação) Atualizaria tokens em topics: " + oldToken + " ? " + newToken);
                    }
                }

                if (!DRY_RUN) {
                    conn.commit();
                }

                System.out.println("\nResumo:");
                System.out.println(" - Arquivos renomeados: " + renamed);
                System.out.println(" - Registros inseridos/atualizados em '" + UPLOADS_TABLE + "': " + (DRY_RUN ? "(simulação)" : inserted));
                System.out.println(" - Registros de tópicos atualizados: " + (DRY_RUN ? "(simulação)" : topicsTouched));
                System.out.println("Concluído em " + LocalDateTime.now() + ". heuheuheu :P");

            } catch (Exception e) {
                conn.rollback();
                throw e;
            }

        } catch (Exception e) {
            System.err.println("Falha geral: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===== Helpers ===== */

    private static String getExtension(String filename) {
        int i = filename.lastIndexOf('.');
        if (i <= 0 || i == filename.length() - 1) return "";
        return filename.substring(i + 1);
    }

    private static String getBaseName(String filename) {
        int i = filename.lastIndexOf('.');
        if (i <= 0) return filename;
        return filename.substring(0, i);
    }

    private static String inferType(String ext) {
        String e = ext.toLowerCase(Locale.ROOT);
        if (Set.of("png","jpg","jpeg","gif","webp","bmp","svg","avif").contains(e)) return "image";
        if (Set.of("mp3","ogg","wav","flac","m4a","aac","opus").contains(e)) return "audio";
        if (Set.of("mp4","webm","mkv","mov","avi").contains(e)) return "video";
        return "file";
    }

    private record Action(Path src, Path dst, String oldName, String newName,
                          String newUuid, String type, String format, long sizeBytes) {}
}
