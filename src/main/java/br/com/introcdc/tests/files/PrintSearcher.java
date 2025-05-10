package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 08/01/2025 - 00:07
 */

import java.io.IOException;
import java.util.Scanner;

public class PrintSearcher {

    // Define o alfabeto utilizado nos URLs
    private static final String ALPHABET = "1234567890abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentURL = "5txxyv"; //"5txyhf";

        while (true) {
            // Gera a URL completa
            String fullURL = "https://prnt.sc/" + currentURL;
            System.out.println("Abrindo URL: " + fullURL);

            // Abre a URL no Chrome em modo anônimo
            openURLInIncognitoMode(fullURL);

            // Aguarda o usuário pressionar Enter para continuar
            System.out.println("Pressione Enter para abrir a URL anterior...");
            scanner.nextLine();

            // Gera a próxima URL decrementando a atual
            currentURL = decrementURL(currentURL);

            // Verifica se chegou ao início das combinações possíveis
            if (currentURL == null) {
                System.out.println("Não há mais URLs anteriores.");
                break;
            }
        }

        scanner.close();
    }

    // Método para abrir a URL no Chrome em modo anônimo
    private static void openURLInIncognitoMode(String url) {
        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Caminho padrão no Windows
        // String chromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"; // Caminho padrão no macOS
        // String chromePath = "/usr/bin/google-chrome"; // Caminho padrão no Linux

        ProcessBuilder processBuilder = new ProcessBuilder(chromePath, "--incognito", url);
        try {
            processBuilder.start();
        } catch (IOException e) {
            System.err.println("Erro ao abrir o Chrome: " + e.getMessage());
        }
    }

    // Método para decrementar a sequência de caracteres
    private static String decrementURL(String url) {
        char[] chars = url.toCharArray();
        int length = chars.length;

        for (int i = length - 1; i >= 0; i--) {
            int index = ALPHABET.indexOf(chars[i]);
            if (index > 0) {
                chars[i] = ALPHABET.charAt(index - 1);
                return new String(chars);
            } else {
                chars[i] = ALPHABET.charAt(ALPHABET.length() - 1);
            }
        }

        // Se todas as combinações possíveis foram alcançadas
        return null;
    }

}
