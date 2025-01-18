package br.com.introcdc.tests.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ProjectReader {

    public static long classes = 0;

    public static Socket clientServer;

    public static int clientTimes = 0;

    public static long comments = 0;

    public static long files = 0;

    public static long folders = 0;

    public static long lines = 0;

    public static long linesCodes = 0;

    public static HashMap<String, ArrayList<Integer>> linesContains = new HashMap<>();

    public static final Random random = new Random();

    private static String redisIp = "127.0.0.1";

    private static int redisPort = 6379;

    public static boolean replace = false;
    public static String replaceTo = "";
    public static String search = "Mapas";

    public static ServerSocket server;
    public static ServerSocket serverSocket;

    public static int serverTimes = 0;

    public static long size = 0;

    public static Socket socket;
    public static final Timer timer = new Timer();

    public static long whiteLines = 0;

    public static void checkKindome() throws Exception {
        printLines("KindomeCore", true);
        System.exit(0);
    }

    public static void continueReading(final File file) throws Exception {
        folders++;
        for (final File otherFile : file.listFiles()) {
            if (otherFile.isDirectory()) {
                continueReading(otherFile);
            } else {
                read(otherFile);
            }
        }
    }

    // TODO Convert To Date
    public static String convertToDate(final long number) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(number);
        return twoDigitString(calendar.get(Calendar.DAY_OF_MONTH)) + "/" + twoDigitString(calendar.get(Calendar.MONTH) + 1) + "/" + twoDigitString(calendar.get(Calendar.YEAR)) + " | " + twoDigitString(calendar.get(Calendar.HOUR_OF_DAY) + 1) + ":" + twoDigitString(calendar.get(Calendar.MINUTE)) + ":" + twoDigitString(calendar.get(Calendar.SECOND));
    }

    public static void copy(final File sourceLocation, final File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    private static void copyDirectory(final File source, final File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (final String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    private static void copyFile(final File source, final File target) throws IOException {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {
            final byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    public static void createZipFile(final HashMap<String, String> files, final File destiny) throws IOException {
        final int BUFFER = 2048;
        BufferedInputStream origin = null;
        final FileOutputStream dest = new FileOutputStream(destiny);
        final ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
        for (final String file : files.keySet()) {
            final byte data[] = new byte[BUFFER];
            final FileInputStream fileInput = new FileInputStream(file);
            origin = new BufferedInputStream(fileInput, BUFFER);
            final ZipEntry entry = new ZipEntry(files.get(file));
            out.putNextEntry(entry);
            int count;
            while ((count = origin.read(data, 0, BUFFER)) != -1) {
                out.write(data, 0, count);
                out.flush();
            }
        }
        origin.close();
        out.flush();
        out.close();
    }

    public static void deleteFileOrFolder(final Path path) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                private FileVisitResult handleException(final IOException e) {
                    e.printStackTrace();
                    return FileVisitResult.TERMINATE;
                }

                @Override
                public FileVisitResult postVisitDirectory(final Path dir, final IOException e) throws IOException {
                    if (e != null) {
                        return this.handleException(e);
                    }
                    try {
                        Files.delete(dir);
                    } catch (final Exception ee) {
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                    try {
                        Files.delete(file);
                    } catch (final Exception e) {
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(final Path file, final IOException e) {
                    return this.handleException(e);
                }
            });
        } catch (final Exception e) {
        }
    }

    // TODO ZIP File
    public static void extractZipFile(final File fsrc, final File fdest) throws ZipException, IOException {
        final int BUFFER = (int) fsrc.length();
        final ZipFile zip = new ZipFile(fsrc);
        final Enumeration<?> zipFileEntries = zip.entries();
        while (zipFileEntries.hasMoreElements()) {
            final ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            final String currentEntry = entry.getName();
            final File destFile = new File(fdest, currentEntry);
            final File destinationParent = destFile.getParentFile();
            destinationParent.mkdirs();
            if (!entry.isDirectory()) {
                final BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
                int currentByte;
                final byte data[] = new byte[BUFFER];
                final FileOutputStream fos = new FileOutputStream(destFile);
                final BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
                while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, currentByte);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        }
        zip.close();
    }

    // TODO Convert to Time
    public static String getDurationString(int seconds) {
        final int days = seconds / 86400;
        final int hours = seconds % 86400 / 3600;
        final int minutes = seconds % 3600 / 60;
        seconds = seconds % 60;
        return twoDigitString(days) + " : " + twoDigitString(hours) + " : " + twoDigitString(minutes) + " : " + twoDigitString(seconds);
    }

    public static long getFileCreate(File f) {
        Path p = Paths.get(f.getAbsoluteFile().toURI());
        BasicFileAttributes view = null;
        try {
            view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileTime creationTime = view.creationTime();
        return creationTime.toMillis();
    }

    public static int getFileSize(final URL url) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            return conn.getContentLength();
        } catch (final IOException e) {
            return -1;
        } finally {
            conn.disconnect();
        }
    }

    // TODO HashSha512
    public static String hashSha512(final String passwordToHash, final String salt) {
        String generatedPassword = null;
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            final byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            final StringBuilder sb = new StringBuilder();
            for (final byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    // TODO Haspaid
    public static boolean isOriginalNick(final String name) throws Exception {
        final Scanner scanner = new Scanner(new URL("http://www.kindome.com.br/haspaid.php?name=" + name).openStream());
        if (scanner.hasNext()) {
            if (scanner.nextLine().equalsIgnoreCase("true")) {
                scanner.close();
                return true;
            }
            scanner.close();
            return false;
        } else {
            scanner.close();
            return false;
        }
    }

    public static void loadProcess() throws Exception {
        serverSocket = new ServerSocket(32132);
        System.out.println("Reeady!");
        final Socket socket = serverSocket.accept();
        System.out.println("Socket connection");
        final DataInputStream input = new DataInputStream(socket.getInputStream());
        byte Byte = 0;
        final FileOutputStream file = new FileOutputStream(new File("HAHA.jar"));
        System.out.println("Receiving");
        try {
            while ((Byte = input.readByte()) < 41871824) {
                file.write(Byte);
            }
        } catch (final Exception e) {
        }
        System.out.println("Received!");
        file.flush();
        file.close();
        System.out.println("Close!");
        System.exit(0);
    }

    public static void loop() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                loop();
            }
        }, 1000);
    }

    public static void loopServer() throws Exception {
        if (server != null && clientServer != null) {
            if (clientTimes > 30) {
                try {
                    clientServer.close();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                clientTimes++;
            }
            if (serverTimes > 60) {
                try {
                    server.close();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                serverTimes++;
            }
            System.out.println(serverTimes + " - " + clientTimes);
            System.out.println("SC:" + server.isClosed() + " - CCl:" + clientServer.isClosed() + " - CCo:" + clientServer.isConnected() + " - LCl:" + socket.isClosed() + " - LCo:" + socket.isConnected());
            try {
                System.out.println("CSBs:" + clientServer.getSendBufferSize() + " - CRBs:" + clientServer.getReceiveBufferSize() + " - CTO:" + clientServer.getSoTimeout() + " - CTF:" + clientServer.getTrafficClass());
            } catch (final Exception e) {
            }
        } else {
            System.out.println("Null");
        }
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    loopServer();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    public static void main(final String[] args) throws Exception {
        System.out.println("End!");
    }

    public static void printLines(final String project, final boolean maven) throws Exception {
        final String base = "F:/CDC/Workspace/" + project + "/src/" + (maven ? "main/java/" : "");
        System.out.println(project + " - " + maven + " - " + base);
        if (!new File(base).exists()) {
            System.out.println("Arquivo base " + base + " não encontrado...");
            return;
        }
        for (final File file : new File(base).listFiles()) {
            if (file.isDirectory()) {
                continueReading(file);
            } else {
                read(file);
            }
        }
        System.out.println("Pronto! Total: " + classes + " Classes / " + lines + " linhas");
        System.out.println("Linhas de Código: " + linesCodes);
        System.out.println("Comentários: " + comments);
        System.out.println("Linhas Brancas: " + whiteLines);
        System.out.println("Tamanho em bytes: " + size);
        System.out.println("Pastas: " + folders);
        System.out.println("Arquivos: " + files);
        System.out.println("Achou: ");
        long lines = 0;
        for (final String file : linesContains.keySet()) {
            System.out.println(file + " / " + file.split(",").length);
            for (final int line : linesContains.get(file)) {
                String path = "";
                for (int i = 0; i < file.split(",").length; i++) {
                    path += (path.equalsIgnoreCase("") ? "" : ".") + file.split(",")[i];
                }
                System.out.println("at " + path.replace(".java", ".*") + "(" + file.split(",")[file.split(",").length - 1] + ":" + line + ")");
                lines++;
            }
        }
        System.out.println("Linhas: " + lines);
    }

    public static String randomString(final int size) {
        final char[] chars = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890".toCharArray();
        String total = "";
        for (int i = 0; i < size; i++) {
            total = total + chars[new Random().nextInt(chars.length)];
        }
        return total;
    }

    public static int read(final File file) throws Exception {
        int size = 0;
        files++;
        classes++;
        size += file.length();
        final Scanner scanner = new Scanner(file);
        int currentLine = 0;
        List<String> linesPrint = new ArrayList<>();
        boolean found = false;
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            lines++;
            size++;
            currentLine++;
            if (replace && line.contains(search)) {
                found = true;
                linesPrint.add(line.replace(search, replaceTo));
            } else {
                linesPrint.add(line);
            }
            if (line.contains(" // ")) {
                comments++;
            } else if (line.equalsIgnoreCase("")) {
                whiteLines++;
            } else {
                linesCodes++;
            }
            String Package = "";
            File parent = file;
            while (!parent.getName().equalsIgnoreCase("br")) {
                Package = parent.getName() + (Package.equalsIgnoreCase("") ? "" : "," + Package);
                parent = parent.getParentFile();
            }
            Package = "br," + Package;
            if (line.toLowerCase().contains(search.toLowerCase()) && !line.contains("package") && !line.contains("import")) {
                if (!linesContains.containsKey(Package)) {
                    linesContains.put(Package, new ArrayList<Integer>());
                }
                linesContains.get(Package).add(currentLine);
            }
            System.out.println(file.getName() + ": (" + size + "/" + lines + ") - " + line);
        }
        if (replace && found) {
            PrintWriter printWriter = new PrintWriter(file);
            for (String linee : linesPrint) {
                printWriter.println(linee);
            }
            printWriter.flush();
            printWriter.close();
        }
        System.out.println(file.getName() + ": " + size);
        scanner.close();
        return size;
    }

    public static void sendSocketMessage() throws Exception {
        System.out.println("Enviando...");
        final Socket socket = new Socket("staircasemc.com.br", 14124);
        final PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("DestroyEverything");
        writer.flush();
        writer.close();
        socket.close();
        System.out.println("Enviado!");
        System.exit(0);
    }

    public static void server() throws Exception {
        if (server != null) {
            while (!server.isClosed()) {
                clientServer = server.accept();
            }
        }
    }

    // TODO Substring
    public static String substring(final String name) {
        return name.substring(1, name.length());
    }

    // TODO PlaceZero
    public static String twoDigitString(final int number) {
        if (number == 0) {
            return "00";
        }
        if (number / 10 == 0) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

}
