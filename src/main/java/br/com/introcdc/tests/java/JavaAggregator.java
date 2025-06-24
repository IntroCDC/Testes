package br.com.introcdc.tests.java;

import br.com.introcdc.tests.database.StringComponents;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaAggregator {

    public static void main(String[] args) {
        Path srcDir = Paths.get("C:/Users/Bruno/Documents/GitHub/Kindome/src/main/java/br/com/kindome/minigames/instance/group/groups");
        Path output = Paths.get("Groups.java");

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
                try {
                    fileLines = Files.readAllLines(filePath, Charset.forName("windows-1252"));
                } catch (IOException ex) {
                    continue;
                }
            } catch (IOException e) {
                continue;
            }
            allLines.addAll(fileLines);
        }

        boolean print = false;
        List<String> events = StringComponents.arrayList();
        for (String line : allLines) {
            if (line.contains("@MiniGameEvent")) {
                print = true;
            } else if (print) {
                print = false;
                String fullLine = line.split("\\(")[1].split(" event")[0];
                if (!events.contains(fullLine)) {
                    events.add(fullLine);
                    System.out.println(fullLine);
                }
            }
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
