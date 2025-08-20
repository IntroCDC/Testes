package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 16/08/2025 - 02:36
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Mp3VolumeBooster {

    private final String ffmpegPath; // ex.: "ffmpeg" se estiver no PATH, ou "C:\\ffmpeg\\bin\\ffmpeg.exe"
    private final int timeoutSeconds;

    public Mp3VolumeBooster(String ffmpegPath, int timeoutSeconds) {
        this.ffmpegPath = ffmpegPath == null || ffmpegPath.isBlank() ? "ffmpeg" : ffmpegPath;
        this.timeoutSeconds = timeoutSeconds <= 0 ? 600 : timeoutSeconds;
    }

    public void increaseVolumeByDb(Path input, Path output, double db, Integer targetBitrateKbps) throws IOException, InterruptedException {
        if (db == 0.0) {
            throw new IllegalArgumentException("Use um valor de dB diferente de 0 para fazer sentido.");
        }
        String volumeArg = String.format(Locale.ROOT, "volume=%sdB", trimTrailingZeros(db));
        runFfmpegVolume(input, output, volumeArg, targetBitrateKbps);
    }

    public void increaseVolumeByFactor(Path input, Path output, double factor, Integer targetBitrateKbps) throws IOException, InterruptedException {
        if (factor <= 0) {
            throw new IllegalArgumentException("O fator deve ser maior que 0 (ex.: 1.2 para +20%).");
        }
        String volumeArg = String.format(Locale.ROOT, "volume=%s", trimTrailingZeros(factor));
        runFfmpegVolume(input, output, volumeArg, targetBitrateKbps);
    }

    private void runFfmpegVolume(Path input, Path output, String volumeArg, Integer targetBitrateKbps) throws IOException, InterruptedException {
        Objects.requireNonNull(input, "input");
        Objects.requireNonNull(output, "output");

        if (!Files.exists(input)) {
            throw new FileNotFoundException("Arquivo de entrada não encontrado: " + input);
        }
        Files.createDirectories(output.toAbsolutePath().getParent());

        // Monta comando: ffmpeg -y -i in.mp3 -filter:a volume=... -c:a libmp3lame -q:a 2 out.mp3
        List<String> cmd = new ArrayList<>();
        cmd.add(ffmpegPath);
        cmd.add("-y");
        cmd.add("-v");
        cmd.add("error"); // logs limpos; troque para "info" se quiser mais detalhes
        cmd.add("-i");
        cmd.add(input.toAbsolutePath().toString());
        cmd.add("-filter:a");
        cmd.add(volumeArg);
        cmd.add("-c:a");
        cmd.add("libmp3lame");

        // Você pode escolher VBR por qualidade (q:a) OU CBR por bitrate
        if (targetBitrateKbps != null && targetBitrateKbps > 0) {
            cmd.add("-b:a");
            cmd.add(targetBitrateKbps + "k"); // CBR (ex.: 192k)
        } else {
            cmd.add("-q:a");
            cmd.add("2"); // VBR de alta qualidade (~190-220 kbps)
        }

        cmd.add(output.toAbsolutePath().toString());

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        String ffmpegOutput;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line).append(System.lineSeparator());
            ffmpegOutput = sb.toString();
        }

        boolean finished = p.waitFor(timeoutSeconds, TimeUnit.SECONDS);
        if (!finished) {
            p.destroyForcibly();
            throw new RuntimeException("Tempo excedido ao processar com o FFmpeg.");
        }
        if (p.exitValue() != 0) {
            throw new RuntimeException("FFmpeg falhou ao processar o áudio.\nSaída:\n" + ffmpegOutput);
        }
    }

    private static String trimTrailingZeros(double v) {
        String s = String.format(Locale.ROOT, "%.6f", v);
        // remove zeros e ponto final se desnecessários
        s = s.replaceAll("(\\.\\d*?[1-9])0+$", "$1");
        s = s.replaceAll("\\.0+$", "");
        return s;
    }

    public static void main(String[] args) {
        final Path inputDir = Paths.get("C:/Users/Bruno/Downloads/");
        final Path outputDir = inputDir.resolve("process");
        final String ffmpeg = "ffmpeg";   // mude para "C:\\ffmpeg\\bin\\ffmpeg.exe" se necessário
        final double gainDb = 3.0;        // +3 dB
        final Integer bitrateKbps = 192; // null = VBR (-q:a 2); use 192/256 p/ CBR
        final boolean skipIfExists = true;

        try {
            Files.createDirectories(outputDir);
        } catch (IOException e) {
            System.err.println("Falhou ao criar a pasta de saída: " + outputDir.toAbsolutePath());
            return;
        }

        File[] list = inputDir.toFile().listFiles();
        if (list == null) {
            System.err.println("Pasta de entrada inválida ou vazia: " + inputDir.toAbsolutePath());
            return;
        }

        Mp3VolumeBooster booster = new Mp3VolumeBooster(ffmpeg, 600);
        int ok = 0, fail = 0, skip = 0, total = 0;

        for (File file : list) {
            if (file == null || file.isDirectory()) continue;
            String name = file.getName();
            if (!name.toLowerCase(Locale.ROOT).endsWith(".mp3")) continue;

            total++;
            Path in  = file.toPath();
            Path out = outputDir.resolve(name);

            try {
                if (skipIfExists && Files.exists(out)) {
                    System.out.println("Pulando (já existe): " + out.toAbsolutePath());
                    skip++;
                    continue;
                }

                booster.increaseVolumeByDb(in, out, gainDb, bitrateKbps);
                System.out.println("OK: " + name + " -> " + out.toAbsolutePath());
                ok++;
            } catch (Exception e) {
                System.err.println("Falhou em " + name + ": " + e.getMessage());
                fail++;
            }
        }

        System.out.printf("Concluído! Sucesso: %d | Pulados: %d | Falhas: %d | Total MP3: %d%n",
                ok, skip, fail, total);
    }

}

