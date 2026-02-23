package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Coelho at 08/07/2024 - 10:27
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

    public static String LK = "20/02/2026 - 14:33 (Apartamento)";

    public static String LS_B = """
            #1 29/09/2023 - 16:00 (Apartamento)
            #2 08/10/2023 - 14:00 (Apartamento)
            #3 02/03/2024 - 22:00 (Apartamento)
            #4 21/02/2025 - 02:30 (Apartamento) //
            #5 30/03/2025 - 14:00 (Barragem do Catolé) //
            #6 30/03/2025 - 19:30 (Pousada Boro) //
            #7 24/05/2025 - 22:20 (Apartamento)
            #8 21/06/2025 - 19:12 (Ponte dos Ingleses) //
            #9 10/07/2025 - 02:50 (Casa)
            #10 25/07/2025 - 13:00 (Apartamento)
            #11 04/08/2025 - 03:15 (Apartamento)
            #12 18/04/2025 - 17:03 (Apartamento)
            #13 31/08/2025 - 00:30 (Apartamento)
            #14 26/09/2025 - 13:00 (Apartamento) //
            #15 27/09/2025 - 00:30 (Apartamento)
            #16 11/10/2025 - 10:00 (Apartamento)
            #17 23/10/2025 - 09:00 (Apartamento) //
            #18 23/10/2025 - 17:25 (Iguatemi) //
            #19 23/10/2025 - 18:30 (Apartamento)
            #20 27/10/2025 - 01:30 (Apartamento) //
            #21 27/10/2025 - 07:30 (Apartamento)
            #22 10/11/2025 - 09:20 (Apartamento) //
            #23 22/11/2025 - 07:55 (Casa) //
            #24 23/11/2025 - 08:15 (Casa) //
            #25 06/12/2025 - 23:00 (Casa) //
            #26 24/12/2025 - 09:10 (Apartamento)
            #27 25/12/2025 - 21:46 (CE-085) //
            #28 26/12/2025 - 03:20 (São Gonçalo do Amarante) //
            #29 25/01/2026 - 00:00 (Apartamento - Sala/Quarto) //
            #30 06/02/2026 - 22:30 (Apartamento - Quarto) //
            #31 20/02/2026 - 01:30 (Apartamento - Quarto) //""";

    public static String LS = """
            #1 08/10/2023 - 14:00 (Apartamento - Quarto (Umbrella))
            #2 02/03/2024 - 22:00 (Apartamento - Sala (Call My Name))
            #3 30/03/2025 - 19:30 (Pousada Boro - (P Diddy))
            #4 24/05/2025 - 22:20 (Apartamento - Quarto)
            #5 22/06/2025 - 00:00 (Apartamento - Quarto (Call My Name))
            #6 04/08/2025 - 03:30 (Apartamento - Quarto)
            #7 18/08/2025 - 17:23 (Apartamento - Quarto)
            #8 31/08/2025 - 00:30 (Apartamento - Quarto)
            #9 27/10/2025 - 07:30 (Apartamento - Quarto)
            #10 10/11/2025 - 09:20 (Apartamento - Banheiro)
            #11 06/12/2025 - 23:00 (Casa - Quarto)
            #12 24/12/2025 - 09:10 (Apartamento - Quarto)
            #13 26/12/2025 - 03:20 (São Gonçalo do Amarante - 3°36'40.6"S 38°58'14.5"W)
            #14 06/02/2026 - 22:30 (Apartamento - Quarto)
            #15 20/02/2026 - 01:30 (Apartamento - Varanda, Quarto)""";

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
        print("LS:");
        print(LS);
        print("LS_B:");
        print(LS_B);
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

            JsonObject json = createJson();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (BufferedWriter jsonWriter = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("F:/IntroCDC/assets/ajax/info.json"),
                            StandardCharsets.UTF_8
                    )
            )) {
                gson.toJson(json, jsonWriter);
            }
        }
    }

    public static JsonObject createJson() {
        JsonObject root = new JsonObject();

        // ==== META / VISÃO GERAL ====
        JsonObject meta = new JsonObject();
        meta.addProperty("firstDay", FIRST_DAY);
        meta.addProperty("lastDay", LAST_DAY);
        meta.addProperty("currentDay", CURRENT_DAY);

        if (FIRST_DAY != null && CURRENT_DAY != null) {
            meta.addProperty("daysKnown", calculateDaysBetween(FIRST_DAY, CURRENT_DAY));
        }

        meta.addProperty("uniqueDays", DAYS_TOGETHER + DAYS_AWAY);
        meta.addProperty("daysTogether", DAYS_TOGETHER);
        meta.addProperty("daysAway", DAYS_AWAY);
        meta.addProperty("daysBetweenSum", DAYS_BETWEEN);
        meta.addProperty("totalDistanceMeters", TOTAL_DISTANCE);
        meta.addProperty("totalDistanceKm", TOTAL_DISTANCE / 1000.0);
        root.add("meta", meta);

        // ==== TEXTOS ESPECIAIS ====
        JsonObject notes = new JsonObject();
        notes.addProperty("lk", LK);
        notes.addProperty("ls", LS);
        notes.addProperty("ls_b", LS_B);
        root.add("notes", notes);

        // ==== ESTATÍSTICAS AGREGADAS ====
        JsonObject stats = new JsonObject();
        stats.add("daysTogetherHistogram", mapToJson(DAYS_TOGETHER_TIMES));
        stats.add("daysBetweenHistogram", mapToJson(DAYS_BETWEEN_TIMES));
        stats.add("placesCount", mapToJson(PLACES_TIMES));
        stats.add("placesNightCount", mapToJson(PLACES_NIGHT_TIMES));
        stats.add("perYear", mapToJson(PER_YEAR));
        stats.add("perMonth", mapToJson(PER_MONTH));
        stats.add("perDayOfMonth", mapToJson(PER_DAY));
        root.add("stats", stats);

        // ==== TIMELINE COMPLETA ====
        JsonArray timeline = new JsonArray();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (SocialRegister register : SocialRegister.values()) {
            JsonObject regJson = new JsonObject();
            regJson.addProperty("id", register.name());
            regJson.addProperty("number", register.getNumber());
            regJson.addProperty("title", register.getTitle());
            regJson.addProperty("daysCount", register.getDays().length);
            regJson.addProperty("totalDistanceMeters", register.getTotalDistance());
            regJson.addProperty("totalDistanceKm", register.getTotalDistance() / 1000.0);

            JsonArray daysJson = new JsonArray();
            SocialDay[] days = register.getDays();

            for (int i = 0; i < days.length; i++) {
                SocialDay day = days[i];
                JsonObject dayJson = new JsonObject();

                dayJson.addProperty("index", i + 1);
                dayJson.addProperty("date", day.getDay());

                // Detalhes de data
                try {
                    LocalDate date = LocalDate.parse(day.getDay(), formatter);
                    dayJson.addProperty("year", date.getYear());
                    dayJson.addProperty("month", date.getMonthValue());
                    dayJson.addProperty("dayOfMonth", date.getDayOfMonth());
                    dayJson.addProperty("weekday", date.getDayOfWeek().toString());
                } catch (Exception ignored) {
                    // Se der ruim na data, ignora e segue
                }

                // Lugares (raw + normalizado)
                String[] places = day.getPlaces();
                JsonArray placesRaw = new JsonArray();
                JsonArray placesNorm = new JsonArray();
                for (String place : places) {
                    placesRaw.add(place);
                    placesNorm.add(normalizePlace(place));
                }
                dayJson.add("places", placesRaw);
                dayJson.add("placesNormalized", placesNorm);

                // Segmentos (from -> to + distância)
                JsonArray segments = new JsonArray();
                int dayDistance = 0;

                for (int j = 0; j < places.length - 1; j++) {
                    String fromRaw = places[j];
                    String toRaw = places[j + 1];

                    int dist = SocialDistance.distance(fromRaw, toRaw);
                    if (dist > 0) {
                        dayDistance += dist;
                    }

                    JsonObject legJson = new JsonObject();
                    legJson.addProperty("fromRaw", fromRaw);
                    legJson.addProperty("toRaw", toRaw);
                    legJson.addProperty("from", normalizePlace(fromRaw));
                    legJson.addProperty("to", normalizePlace(toRaw));
                    legJson.addProperty("distanceMeters", dist);
                    legJson.addProperty("distanceKm", dist > 0 ? dist / 1000.0 : -1.0);

                    segments.add(legJson);
                }

                dayJson.add("segments", segments);
                dayJson.addProperty("distanceMeters", dayDistance);
                dayJson.addProperty("distanceKm", dayDistance / 1000.0);

                daysJson.add(dayJson);
            }

            regJson.add("days", daysJson);
            timeline.add(regJson);
        }

        root.add("timeline", timeline);

        return root;
    }

    private static <K> JsonObject mapToJson(Map<K, Integer> map) {
        JsonObject obj = new JsonObject();
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            obj.addProperty(String.valueOf(entry.getKey()), entry.getValue());
        }
        return obj;
    }

    private static String normalizePlace(String raw) {
        String s = raw;
        if (s.startsWith("-")) {
            s = s.substring(1);
        }
        int idx = s.indexOf(" (");
        if (idx >= 0) {
            s = s.substring(0, idx);
        }
        return s.trim();
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
