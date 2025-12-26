package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 17/12/2025 - 17:37
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WavToOggConverter {

    // === CONFIG ===
    private static final boolean RECURSIVE = true;          // converter subpastas também
    private static final boolean OVERWRITE = false;         // se true, sobrescreve ogg existente
    private static final int FFMPEG_TIMEOUT_MINUTES = 10;   // timeout por arquivo
    private static final int OGG_QUALITY = 5;               // 0..10 (libvorbis). 5 é um bom padrão

    public static void main(String[] args) throws Exception {
        Path inputDir = Paths.get("C:/Users/Bruno/Desktop").toAbsolutePath().normalize();
        Path outputDir = Paths.get("C:/Users/Bruno/Downloads").toAbsolutePath().normalize();
        String ffmpegPath = "ffmpeg";

        if (!Files.isDirectory(inputDir)) {
            System.out.println("Pasta de entrada não existe: " + inputDir);
            return;
        }
        Files.createDirectories(outputDir);

        System.out.println("Entrada: " + inputDir);
        System.out.println("Saída:   " + outputDir);
        System.out.println("FFmpeg:  " + ffmpegPath);
        System.out.println();

        List<Path> wavFiles = listWavFiles(inputDir, RECURSIVE);
        if (wavFiles.isEmpty()) {
            System.out.println("Nenhum .wav encontrado.");
            return;
        }

        int converted = 0;
        int skipped = 0;
        int failed = 0;

        long startAll = System.currentTimeMillis();

        for (Path wav : wavFiles) {
            Path relative = inputDir.relativize(wav);
            Path outFile = outputDir.resolve(changeExtension(relative, ".ogg"));
            Files.createDirectories(outFile.getParent());

            if (!OVERWRITE && Files.exists(outFile)) {
                System.out.println("[PULOU] Já existe: " + outFile);
                skipped++;
                continue;
            }

            System.out.println("[CONVERT] " + relative + " -> " + outputDir.relativize(outFile));
            boolean ok = convertWithFfmpeg(ffmpegPath, wav, outFile, OGG_QUALITY);

            if (ok) converted++;
            else failed++;
        }

        long tookMs = System.currentTimeMillis() - startAll;

        System.out.println();
        System.out.println("===== RESUMO =====");
        System.out.println("Total:       " + wavFiles.size());
        System.out.println("Convertidos: " + converted);
        System.out.println("Pulados:     " + skipped);
        System.out.println("Falharam:    " + failed);
        System.out.println("Tempo:       " + (tookMs / 1000.0) + "s");
    }

    private static List<Path> listWavFiles(Path dir, boolean recursive) throws IOException {
        List<Path> result = new ArrayList<>();
        if (recursive) {
            try (var stream = Files.walk(dir)) {
                stream.filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".wav"))
                        .forEach(result::add);
            }
        } else {
            try (var stream = Files.list(dir)) {
                stream.filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".wav"))
                        .forEach(result::add);
            }
        }
        return result;
    }

    private static Path changeExtension(Path path, String newExt) {
        String name = path.getFileName().toString();
        int dot = name.lastIndexOf('.');
        String base = dot >= 0 ? name.substring(0, dot) : name;
        String newName = base + newExt;
        return path.getParent() == null ? Paths.get(newName) : path.getParent().resolve(newName);
    }

    private static boolean convertWithFfmpeg(String ffmpegPath, Path inWav, Path outOgg, int quality) {
        // -y sobrescreve, -n não sobrescreve
        String overwriteFlag = OVERWRITE ? "-y" : "-n";

        // libvorbis é o padrão mais compatível pro Minecraft (ogg vorbis)
        List<String> cmd = List.of(
                ffmpegPath,
                overwriteFlag,
                "-hide_banner",
                "-loglevel", "error",
                "-i", inWav.toString(),
                "-c:a", "libvorbis",
                "-q:a", String.valueOf(quality),
                outOgg.toString()
        );

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);

        try {
            Process proc = pb.start();

            // lê logs do ffmpeg (se der erro ele aparece aqui)
            String output = readAll(proc);

            boolean finished = proc.waitFor(FFMPEG_TIMEOUT_MINUTES, TimeUnit.MINUTES);
            if (!finished) {
                proc.destroyForcibly();
                System.out.println("  [ERRO] Timeout no ffmpeg: " + inWav);
                return false;
            }

            int code = proc.exitValue();
            if (code != 0) {
                System.out.println("  [ERRO] ffmpeg saiu com código " + code + " em: " + inWav);
                if (!output.isBlank()) System.out.println("  [LOG] " + output.trim());
                return false;
            }

            if (!Files.exists(outOgg) || Files.size(outOgg) == 0) {
                System.out.println("  [ERRO] Saída .ogg não foi gerada corretamente: " + outOgg);
                return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("  [ERRO] Exceção ao converter " + inWav + ": " + e.getMessage());
            return false;
        }
    }

    private static String readAll(Process proc) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }
}

