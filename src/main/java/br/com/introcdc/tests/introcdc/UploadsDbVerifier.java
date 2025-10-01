package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 16/09/2025 - 23:56
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class UploadsDbVerifier {

    /* =========================
       CONFIGURAÇÕES – AJUSTA AQUI
       ========================= */
    private static final String UPLOADS_DIR   = "F:/IntroCDC/assets/uploads";
    private static final String FILES_TABLE   = "files";

    // JDBC
    private static final String DB_URL  = "jdbc:mysql://localhost:3306/introcdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/Fortaleza";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Op9927198041";

    // Segurança/fluxo
    private static final boolean DRY_RUN = false;          // true = só mostra o que faria
    private static final boolean UPSERT_EXISTING = false;  // true = também atualiza registros já existentes (ON DUPLICATE)

    // Ignorar arquivos com esses nomes
    private static final Set<String> IGNORE_FILES = Set.of("index.php");
    public static int totalFsCount = 0;

    // UUID v4
    private static final Pattern UUID_V4 = Pattern.compile(
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$"
    );

    public static void main(String[] args) {
        System.out.println("=== Registrar uploads faltantes no DB (" + LocalDateTime.now() + ") ===");
        System.out.println("Dir: " + UPLOADS_DIR + (DRY_RUN ? "  [MODO SIMULAÇÃO]" : ""));

        final Path root = Paths.get(UPLOADS_DIR);
        if (!Files.isDirectory(root)) {
            System.err.println("Diretório não existe: " + root.toAbsolutePath());
            return;
        }

        // 1) Coletar arquivos do FS
        Map<String, FsFile> fsByUuid = new LinkedHashMap<>(); // uuid(lower) -> FsFile (se houver duplicata de ext, fica o 1º)
        List<FsFile> nonUuidFiles = new ArrayList<>();

        try {
            Files.walkFileTree(root, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (!attrs.isRegularFile()) return FileVisitResult.CONTINUE;
                    String name = file.getFileName().toString();
                    if (IGNORE_FILES.contains(name.toLowerCase(Locale.ROOT))) return FileVisitResult.CONTINUE;

                    totalFsCount++;

                    String ext  = getExtension(name);
                    String base = getBaseName(name);

                    long size = 0L;
                    try { size = Files.size(file); } catch (IOException ignored) {}

                    FsFile f = new FsFile(name, base, ext, size, file);

                    if (UUID_V4.matcher(base).matches()) {
                        String key = base.toLowerCase(Locale.ROOT);
                        fsByUuid.putIfAbsent(key, f);
                    } else {
                        nonUuidFiles.add(f); // só reporta
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Erro lendo diretório: " + e.getMessage());
            return;
        }

        System.out.println("Arquivos no disco (sem ignorados): " + totalFsCount);
        System.out.println(" - com UUID v4: " + fsByUuid.size());
        System.out.println(" - NÃO-UUID (ignorados para insert): " + nonUuidFiles.size());

        // 2) Carregar UUIDs existentes no DB
        Set<String> existingUuids = new HashSet<>();
        int totalDb = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT uuid FROM " + FILES_TABLE)) {
            while (rs.next()) {
                String uuid = rs.getString(1);
                if (uuid != null) {
                    existingUuids.add(uuid.toLowerCase(Locale.ROOT));
                    totalDb++;
                }
            }
            System.out.println("Registros atuais no DB: " + totalDb);
        } catch (SQLException e) {
            System.err.println("Erro lendo DB: " + e.getMessage());
            return;
        }

        // 3) Montar lista de inserts (arquivos com UUID v4 que não existem no DB)
        List<FsFile> toInsert = new ArrayList<>();
        for (Map.Entry<String, FsFile> e : fsByUuid.entrySet()) {
            if (!existingUuids.contains(e.getKey())) {
                toInsert.add(e.getValue());
            }
        }

        System.out.println("\nFaltando no DB (candidatos a INSERT): " + toInsert.size());

        // 4) Inserir (e opcionalmente upsert em todos)
        String insertSql = UPSERT_EXISTING
                ? ("INSERT INTO " + FILES_TABLE + " (uuid, type, format, original_name, size_bytes, created_at) " +
                "VALUES (?, ?, ?, ?, ?, NOW()) " +
                "ON DUPLICATE KEY UPDATE type=VALUES(type), format=VALUES(format), original_name=VALUES(original_name), size_bytes=VALUES(size_bytes)")
                : ("INSERT INTO " + FILES_TABLE + " (uuid, type, format, original_name, size_bytes, created_at) " +
                "VALUES (?, ?, ?, ?, ?, NOW())");

        int inserted = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                if (UPSERT_EXISTING) {
                    // também atualiza os já existentes (upsert): vamos registrar/atualizar todos do disco com UUID v4
                    for (FsFile f : fsByUuid.values()) {
                        bindInsert(ps, f);
                        if (DRY_RUN) {
                            System.out.println("(simulação) UPSERT -> " + f.name + "  uuid=" + f.base);
                        } else {
                            ps.addBatch();
                        }
                    }
                } else {
                    // insere só os que não existem
                    for (FsFile f : toInsert) {
                        bindInsert(ps, f);
                        if (DRY_RUN) {
                            System.out.println("(simulação) INSERT -> " + f.name + "  uuid=" + f.base);
                        } else {
                            ps.addBatch();
                        }
                    }
                }

                if (!DRY_RUN) {
                    int[] res = ps.executeBatch();
                    for (int r : res) {
                        // INSERT retorna 1; ON DUPLICATE pode retornar 1 ou 2 (depende do modo/versão) — somar os que efetivamente inseriram é tricky.
                        // Conta todos os batch ok como "executados"; pra precisão de "inseridos" puro, dá pra checar antes. Aqui simplificamos:
                        inserted += (r >= 1 ? 1 : 0);
                    }
                    conn.commit();
                }
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            }
        } catch (SQLException e) {
            System.err.println("Erro de escrita no DB: " + e.getMessage());
            return;
        }

        System.out.println("\n==== Resumo ====");
        if (UPSERT_EXISTING) {
            System.out.println("UPSERTs executados (qtd batch): " + (DRY_RUN ? "(simulação)" : inserted));
        } else {
            System.out.println("Novos registros inseridos: " + (DRY_RUN ? "(simulação)" : inserted) + " / candidatos: " + toInsert.size());
        }

        if (!nonUuidFiles.isEmpty()) {
            System.out.println("\nAtenção — arquivos fora do padrão UUID (não inseridos): " + nonUuidFiles.size());
            nonUuidFiles.stream().limit(10).forEach(f -> System.out.println("  * " + f.name));
            System.out.println("Se quiser, eu te mando a versão que RENOMEIA esses caras pra UUID e atualiza tokens {a:...} nos tópicos. :P");
        }

        System.out.println("\n=== Fim, papai. Bora pro próximo passo! KKKKK ===");
    }

    /* ===== Helpers ===== */

    private static void bindInsert(PreparedStatement ps, FsFile f) throws SQLException {
        String type = inferType(f.ext);
        ps.clearParameters();
        ps.setString(1, f.base.toLowerCase(Locale.ROOT));             // uuid (lower)
        ps.setString(2, type);                                        // type
        ps.setString(3, f.ext.toLowerCase(Locale.ROOT));              // format (extensão)
        ps.setString(4, f.name);                                      // original_name (nome arquivo no disco)
        ps.setLong(5, f.size);                                        // size_bytes
    }

    private static String inferType(String ext) {
        String e = ext.toLowerCase(Locale.ROOT);
        if (Set.of("png","jpg","jpeg","gif","webp","bmp","svg","avif").contains(e)) return "image";
        if (Set.of("mp3","ogg","wav","flac","m4a","aac","opus").contains(e)) return "audio";
        if (Set.of("mp4","webm","mkv","mov","avi").contains(e)) return "video";
        return "file";
    }

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

    /* ===== Tipos ===== */

    private record FsFile(String name, String base, String ext, long size, Path path) {}

}
