package br.com.introcdc.tests.sites;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LogAnalyser {

    public static final List<String> allowed = Arrays.asList("191.34.182.207", "179.185.191.151", "187.79.175.36", "54.193.46.142", "188.40.126.66", "177.194.190.201");

    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando analizador...");
        File file = new File("C:/Users/Intro/Desktop/Log.txt");
        Scanner scanner = new Scanner(file);
        List<String> logs = new ArrayList<>();
        System.out.println("Analisando logs...");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.contains("Java")) {
                if (line.split(" ")[0].contains(".")) {
                    if (!allowed.contains(line.split(" ")[0])) {
                        logs.add(line);
                        System.out.println("Acesso não permitido encontrado!");
                    }
                }
            }
        }
        System.out.println("Analise efetuada!");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("Acessos negados:" + logs.size());
        scanner.close();
    }

}
