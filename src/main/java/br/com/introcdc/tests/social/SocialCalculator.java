package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Coêlho at 08/07/2024 - 10:27
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialCalculator {

    private static final boolean FILE = true;
    private static PrintWriter printWriter;

    public static String FIRST_DAY = null;
    public static String LAST_DAY = null;
    public static String CURRENT_DAY = null;

    public static int DAYS_TOGETHER = 0;
    public static int DAYS_BETWEEN = 0;
    public static int DAYS_AWAY = 0;

    public static int TOTAL_DISTANCE = 0;

    public static String LK = "27/02/2025 - 16:36 - Terminal Antônio Bezerra";
    public static String LS = "02/03/2024 - 22:00 - Apartamento";
    public static String LS_B = "21/02/2025 - 02:30 - Apartamento";

    public static final Map<Integer, Integer> DAYS_TOGETHER_TIMES = new HashMap<>();
    public static final Map<Integer, Integer> DAYS_BETWEEN_TIMES = new HashMap<>();
    public static final Map<String, Integer> PLACES_TIMES = new HashMap<>();
    public static final Map<String, Integer> PLACES_NIGHT_TIMES = new HashMap<>();
    public static final Map<String, Integer> PER_YEAR = new HashMap<>();
    public static final Map<String, Integer> PER_MONTH = new HashMap<>();
    public static final Map<String, Integer> PER_DAY = new HashMap<>();

    public static void print() {
        print("");
    }

    public static void print(String line) {
        if (FILE) {
            printWriter.println(line);
        }
        System.out.println(line);
    }

    public static void main(String[] args) throws Exception {
        CURRENT_DAY = getCurrentDate();
        BufferedWriter writer = null;
        if (FILE) {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:/Documentos/Pessoas/Eduarda/saidas.txt"), StandardCharsets.UTF_8));
            printWriter = new PrintWriter(writer, true);
        }

        for (SocialRegister register : SocialRegister.values()) {
            register.print();
        }

        print();
        print();
        print();

        print("Primeiro dia que se viram: " + FIRST_DAY);
        print("Último dia que se viram: " + LAST_DAY);
        print("Dias que não se veem (" + CURRENT_DAY + "): " + calculateDaysBetween(LAST_DAY, CURRENT_DAY) + " Dias");
        print("Distância Total: " + (TOTAL_DISTANCE / 1000) + " KM");

        print();
        print("LK: " + LK);
        print("LS: " + LS);
        print("LS_B: " + LS_B);
        print();

        print("Dias Juntos: " + DAYS_TOGETHER + " Dias");
        print("Dias Separados: " + DAYS_AWAY + " Dias / Dias Separados (Diferença): " + DAYS_BETWEEN + " Dias");
        print("Dias que se conhecem: " + calculateDaysBetween(FIRST_DAY, CURRENT_DAY) + " Dias (" + (DAYS_TOGETHER + DAYS_AWAY) + " Dias únicos)");

        print();
        print();

        printInOrder(DAYS_TOGETHER_TIMES, "", " Dias", "x", "VEZES DE DIAS JUNTOS");
        printInOrder(DAYS_BETWEEN_TIMES, "", " Dias", "x", "VEZES DE DIAS SEPARADOS");

        print();
        print();

        printInOrder(PLACES_TIMES, "", "", "x", "LOCAIS MAIS IDOS");
        printInOrder(PLACES_NIGHT_TIMES, "", "", "x", "LOCAIS QUE MAIS PASSAMOS A NOITE");

        print();
        print();

        printInOrder(PER_YEAR, "Ano ", "", " Dias", "VEZES MAIS VISTOS POR ANO");
        printInOrder(PER_MONTH, "", "", " Dias", "VEZES MAIS VISTOS POR MÊS");
        printInOrder(PER_DAY, "Dia ", "", " Dias", "VEZES MAIS VISTOS POR DIA");

        if (FILE) {
            printWriter.flush();
            printWriter.close();
        }
    }

    public static int calculateDaysBetween(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    public static <T> void add(Map<T, Integer> hashMap, T key) {
        hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
    }

    public static <T> void printInOrder(Map<T, Integer> hashMap, String before, String after, String x, String title) {
        print(title + " (" + calculateAll(hashMap) + x + ")");
        List<T> keySet = new ArrayList<>(hashMap.keySet());
        while (!keySet.isEmpty()) {
            T biggest = null;
            int biggestValue = 0;
            for (T value : keySet) {
                if (hashMap.get(value) > biggestValue) {
                    biggestValue = hashMap.get(value);
                    biggest = value;
                }
            }
            if (biggest == null) {
                break;
            }

            keySet.remove(biggest);
            print(before + biggest + after + ": " + biggestValue + x);
        }
        print();
    }

    public static String dayToMonth(String day) {
        if (day.contains("/01/")) {
            return "Janeiro de " + day.substring(6);
        } else if (day.contains("/02/")) {
            return "Fevereiro de " + day.substring(6);
        } else if (day.contains("/03/")) {
            return "Março de " + day.substring(6);
        } else if (day.contains("/04/")) {
            return "Abril de " + day.substring(6);
        } else if (day.contains("/05/")) {
            return "Maio de " + day.substring(6);
        } else if (day.contains("/06/")) {
            return "Junho de " + day.substring(6);
        } else if (day.contains("/07/")) {
            return "Julho de " + day.substring(6);
        } else if (day.contains("/08/")) {
            return "Agosto de " + day.substring(6);
        } else if (day.contains("/09/")) {
            return "Setembro de " + day.substring(6);
        } else if (day.contains("/10/")) {
            return "Outubro de " + day.substring(6);
        } else if (day.contains("/11/")) {
            return "Novembro de " + day.substring(6);
        } else {
            return "Dezembro de " + day.substring(6);
        }
    }

    public static <T> int calculateAll(Map<T, Integer> map) {
        int total = 0;
        for (T key : map.keySet()) {
            total += map.get(key);
        }
        return total;
    }

}
