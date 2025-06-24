package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 30/05/2025 - 03:03
 */

import java.io.IOException;
import java.nio.file.*;

public class BulkRenamePng {

    // Altere para o diretório onde estão os PNGs
    private static final Path directoryPath = Paths.get("C:\\Users\\Bruno\\Downloads\\MiniGames");

    // Faixa original e novo offset
    private static final int originalStart = 324;
    private static final int originalEnd = 360; // inclusive
    private static final int newStart = 1;
    private static final int rangeStart = 0;   // inclusive
    private static final int rangeEnd = 36;  // inclusive
    private static final int shiftAmount = 1;   // +1

    public static void main(String[] args) {
        try {
            renameBatch();
            System.out.println("Renomeação concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Falha durante a renomeação: " + e.getMessage());
        }
    }

    private static void renameBatch() throws IOException {
        // Passo 1: renomeia para arquivos temporários, evitando colisões
        for (int i = originalStart; i <= originalEnd; i++) {
            Path source = directoryPath.resolve(i + ".png");
            if (Files.exists(source)) {
                Path temp = directoryPath.resolve(i + ".png.tmp");
                Files.move(source, temp, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // Passo 2: renomeia dos temporários para os nomes finais sequenciais
        for (int i = originalStart; i <= originalEnd; i++) {
            Path temp = directoryPath.resolve(i + ".png.tmp");
            if (Files.exists(temp)) {
                int indexOffset = i - originalStart;           // 324 ? 0, 325 ? 1, ...
                int newIndex = newStart + indexOffset;      // 0 … 204
                Path target = directoryPath.resolve(newIndex + ".png");
                Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private static void shiftBatch() throws IOException {
        // 1) Renomeia para .tmp (evita colisão com nomes destino)
        for (int i = rangeStart; i <= rangeEnd; i++) {
            Path src = directoryPath.resolve(i + ".png");
            if (Files.exists(src)) {
                Path tmp = directoryPath.resolve(i + ".png.tmp");
                Files.move(src, tmp, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // 2) Renomeia dos .tmp para o nome final incrementado
        for (int i = rangeEnd; i >= rangeEnd; i--) {
            Path tmp = directoryPath.resolve(i + ".png.tmp");
            if (Files.exists(tmp)) {
                int newIndex = i + shiftAmount;           // 0?1, 1?2…
                Path dst = directoryPath.resolve(newIndex + ".png");
                Files.move(tmp, dst, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

}

