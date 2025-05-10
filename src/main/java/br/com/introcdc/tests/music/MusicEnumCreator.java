package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 15/02/2025 - 00:03
 */

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MusicEnumCreator {

    public static String FOLDER = "IA";

    public static void main(String[] args) throws Exception {
        fullUpdateEnum();
    }

    public static void fullUpdateEnum() {
        updateSubVersions();
        FOLDER = "Mister IA";
        updateSubVersions();
    }

    public static void enumRegister() throws Exception {
        // Caminhos das pastas
        String folderMainPath = "F:/Musicas/" + FOLDER + "/";                   // Pasta principal
        String folderSubversionsPath = "F:/Musicas/" + FOLDER + " Others/";        // Pasta das subvers�es
        String folderAltFavoritePath = "F:/Musicas/" + FOLDER + " Cover/";         // Vers�es alternativas favoritas
        String folderAltOtherPath = "F:/Musicas/" + FOLDER + " Cover Others/";     // Vers�es alternativas "mais ou menos"

        File folderMain = new File(folderMainPath);
        File folderSubversions = new File(folderSubversionsPath);
        File folderAltFavorite = new File(folderAltFavoritePath);
        File folderAltOther = new File(folderAltOtherPath);

        if (!folderMain.exists() || !folderMain.isDirectory()) {
            System.out.println("Pasta principal n�o encontrada: " + folderMainPath);
            return;
        }
        // Se as pastas de alternativas n�o existirem, exibe mensagem (mas continua)
        if (!folderSubversions.exists() || !folderSubversions.isDirectory()) {
            System.out.println("Pasta de subvers�es n�o encontrada: " + folderSubversionsPath);
        }
        if (!folderAltFavorite.exists() || !folderAltFavorite.isDirectory()) {
            System.out.println("Pasta de vers�es alternativas favoritas n�o encontrada: " + folderAltFavoritePath);
        }
        if (!folderAltOther.exists() || !folderAltOther.isDirectory()) {
            System.out.println("Pasta de vers�es alternativas Others n�o encontrada: " + folderAltOtherPath);
        }

        // Formatadores para convers�o da data
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy '�s' H:mm", new Locale("pt", "BR"));
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

        List<String> codeLines = new ArrayList<>();

        // Itera pelos arquivos da pasta principal
        for (File file : folderMain.listFiles()) {
            if (!file.isFile()) continue;
            String fileName = file.getName();

            if (!fileName.toLowerCase().endsWith(".mp3"))
                continue;

            // Exemplo: "IA - NOME DA M�SICA.mp3"
            String nameWithoutExt = fileName.substring(0, fileName.length() - 4);
            String[] parts = nameWithoutExt.split(" - ");
            if (parts.length < 2) {
                System.out.println("Formato inesperado no arquivo: " + fileName);
                continue;
            }
            String musicName = parts[1].trim(); // j� sem "IA - "

            if (isRegistered(musicName)) {
                continue;
            }

            // Flag 'misterIa' definida a partir do caminho da pasta principal
            boolean misterIa = folderMainPath.contains("Mister IA");

            System.out.println("Processando: " + fileName);
            // Copia o nome da m�sica para a clipboard e aguarda a data
            String lastClip = setClipboard(musicName);
            System.out.println("Nome da m�sica \"" + musicName + "\" copiado para a clipboard.");
            System.out.println("Aguarde e copie a data (no formato: \"13 de novembro de 2024 �s 21:49\") para a clipboard...");

            String creationInput;
            while (true) {
                Thread.sleep(100);
                String clip = clipboard();
                if (clip == null || clip.equals(lastClip)) {
                    continue;
                }
                creationInput = clip;
                break;
            }

            creationInput = creationInput.replace("�s", "�s");
            if (creationInput.equalsIgnoreCase("stop")) {
                break;
            }

            String creation;
            LocalDateTime creationDateTime;
            try {
                creationDateTime = LocalDateTime.parse(creationInput, inputFormatter);
                creation = creationDateTime.format(outputFormatter);
            } catch (Exception e) {
                System.out.println("Formato de data inv�lido. Utilize o padr�o: \"d de MMMM de yyyy �s H:mm\" (" + creationInput + ")");
                continue;
            }

            // Determina o �lbum com base na data:
            // 0: at� 31/07/2024, 1: de 01/08/2024 a 18/11/2024, 2: a partir de 19/11/2024
            int album;
            if (creationDateTime.isBefore(LocalDateTime.of(2024, 8, 1, 0, 0))) {
                album = 0;
            } else if (creationDateTime.isBefore(LocalDateTime.of(2024, 11, 19, 0, 0))) {
                album = 1;
            } else {
                album = 2;
            }

            // Busca vers�es alternativas nas 3 pastas
            List<String> alternativeVersionsList = getAlternativeVersionsList(musicName, folderAltFavorite, folderAltOther);
            int subVersions = getSubversionsCount(musicName, folderSubversions);

            // Gera o nome da constante para o enum
            String enumConstant = musicName.toUpperCase().replaceAll("[^A-Z0-9]", "_");

            StringBuilder line = new StringBuilder();
            line.append(enumConstant).append("(\"")
                    .append(musicName).append("\", ")
                    .append(misterIa).append(", \"")
                    .append(creation).append("\", ")
                    .append(album).append(", ")
                    .append(subVersions);
            for (String alt : alternativeVersionsList) {
                line.append(", \"").append(alt).append("\"");
            }
            line.append("),");

            codeLines.add(line.toString());
            System.out.println();
        }

        System.out.println("\nC�digo para registrar no enum:");
        for (String code : codeLines) {
            System.out.println(code);
        }
    }

    /**
     * Busca os arquivos de vers�es alternativas nas 3 pastas:
     * - Pasta de subvers�es (IA Others)
     * - Pasta de vers�es alternativas favoritas (IA Cover)
     * - Pasta de vers�es alternativas Others (IA Cover Others)
     * <p>
     * Retorna a lista de arquivos que iniciem com "IA - " + nome da m�sica.
     */
    public static List<String> getAlternativeVersionsList(String musicName, File folderAltFavorite, File folderAltOther) {
        List<String> alternativeVersionsList = new ArrayList<>();
        String prefix = (FOLDER + " - " + musicName).toLowerCase().trim();

        // Verifica na pasta de vers�es alternativas favoritas
        if (folderAltFavorite != null && folderAltFavorite.exists() && folderAltFavorite.isDirectory()) {
            File[] favFiles = folderAltFavorite.listFiles();
            if (favFiles != null) {
                for (File file : favFiles) {
                    if (!file.isFile()) continue;
                    String fileName = file.getName();
                    if (!fileName.toLowerCase().endsWith(".mp3"))
                        continue;
                    String fileNameNoExt = fileName.substring(0, fileName.length() - 4).toLowerCase().trim();
                    if (fileNameNoExt.startsWith(prefix + " (")) {
                        alternativeVersionsList.add(fileName.split(" - ")[1].replace(".mp3", ""));
                    }
                }
            }
        }

        // Verifica na pasta de vers�es alternativas Others
        if (folderAltOther != null && folderAltOther.exists() && folderAltOther.isDirectory()) {
            File[] otherFiles = folderAltOther.listFiles();
            if (otherFiles != null) {
                for (File file : otherFiles) {
                    if (!file.isFile()) continue;
                    String fileName = file.getName();
                    if (!fileName.toLowerCase().endsWith(".mp3"))
                        continue;
                    String fileNameNoExt = fileName.substring(0, fileName.length() - 4).toLowerCase().trim();
                    if (fileNameNoExt.startsWith(prefix + " (")) {
                        alternativeVersionsList.add(fileName.split(" - ")[1].replace(".mp3", ""));
                    }
                }
            }
        }

        return alternativeVersionsList;
    }

    public static int getSubversionsCount(String musicName, File folderSubversions) {
        int count = 0;
        String prefix = (FOLDER + " - " + musicName).toLowerCase().trim();

        if (folderSubversions != null && folderSubversions.exists() && folderSubversions.isDirectory()) {
            File[] subFiles = folderSubversions.listFiles();
            if (subFiles != null) {
                for (File file : subFiles) {
                    if (!file.isFile()) continue;
                    String fileName = file.getName();
                    if (!fileName.toLowerCase().endsWith(".mp3"))
                        continue;
                    String fileNameNoExt = fileName.substring(0, fileName.length() - 3).toLowerCase().trim();
                    if (fileNameNoExt.startsWith(prefix) && fileNameNoExt.length() <= (prefix.length() + 3) && fileNameNoExt.length() >= prefix.length()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Atualiza (e imprime) a defini��o dos enums registrados com a quantidade correta de subVersions,
     * buscando os arquivos nas 3 pastas: IA Others, IA Cover e IA Cover Others.
     */
    public static void updateSubVersions() {
        String folderSubversionsPath = "F:/Musicas/" + FOLDER + " Others/";
        String folderAltFavoritePath = "F:/Musicas/" + FOLDER + " Cover/";
        String folderAltOtherPath = "F:/Musicas/" + FOLDER + " Cover Others/";

        File folderSubversions = new File(folderSubversionsPath);
        File folderAltFavorite = new File(folderAltFavoritePath);
        File folderAltOther = new File(folderAltOtherPath);

        if (!folderSubversions.exists() || !folderSubversions.isDirectory()) {
            System.out.println("Pasta de subvers�es n�o encontrada: " + folderSubversionsPath);
        }
        if (!folderAltFavorite.exists() || !folderAltFavorite.isDirectory()) {
            System.out.println("Pasta de vers�es alternativas favoritas n�o encontrada: " + folderAltFavoritePath);
        }
        if (!folderAltOther.exists() || !folderAltOther.isDirectory()) {
            System.out.println("Pasta de vers�es alternativas Others n�o encontrada: " + folderAltOtherPath);
        }

        System.out.println("Atualizando os subVersions dos enums registrados:\n");
        for (Music music : Music.values()) {
            if ((FOLDER.equalsIgnoreCase("Mister IA") && !music.isMisterIA()) || (!FOLDER.equalsIgnoreCase("Mister IA") && music.isMisterIA())) {
                continue;
            }

            String musicName = music.getMusicName();
            List<String> alternativeVersionsList = getAlternativeVersionsList(musicName, folderAltFavorite, folderAltOther);
            int newSubVersions = getSubversionsCount(musicName, folderSubversions);


            StringBuilder line = new StringBuilder();
            line.append(music.name()).append("(\"")
                    .append(musicName).append("\", ")
                    .append(music.isMisterIA()).append(", \"")
                    .append(music.getCreation()).append("\", ")
                    .append(music.getAlbum()).append(", ")
                    .append(newSubVersions);
            for (String alt : alternativeVersionsList) {
                line.append(", \"").append(alt).append("\"");
            }
            line.append("),");

            System.out.println(line.toString());
        }
    }

    // Retorna o conte�do da clipboard
    public static String clipboard() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Define o conte�do da clipboard
    public static String setClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return text;
    }

    // Verifica se a m�sica j� est� registrada no enum (compara��o ignorando case)
    public static boolean isRegistered(String musicName) {
        for (Music music : Music.values()) {
            if (music.getMusicName().equalsIgnoreCase(musicName)) {
                return true;
            }
        }
        return false;
    }

}
