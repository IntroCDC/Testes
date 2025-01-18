package br.com.introcdc.tests.love;
/*
 * Written by IntroCDC, Bruno Coêlho at 19/05/2024 - 20:17
 */

import java.util.*;

public class LoveMeter {

    public static String PERSON_1 = "Lucas da Silva";
    public static String PERSON_2 = "Fernanda Abravanel";

    public static void main(String[] args) {
        regulize();
        double bingAi = bingAi();
        double chatGPT = chatGPT();
        double gemini = gemini();
        double total = (bingAi + chatGPT + gemini) / 3;
        System.out.println("BingAI: " + percent(bingAi) + " " + getCompatibilityMessage(bingAi));
        System.out.println("ChatGPT: " + percent(chatGPT) + " " + getCompatibilityMessage(chatGPT));
        System.out.println("Gemini: " + percent(gemini) + " " + getCompatibilityMessage(gemini));
        System.out.println("TOTAL: " + percent(total) + " " + getCompatibilityMessage(total));
    }

    public static void regulize() {
        int maxLength = Math.max(PERSON_1.length(), PERSON_2.length());
        PERSON_1 = String.format("%-" + maxLength + "s", PERSON_1);
        PERSON_2 = String.format("%-" + maxLength + "s", PERSON_2);
    }

    private static String getCompatibilityMessage(double score) {
        String[] messages = {
                "Um casal sem nenhuma chance de dar certo.",
                "Melhor manterem a amizade.",
                "Há uma pequena chance de dar certo.",
                "Pode ser que funcione, mas vai precisar de muito esforço.",
                "Um relacionamento médio, pode funcionar se ambos se esforçarem.",
                "Um bom casal, com boas chances de dar certo.",
                "Um ótimo casal, com altas chances de sucesso.",
                "Um casal quase perfeito, com muito em comum.",
                "Um casal incrível, com quase certeza de sucesso.",
                "Casal perfeito, já deveriam estar juntos há tempos."
        };

        int index = Math.min((int) (score / 10), messages.length - 1);
        return messages[index];
    }

    public static String percent(double percent) {
        return String.format("%.2f%%", percent);
    }

    public static double bingAi() {
        int maxLength = Math.max(PERSON_1.length(), PERSON_2.length());
        int levenshteinDistance = calculateLevenshteinDistance(PERSON_1, PERSON_2);

        return (1 - ((double) levenshteinDistance / maxLength)) * 100;
    }

    private static int calculateLevenshteinDistance(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(text1.charAt(i - 1), text2.charAt(j - 1)), dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    public static double gemini() {
        return calcularCompatibilidade(PERSON_1, PERSON_2);
    }

    private static double calcularCompatibilidade(String nome1, String nome2) {
        nome1 = nome1.replaceAll("[^A-Za-z]", "").toUpperCase();
        nome2 = nome2.replaceAll("[^A-Za-z]", "").toUpperCase();

        int letrasIguais = 0;
        int minLength = Math.min(nome1.length(), nome2.length());
        for (int i = 0; i < minLength; i++) {
            if (nome1.charAt(i) == nome2.charAt(i)) {
                letrasIguais++;
            }
        }

        double porcentagem = (double) (letrasIguais * 2 * 100) / (nome1.length() + nome2.length());
        return Math.floor(porcentagem);
    }

    public static double chatGPT() {
        return calculateCompatibility(PERSON_1, PERSON_2) * 100;
    }

    public static double calculateCompatibility(String text1, String text2) {
        Map<String, Integer> wordFreq1 = getWordFrequency(text1);
        Map<String, Integer> wordFreq2 = getWordFrequency(text2);
        return cosineSimilarity(wordFreq1, wordFreq2);
    }

    private static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> wordFreq = new HashMap<>();
        String[] words = text.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        return wordFreq;
    }

    private static double cosineSimilarity(Map<String, Integer> freq1, Map<String, Integer> freq2) {
        Set<String> allWords = new HashSet<>(freq1.keySet());
        allWords.addAll(freq2.keySet());

        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (String word : allWords) {
            int count1 = freq1.getOrDefault(word, 0);
            int count2 = freq2.getOrDefault(word, 0);

            dotProduct += count1 * count2;
            norm1 += Math.pow(count1, 2);
            norm2 += Math.pow(count2, 2);
        }

        if (norm1 == 0 || norm2 == 0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

}
