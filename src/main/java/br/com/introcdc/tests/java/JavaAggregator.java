package br.com.introcdc.tests.java;

import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class JavaAggregator {

    public static void main(String[] args) {
        Path srcDir = Paths.get("C:/Users/Bruno/Documents/GitHub/Kindome/src/main/java/br/com/kindome");
        Path output = Paths.get("Kindome.java");

        // 1) coleta recursivamente todos os .java
        List<Path> javaFiles;
        try (Stream<Path> stream = Files.walk(srcDir)) {
            javaFiles = stream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Erro ao vasculhar diretório: " + e.getMessage());
            return;
        }

        System.out.println("Classes encontradas: " + javaFiles.size());

        List<String> allLines = new ArrayList<>();

        // 2) lê cada arquivo: tenta UTF-8, se falhar tenta CP1252
        for (Path filePath : javaFiles) {
            List<String> fileLines;
            try {
                fileLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            } catch (MalformedInputException e) {
                System.err.println("Arquivo " + filePath.getFileName() + " não está em UTF-8, tentando CP1252");
                try {
                    fileLines = Files.readAllLines(filePath, Charset.forName("windows-1252"));
                } catch (IOException ex) {
                    System.err.println("Falha ao ler " + filePath.getFileName() + ": " + ex.getMessage());
                    continue;
                }
            } catch (IOException e) {
                System.err.println("Falha ao ler " + filePath.getFileName() + ": " + e.getMessage());
                continue;
            }
            allLines.addAll(fileLines);
        }

        // 3) escreve Combined.java em UTF-8
        try {
            Files.write(output, allLines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo gerado em: " + output.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Falha ao escrever Combined.java: " + e.getMessage());
        }
    }
}
