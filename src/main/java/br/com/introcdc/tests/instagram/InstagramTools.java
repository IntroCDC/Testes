package br.com.introcdc.tests.instagram;
/*
 * Written by IntroCDC, Bruno Coêlho at 09/03/2024 - 06:30
 */

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

public class InstagramTools {

    // Username Config
    public static String USERNAME = "brunocoelho.png";
    // Verify History
    public static boolean FULL_HISTORY = false;
    // Mutual Settings
    public static boolean MUTUAL = false;
    public static boolean DONT_FOLLOW_BACK = true;
    // Ignore Verified
    public static boolean VERIFIED = false;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            verifyHistory();
        } else {
            USERNAME = args[1];
            if (args[0].equalsIgnoreCase("info")) {
                showBasicInfo();
            } else if (args[0].equalsIgnoreCase("history")) {
                verifyHistory();
            } else if (args[0].equalsIgnoreCase("mutual-in")) {
                MUTUAL = true;
                checkMutual();
            } else if (args[0].equalsIgnoreCase("mutual-out")) {
                MUTUAL = true;
                DONT_FOLLOW_BACK = false;
                checkMutual();
            } else if (args[0].equalsIgnoreCase("not-mutual-in")) {
                checkMutual();
            } else if (args[0].equalsIgnoreCase("not-mutual-out")) {
                DONT_FOLLOW_BACK = false;
                checkMutual();
            } else {
                System.out.println("info/history/mutual-in/mutual-out/not-mutual-in/not-mutual-out USER");
            }
        }
    }

    // Main Methods
    public static void showBasicInfo() throws Exception {
        System.out.println("INFO: #" + catchLastId(true));
        for (boolean followers : new Boolean[]{true, false}) {
            System.out.println(getIdString(followers).toUpperCase() + ": " + listUsers(followers, catchLastId(followers)).size());
        }
    }

    public static void checkMutual() throws Exception {
        Map<Long, UserInfo> followingList = new HashMap<>();
        Map<Long, UserInfo> followersList = new HashMap<>();

        for (UserInfo userInfo : listUsers(false, catchLastId(false))) {
            followingList.put(userInfo.getId(), userInfo);
        }

        for (UserInfo userInfo : listUsers(true, catchLastId(true))) {
            followersList.put(userInfo.getId(), userInfo);
        }

        List<UserInfo> resultList = new ArrayList<>();
        for (long id : DONT_FOLLOW_BACK ? followingList.keySet() : followersList.keySet()) {
            if (DONT_FOLLOW_BACK) {
                if ((MUTUAL && followersList.containsKey(id)) || (!MUTUAL && !followersList.containsKey(id))) {
                    resultList.add(followingList.get(id));
                }
            } else {
                if ((MUTUAL && followingList.containsKey(id)) || (!MUTUAL && !followingList.containsKey(id))) {
                    UserInfo userInfo = followersList.get(id);
                    resultList.add(userInfo);
                }
            }
        }

        System.out.println("SEGUINDO: " + followingList.size() + " / SEGUIDORES: " + followersList.size());
        System.out.println((MUTUAL ? "" : "NÃO ") + (DONT_FOLLOW_BACK ? "SEGUEM DE VOLTA: " : "SIGO DE VOLTA: ") + resultList.size() + " contas");
        for (UserInfo userInfo : resultList) {
            System.out.println(" - " + userInfo.toString());
        }
    }

    public static void checkBoolean(boolean followers) throws Exception {
        System.out.println(getIdString(followers).toUpperCase() + ":");
        List<UserInfo> resultList = new ArrayList<>();

        int totalAccounts = 0;
        for (UserInfo userInfo : listUsers(followers, catchLastId(followers))) {
            totalAccounts++;
            if (VERIFIED) {
                if (userInfo.isVerified()) {
                    resultList.add(userInfo);
                }
            } else {
                if (userInfo.isFollowedByMe()) {
                    resultList.add(userInfo);
                }
            }
        }

        System.out.println("Contas: " + totalAccounts);
        System.out.println((VERIFIED ? "CONTAS VERIFICADAS: " : "CONTAS QUE EU SIGO TAMBÉM: ") + resultList.size() + " contas");
        for (UserInfo userInfo : resultList) {
            System.out.println(" - " + userInfo.toString());
        }
    }

    public static void clearLastCache() throws Exception {
        for (boolean followers : new Boolean[]{true, false}) {
            deleteFile(new File(getDatabase() + getIdString(followers) + "_" + catchLastId(followers) + ".csv"));
        }
    }

    public static void likesReader() throws Exception {
        Scanner scanner = new Scanner(new File(getDatabase() + "likes.csv"));

        List<UserInfo> following = listUsers(false, catchLastId(false));
        List<UserInfo> followers = listUsers(true, catchLastId(true));

        Map<String, Integer> mostLiked = new HashMap<>();
        Map<String, Integer> mostLiker = new HashMap<>();
        String lastPost = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("POST: ")) {
                lastPost = line.replace("POST: ", "");
                continue;
            }
            mostLiked.put(lastPost, mostLiked.getOrDefault(lastPost, 0) + 1);
            UserInfo userInfo = new UserInfo(convert(line));
            mostLiker.put(userInfo.getUsername(), mostLiker.getOrDefault(userInfo.getUsername(), 0) + 1);
        }

        System.out.println("PUBLICAÇÕES MAIS GOSTADAS:");
        List<String> ignore = new ArrayList<>();
        for (; ; ) {
            int most = -1;
            String keyMost = "";
            for (String key : mostLiked.keySet()) {
                if (ignore.contains(key)) {
                    continue;
                }
                if (mostLiked.get(key) > most) {
                    keyMost = key;
                    most = mostLiked.get(key);
                }
            }
            if (keyMost.isEmpty()) {
                break;
            }

            ignore.add(keyMost);
            System.out.println("https://www.instagram.com/p/" + keyMost + ": " + most);
        }

        System.out.println();
        System.out.println("PERFIS QUE MAIS GOSTAM:");
        ignore.clear();
        for (; ; ) {
            int most = -1;
            String keyMost = "";
            for (String key : mostLiker.keySet()) {
                if (ignore.contains(key)) {
                    continue;
                }
                if (mostLiker.get(key) > most) {
                    keyMost = key;
                    most = mostLiker.get(key);
                }
            }
            if (keyMost.isEmpty()) {
                break;
            }

            ignore.add(keyMost);
            System.out.println("https://www.instagram.com/" + keyMost + ": " + most + " " +
                    (isInList(followers, keyMost) ? "<" : "") + (isInList(following, keyMost) ? ">" : ""));
        }
    }

    public static void likesExporter() throws Exception {
        Robot robot = new Robot();
        List<UserInfo> resultList = new ArrayList<>();
        List<Long> idList = new ArrayList<>();
        for (boolean followers : new Boolean[]{true, false}) {
            for (UserInfo userInfo : listUsers(followers, catchLastId(followers))) {
                if (idList.contains(userInfo.getId())) {
                    continue;
                }
                idList.add(userInfo.getId());
                resultList.add(userInfo);
            }
        }
        System.out.println("INFORMAÇÕES CARREGADAS, EXECUTANDO...");

        Map<String, List<UserInfo>> result = new HashMap<>();
        String key = "NULL";
        int lastSize = -1;

        while (true) {
            Thread.sleep(50);
            String clipboard = getClipboardText();
            if (clipboard.isEmpty()) {
                continue;
            }

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            Thread.sleep(10);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            if (clipboard.equalsIgnoreCase("STOP")) {
                PrintWriter writer = new PrintWriter("C:/Users/Bruno/Desktop/teste.txt");

                System.out.println("RESULT:");
                for (String keyString : result.keySet()) {
                    writer.println("POST: " + keyString);
                    for (UserInfo userInfo : result.get(keyString)) {
                        writer.println(userInfo.toOriginalString());
                    }
                    writer.println();
                }

                writer.flush();
                writer.close();
                return;
            }
            if (clipboard.length() == 68 && clipboard.contains("instagram.com")) {
                key = clipboard.substring(28, 67);
                if (!result.containsKey(key)) {
                    result.put(key, new ArrayList<>());
                }
            }
            if (key.length() != 39) {
                continue;
            }

            for (String line : clipboard.split("\n")) {
                if (!line.contains("Foto do perfil de ")) {
                    continue;
                }
                UserInfo userInfo = grabInfo(resultList, line.replace("Foto do perfil de ", ""));
                if (!isInList(result.get(key), userInfo.getUsername())) {
                    result.get(key).add(userInfo);
                }
            }

            if (result.get(key).size() != lastSize) {
                lastSize = result.get(key).size();
                System.out.println("Processando: " + key + ": " + result.get(key).size());
            }
        }
    }

    // Get List
    public static List<UserInfo> listUsers(boolean followers, int id) throws Exception {
        return listUsers(new File(getDatabase() + getIdString(followers) + "_" + id + ".csv"));
    }

    public static List<UserInfo> listUsers(File file) throws Exception {
        Scanner scanner = new Scanner(file);

        List<UserInfo> resultList = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] lineInfo = convert(scanner.nextLine());
            if (lineInfo[0].contains("User")) {
                continue;
            }
            UserInfo userInfo = new UserInfo(lineInfo);
            if (!VERIFIED && userInfo.isVerified()) {
                continue;
            }

            resultList.add(userInfo);
        }
        return resultList;
    }

    public static String[] convert(String info) {
        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        Pattern pattern = Pattern.compile(regex);
        return pattern.split(info);
    }

    // String
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    public static String getDatabase() {
        return "C:\\Users\\" + getUserName() + "\\AppData\\Roaming\\Instagram\\" + USERNAME + "\\";
    }

    public static String getIdString(boolean followers) {
        return followers ? "followers" : "following";
    }

    public static void verifyHistory() throws Exception {
        for (boolean followers : new Boolean[]{true, false}) {
            move(followers);
            System.out.println(getIdString(followers).toUpperCase() + ":");
            int lastId = catchLastId(followers);
            for (int id = FULL_HISTORY ? 2 : lastId; id <= catchLastId(followers); id++) {
                System.out.println("===========================");
                check(followers, id);
            }
        }
    }

    // File Methods
    public static void move(boolean followers) {
        String idString = getIdString(followers);
        String oldFile = "C:\\Users\\" + getUserName() + "\\Downloads\\" + idString + ".csv";
        File toMove = new File(oldFile);
        if (!toMove.exists()) {
            return;
        }
        int lastId = catchLastId(followers) + 1;
        String newFile = getDatabase() + idString + "_" + lastId + ".csv";
        File file = new File(newFile);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        toMove.renameTo(file);
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            deleteFile(file.toPath());
        }
    }

    public static void deleteFile(Path path) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {

                private FileVisitResult handleException(IOException exception) {
                    return FileVisitResult.TERMINATE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exception) throws IOException {
                    if (exception != null) {
                        return handleException(exception);
                    }
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exception) {
                    return handleException(exception);
                }
            });
        } catch (Exception ignored) {
        }
    }

    // Main Sub Methods
    public static int catchLastId(boolean followers) {
        String idString = getIdString(followers);
        for (int i = 1; i > 0; i++) {
            if (!(new File(getDatabase() + idString + "_" + i + ".csv").exists())) {
                return (i - 1);
            }
        }
        return 0;
    }

    public static UserInfo grabInfo(List<UserInfo> userList, String username) {
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equalsIgnoreCase(username)) {
                return userInfo;
            }
        }
        return new UserInfo(new String[]{"0", username, username, "NO", "NO", "https://www.instagram.com/" + username});
    }

    public static boolean isInList(List<UserInfo> userList, String username) {
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static String getClipboardText() {
        String result = "";
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception ignored) {
        }
        return result;
    }

    public static void check(boolean followers, int lastId) throws Exception {
        String idString = getIdString(followers);
        File fileOne = new File(getDatabase() + idString + "_" + (lastId - 1) + ".csv");
        File fileTwo = new File(getDatabase() + idString + "_" + lastId + ".csv");
        System.out.println(idString.toUpperCase() + " - #" + (lastId - 1) + " -> #" + lastId);
        System.out.println("Modificação: " + toDate(fileOne.lastModified()) + " -> " + toDate(fileTwo.lastModified()));

        Map<Long, UserInfo> firstList = new HashMap<>();
        Map<Long, UserInfo> secondList = new HashMap<>();

        Map<Long, UserInfo> newUsernames = new HashMap<>();
        Map<Long, UserInfo> removedUsernames = new HashMap<>();

        if (lastId > 1) {
            for (UserInfo userInfo : listUsers(followers, (lastId - 1))) {
                firstList.put(userInfo.getId(), userInfo);
            }
        }

        for (UserInfo userInfo : listUsers(followers, lastId)) {
            long id = userInfo.getId();
            secondList.put(id, userInfo);

            if (!firstList.containsKey(id)) {
                newUsernames.put(id, userInfo);
            }
        }

        for (long id : firstList.keySet()) {
            if (!secondList.containsKey(id)) {
                UserInfo userInfo = firstList.get(id);
                removedUsernames.put(id, userInfo);
            }
        }

        int difference = secondList.size() - firstList.size();
        System.out.println("Diferença: " + firstList.size() + " -> " + secondList.size() + " (" + (difference > 0 ? "+" : "") + difference + ")");
        System.out.println("NOVOS: ");
        for (long id : newUsernames.keySet()) {
            System.out.println(" - " + newUsernames.get(id).toString());
        }
        System.out.println("Removidos: ");
        for (long id : removedUsernames.keySet()) {
            System.out.println(" - " + removedUsernames.get(id).toString());
        }
    }

    // Date
    static String toDate(long number) {
        return TIME_FORMATTER.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    static DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral('/').appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('/')
            .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral(" - ")
            .appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2)
            .appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();

    // Sub Classes
    public static class UserInfo {

        private final long id;
        private final String username;
        private final String displayName;
        private final boolean followedByMe;
        private final boolean isVerified;
        private final String profileUrl;

        public UserInfo(String[] info) {
            this.id = Long.parseLong(info[0]);
            this.username = info[1];
            this.displayName = info[2];
            this.followedByMe = info[3].equalsIgnoreCase("YES");
            this.isVerified = info[4].equalsIgnoreCase("YES");
            this.profileUrl = info[5];
        }

        public long getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getDisplayName() {
            return displayName;
        }

        public boolean isFollowedByMe() {
            return followedByMe;
        }

        public boolean isVerified() {
            return isVerified;
        }

        public String getProfileUrl() {
            return profileUrl;
        }

        public boolean isValidProfile() {
            return getId() != 0L;
        }

        public String toOriginalString() {
            return getId() + "," +
                    getUsername() + "," +
                    getDisplayName() + "," +
                    (isFollowedByMe() ? "YES" : "NO") + "," +
                    (isVerified() ? "YES" : "NO") + "," +
                    getProfileUrl();
        }

        @Override
        public String toString() {
            return username + " / " +
                    (displayName.isEmpty() ? "" : displayName + " / ") +
                    (followedByMe ? "SEGUIDO POR VOCÊ! / " : "") +
                    (isVerified ? "PERFIL VERIFICADO! / " : "") +
                    profileUrl;
        }

    }

}
