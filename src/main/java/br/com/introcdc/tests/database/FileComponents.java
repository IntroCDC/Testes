package br.com.introcdc.tests.database;
/*
 * Written by IntroCDC, Bruno Coêlho at 24/12/2022 - 00:33
 */

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public interface FileComponents {

    /**
     * Create Default Folders and Files
     */
    static void createFoldersAndFiles() {
        new File("api").mkdirs();
        new File("config/template").mkdirs();
        new File("core").mkdirs();
        new File("logs/exceptions").mkdirs();
        new File("logs/proxy").mkdirs();
        new File("maps").mkdirs();
        new File("modules").mkdirs();
        new File("plugins").mkdirs();
        new File("servers").mkdirs();
    }

    /**
     * Copy file
     */
    static void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    /**
     * Copy directory
     */
    static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdirs();
        }
        for (String file : source.list()) {
            copy(new File(source, file), new File(target, file));
        }
    }

    /**
     * Copy file
     */
    static void copyFile(File source, File target) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source)); OutputStream out = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    /**
     * Create ZIP File to Destiny
     */
    static void createZip(Map<String, String> files, File destiny) throws IOException {
        destiny.getParentFile().mkdirs();
        if (!destiny.exists()) {
            destiny.createNewFile();
        }
        int BUFFER = 2048;
        BufferedInputStream origin = null;
        FileOutputStream dest = new FileOutputStream(destiny);
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
        for (String file : files.keySet()) {
            byte[] data = new byte[BUFFER];
            FileInputStream fileInput = new FileInputStream(file);
            origin = new BufferedInputStream(fileInput, BUFFER);
            ZipEntry entry = new ZipEntry(files.get(file));
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

    /**
     * Force delete local file
     */
    static void deleteFile(File file) {
        if (file.exists()) {
            deleteFile(file.toPath());
        }
    }

    static void deleteFile(Path path) {
        StringComponents.checkNull(path, "Path cannot be null");
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

    /**
     * Download file with API Access and Signature
     */
    static boolean downloadFile(String URL, File destiny) throws Exception {
        StringComponents.checkNull(URL, "URL cannot be null");
        StringComponents.checkNull(destiny, "Destiny cannot be null");
        if (!destiny.exists()) {
            destiny.getParentFile().mkdirs();
            destiny.createNewFile();
        }
        URLConnection connection = new URL(URL).openConnection();
        connection.addRequestProperty("User-Agent", "IntroCDC-Kindome");
        if (destiny.exists() && destiny.length() == connection.getContentLengthLong()) {
            return false;
        }
        try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream()); FileOutputStream fout = new FileOutputStream(destiny)) {
            byte[] data = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
            fout.flush();
        }
        return true;
    }

    /**
     * Extract files from Zip File
     */
    static void extractZip(File fsrc, File fdest) throws IOException {
        StringComponents.checkNull(fsrc, "Source cannot be null");
        StringComponents.checkNull(fdest, "Destiny cannot be null");
        int BUFFER = (int) fsrc.length();
        ZipFile zip = new ZipFile(fsrc);
        Enumeration<?> zipFileEntries = zip.entries();
        while (zipFileEntries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            String currentEntry = entry.getName();
            File destFile = new File(fdest, currentEntry);
            File destinationParent = destFile.getParentFile();
            destinationParent.mkdirs();
            if (!entry.isDirectory()) {
                BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
                int currentByte;
                byte[] data = new byte[BUFFER];
                FileOutputStream fos = new FileOutputStream(destFile);
                BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
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

}
