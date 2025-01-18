package br.com.introcdc.tests.database;
/*
  Written by IntroCDC, Bruno Coêlho at 28/08/2017 - 14:45
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface StringComponents {

    static String commas(Collection<String> collection) {
        return commas(collection.stream());
    }

    static String commas(Stream<String> stream) {
        return commas(stream, "", "", ", ");
    }

    static String commas(Collection<String> collection, String comma) {
        return commas(collection.stream(), comma);
    }

    static String commas(Stream<String> stream, String comma) {
        return commas(stream, "", "", comma);
    }

    static String commas(Collection<String> collection, String color, String commaColor) {
        return commas(collection.stream(), color, commaColor);
    }

    static String commas(Stream<String> stream, String color, String commaColor) {
        return commas(stream, color, commaColor, ", ");
    }

    static String commas(Stream<String> stream, String color, String commaColor, String comma) {
        return stream.map(s -> color + s).collect(Collectors.joining(commaColor + comma));
    }

    /**
     * Convert numbers to [|||||||||]
     */
    static String barProgress(double max, double use, long size, boolean color) {
        return barProgress(max, use, size, "§a");
    }

    static String barProgress(double max, double use, long size, String color) {
        return barProgress(max, use, size, color, "§8");
    }

    static String barProgress(double max, double use, long size, String color, String offColor) {
        double currentHealth = Math.max(use, 0);
        double healthPercentage = currentHealth / max * 100.0D;
        String spacer = "|";
        String onSpacer = "*";
        String offSpacer = "-";
        double coloredDisplay = Math.ceil(size * (healthPercentage / 100.0D));
        StringBuilder healthbar = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (coloredDisplay > 0) {
                healthbar.append(color != null ? color : "").append(color != null ? spacer : onSpacer);
                coloredDisplay--;
            } else {
                healthbar.append(color != null ? offColor : "").append(color != null ? spacer : offSpacer);
            }
        }
        healthbar = new StringBuilder((color != null ? "§f" : "") + "[" + healthbar + (color != null ? "§f" : "") + "]");
        return healthbar.toString();
    }

    static String plus(String string, String plus, int amount) {
        return string + (amount != 1 ? plus : "");
    }

    static String plusOption(String single, String plus, int amount) {
        return amount == 1 ? single : plus;
    }

    /**
     * Remove all acents from string
     *
     * @param string the string
     * @return the string without acents
     */
    static String removeAcents(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    static long compareStrings(String original, String check) {
        int matches = 0;
        StringBuilder result = new StringBuilder();
        for (int current = 0; current < original.length(); current++) {
            if (check.length() >= (current + 1)) {
                if (removeAcents(original).toLowerCase().toCharArray()[current]
                        == removeAcents(check).toLowerCase().toCharArray()[current]) {
                    matches++;
                }
            }
        }
        return percent(matches, original.length());
    }

    /**
     * Convert String array to collection
     */
    static Collection<? extends String> toCollections(String... args) {
        checkNull(args, "Args Cannot be null");
        return new HashSet(Arrays.asList(args));
    }

    /**
     * Convert String to boolean
     */
    static boolean toBoolean(String value) {
        checkNull(value, "Value Cannot be null");
        if (value.equalsIgnoreCase("habilitar") || value.equalsIgnoreCase("habilitado") ||
                value.equalsIgnoreCase("sim") || value.equalsIgnoreCase("claro") ||
                value.equalsIgnoreCase("ligar") || value.equalsIgnoreCase("abrir") ||
                value.equalsIgnoreCase("open") || value.equalsIgnoreCase("ligado") ||
                value.equalsIgnoreCase("carregar") || value.equalsIgnoreCase("carregado") ||
                value.equalsIgnoreCase("ativar") || value.equalsIgnoreCase("ativado") ||
                value.equalsIgnoreCase("1") || value.equalsIgnoreCase("bloquear") ||
                value.equalsIgnoreCase("bloqueado") || value.equalsIgnoreCase("on") ||
                value.equalsIgnoreCase("start") || value.equalsIgnoreCase("started") ||
                value.equalsIgnoreCase("enabled") || value.equalsIgnoreCase("positivo") ||
                value.equalsIgnoreCase("enable") || value.equalsIgnoreCase("block")) {
            return true;
        }
        return Boolean.parseBoolean(value);
    }

    /**
     * Force to 9 numbers
     */
    static int nineDivisable(int i, int mod) {
        while (i == 0 || i % mod != 0) {
            i++;
        }
        return i;
    }

    /**
     * Create HashMap
     *
     * @param <K> type
     * @param <V> other type
     * @return the hashmap
     */
    static <K, V> HashMap<K, V> hashMap() {
        return new HashMap();
    }

    /**
     * Create new ArrayList
     *
     * @param <E> type
     * @return the arraylist
     */
    static <E> ArrayList<E> arrayList() {
        return new ArrayList();
    }

    static String shortNumber(long number) {
        if (number > 1_000_000_000_000L) {
            return Math.round((double) (number / 1_000_000_000_000L)) + "." + String.valueOf(number % 1_000_000_000_000L).toCharArray()[0] + "T";
        }
        if (number > 1_000_000_000) {
            return Math.round((double) (number / 1_000_000_000)) + "." + String.valueOf(number % 1_000_000_000).toCharArray()[0] + "B";
        }
        if (number > 1_000_000) {
            return Math.round((double) (number / 1_000_000)) + "." + String.valueOf(number % 1_000_000).toCharArray()[0] + "M";
        }
        if (number > 1_000) {
            return Math.round((double) (number / 1_000)) + "." + String.valueOf(number % 1_000).toCharArray()[0] + "K";
        }
        return String.valueOf(number);
    }

    /**
     * Create new ArrayList
     *
     * @param elements the objects to auto add
     * @param <E>type
     * @return the arraylist
     */
    @SafeVarargs
    static <E> ArrayList<E> arrayList(E... elements) {
        checkNull(elements, "Elements Cannot be null");
        int capacity = computeArrayListCapacity(elements.length);
        ArrayList<E> list = new ArrayList(capacity);
        Collections.addAll(list, elements);
        return list;
    }

    static boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static int isIntAndBigger(String value, int min) {
        if (!isInt(value)) {
            return min - 1;
        }
        int val = Integer.parseInt(value);
        return val < min ? min - 1 : val;
    }

    static boolean isLong(String text) {
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static boolean isDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static boolean isByte(String text) {
        try {
            Byte.parseByte(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static boolean isFloat(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static <T extends Enum<T>> boolean hasInEnum(Class<T> enumClass, String value) {
        try {
            Enum.valueOf(enumClass, value);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Convert String[] to List<String>
     */
    static List<String> toList(String[] array) {
        return Arrays.asList(array);
    }

    /**
     * Encrypt String to hashSha512
     */
    static String hashSha512(String passwordToHash) {
        checkNull(passwordToHash, "PasswordHash Cannot be null");
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(String.valueOf(passwordToHash.hashCode()).getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return generatedPassword;
    }

    static String getColor(String tag) {
        tag = tag.replace("&", "§");
        if (tag.startsWith("§") && tag.length() > 1) {
            return String.valueOf(tag.toCharArray()[0] + tag.toCharArray()[1]);
        }
        if (tag.contains("§")) {
            boolean found = false;
            for (int i = 0; i < tag.length(); i++) {
                if (found) {
                    return "§" + tag.toCharArray()[i];
                }
                found = tag.toCharArray()[i] == '§';
            }
        }
        if (tag.length() > 0) {
            return "§" + tag.toCharArray()[0];
        }
        return "§a";
    }

    /**
     * Convert milliseconds to 00/00/0000 - 00:00:00
     */
    static String toDate(long number) {
        return TIME_FORMATTER.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    static long toMillis(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static int getDay(long number) {
        return Integer.parseInt(DAY_ONLY.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime()));
    }

    static int getYear(long number) {
        return Integer.parseInt(YEAR_ONLY.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime()));
    }

    /**
     * Get current date
     */
    static String currentDate() {
        return toDate(System.currentTimeMillis());
    }

    /**
     * Convert milliseconds to 00/00/0000 - 00:00:00
     */
    static String toOtherDate(long number) {
        return OTHER_TIME_FORMATTER.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * Get current date
     */
    static String currentOtherDate() {
        return toOtherDate(System.currentTimeMillis());
    }

    static String resetColors(String message) {
        for (String color : new String[]{"a", "b", "c", "d", "e", "f", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}) {
            message = message.replace("§" + color, "").replace("§" + color.toUpperCase(), "");
        }
        return message;
    }

    /**
     * Convert String and Type to milliseconds
     */
    static long milliSeconds(long time, String type) {
        checkNull(type, "Type cannot be null");
        time = time * 1000;
        if (type.equalsIgnoreCase("s") || type.toLowerCase().contains("segundo") || type.toLowerCase().contains("second")) {
            return time;
        }
        time *= 60;
        if (type.equalsIgnoreCase("m") || type.toLowerCase().contains("minuto") || type.toLowerCase().contains("minute")) {
            return time;
        }
        time *= 60;
        if (type.equalsIgnoreCase("h") || type.toLowerCase().contains("hora") || type.toLowerCase().contains("hour")) {
            return time;
        }
        time *= 24;
        if (type.equalsIgnoreCase("d") || type.toLowerCase().contains("dia") || type.toLowerCase().contains("day")) {
            return time;
        } else if (type.toLowerCase().contains("semana") || type.toLowerCase().contains("week")) {
            time *= 7;
            return time;
        }
        time *= 31;
        if (type.toLowerCase().contains("mes") || type.toLowerCase().contains("mês") || type.toLowerCase().contains("month")) {
            return time;
        }
        time *= 12;
        if (type.equalsIgnoreCase("a") || type.equalsIgnoreCase("y") || type.toLowerCase().contains("ano") || type.toLowerCase().contains("year")) {
            return time;
        } else {
            return -1;
        }
    }

    /**
     * Convert numbers to 0%
     */
    static int percent(long current, long max) {
        return max <= 0 ? 0 : (int) current * 100 / (int) max;
    }

    static double percentDouble(long current, long max) {
        return max <= 0 ? 0 : current * 100 / max;
    }

    /**
     * Place zero to Number and convert to String
     */
    static String placeZero(long number) {
        return number >= 10 ? Long.toString(number) : String.format("0%s", number);
    }

    /**
     * Convert seconds to short time
     */
    static String shortTime(long totalTime) {
        long years = totalTime / 32140800;
        long months = totalTime % 32140800 / 2678400;
        long days = totalTime % 2678400 / 86400;
        long hours = totalTime % 86400 / 3600;
        long minutes = totalTime % 3600 / 60;
        long seconds = totalTime % 60;
        if (totalTime > 0) {
            return (years > 0 ? placeZero(years) + "A " : "") +
                    (months > 0 ? placeZero(months) + "M " : "") +
                    (days > 0 ? placeZero(days) + "d " : "") +
                    (hours > 0 ? placeZero(hours) + "h " : "") +
                    (minutes > 0 ? placeZero(minutes) + "m " : "") +
                    (seconds > 0 ? placeZero(seconds) + "s " : "");
        }
        return "0s";
    }

    /**
     * Convert seconds to complete time
     */
    static String completeTime(long totalTime) {
        long years = totalTime / 32140800;
        long months = totalTime % 32140800 / 2678400;
        long days = totalTime % 2678400 / 86400;
        long hours = totalTime % 86400 / 3600;
        long minutes = totalTime % 3600 / 60;
        long seconds = totalTime % 60;
        if (totalTime > 0) {
            String result = "";
            if (years > 0) {
                result += years + " ano" + (years == 1 ? "" : "s");
                if (months > 0 || days > 0 || hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (months > 0) {
                result += months + " " + (months == 1 ? "mês" : "meses");
                if (days > 0 || hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (days > 0) {
                result += days + " dia" + (days == 1 ? "" : "s");
                if (hours > 0 || minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (hours > 0) {
                result += hours + " hora" + (hours == 1 ? "" : "s");
                if (minutes > 0) {
                    result += ", ";
                } else if (seconds > 0) {
                    result += " e ";
                }
            }
            if (minutes > 0) {
                result += minutes + " minuto" + (minutes == 1 ? "" : "s");
                if (seconds > 0) {
                    result += " e ";
                }
            }
            if (seconds > 0) {
                result += seconds + " segundo" + (seconds == 1 ? "" : "s");
            }
            return result;
        }
        return "0 segundos";
    }

    static String bars(int current, int max) {
        return bars(percent(current, max));
    }

    static String bars(long progress) {
        if (progress == 0) {
            return "§a§l///";
        } else if (progress > 0 && progress < 10) {
            return "§e§l/§a§l//";
        } else if (progress >= 10 && progress < 20) {
            return "§e§l//§a§l/";
        } else if (progress >= 20 && progress < 30) {
            return "§e§l///";
        } else if (progress >= 30 && progress < 35) {
            return "§6§l/§e§l//";
        } else if (progress >= 35 && progress < 40) {
            return "§6§l//§e§l/";
        } else if (progress >= 50 && progress < 60) {
            return "§6§l///";
        } else if (progress >= 60 && progress < 65) {
            return "§c§l/§6§l//";
        } else if (progress >= 65 && progress < 70) {
            return "§c§l//§6§l/";
        } else if (progress >= 70 && progress < 80) {
            return "§c§l///";
        } else if (progress >= 80 && progress < 90) {
            return "§4§l/§c§l//";
        } else if (progress >= 90 && progress < 100) {
            return "§4§l//§c§l/";
        }
        return "§4§l///";
    }

    static JsonElement readJson(String url) throws IOException {
        StringComponents.checkNull(url, "URL cannot be null");
        URLConnection connection = new URL(url).openConnection();
        connection.addRequestProperty("User-Agent", "IntroCDC-Kindome");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return new JsonParser().parse(reader);
    }

    /**
     * Check if object is null
     */
    static <T> T checkNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        } else {
            return reference;
        }
    }

    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static int computeArrayListCapacity(int arraySize) {
        checkNonnegative(arraySize, "arraySize");
        return saturatedCast(5L + (long) arraySize + (long) (arraySize / 10));
    }

    static int saturatedCast(long value) {
        if (value > 2147483647L) {
            return 2147483647;
        } else {
            return value < -2147483648L ? -2147483648 : (int) value;
        }
    }

    static int checkNonnegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
        } else {
            return value;
        }
    }

    static String limit(String str, int limit) {
        return str.length() > limit ? str.substring(0, limit) : str;
    }

    Random RANDOM = new Random();

    /**
     * Random Selectors
     */
    static <T> T random(T[] arrayOfT) {
        return arrayOfT[RANDOM.nextInt(arrayOfT.length)];
    }

    static <T> T random(Set<T> setOfT) {
        return (T) random(setOfT.toArray());
    }

    static <T> T random(List<T> listOfT) {
        return (T) random(listOfT.toArray());
    }

    static <T> T random(Collection<T> collectionOfT) {
        return (T) random(collectionOfT.toArray());
    }

    static int randomInt(int max) {
        return RANDOM.nextInt(max) + 1;
    }

    /**
     * Convert to Pages
     */
    static <T> T convertToPages(List<T> list, int page, int perPage) {
        List<T> returnResult = arrayList();

        for (int i = ((page * perPage) - perPage); i < (page * perPage); i++) {
            if (i >= list.size()) {
                continue;
            }
            returnResult.add(list.get(i));
        }

        return (T) returnResult;
    }

    static <T> T convertToPages(T[] list, int page, int perPage) {
        return convertToPages(Arrays.asList(list), page, perPage);
    }

    DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral('/').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('/')
            .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral(" - ")
            .appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2)
            .appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
    DateTimeFormatter DAY_ONLY = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    DateTimeFormatter YEAR_ONLY = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    DateTimeFormatter OTHER_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('/')
            .appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('/').appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral(" - ").appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':')
            .appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();

}
