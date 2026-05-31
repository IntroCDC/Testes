package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 24/10/2024 - 13:26
 */

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.Locale;

public class ImageConverter {

    private static final String DEFAULT_FOLDER = "C:/Users/Bruno/Downloads";

    private static final String FROM_FORMAT = "png";
    private static final String TO_FORMAT = "jpg";

    private static final boolean DELETE_ORIGINAL_AFTER_SUCCESS = true;

    private static final float JPG_QUALITY = 0.92f;

    public static void main(String[] args) {
        File folder = new File(args.length == 0 ? DEFAULT_FOLDER : args[0]);

        if (!folder.exists()) {
            System.out.println("A pasta não existe: " + folder.getAbsolutePath());
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("O caminho não é uma pasta: " + folder.getAbsolutePath());
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Não foi possível listar os arquivos da pasta: " + folder.getAbsolutePath());
            return;
        }

        int converted = 0;
        int ignored = 0;
        int failed = 0;

        for (File file : files) {
            if (!file.isFile()) {
                ignored++;
                continue;
            }

            ConvertResult result = convertImage(file, FROM_FORMAT, TO_FORMAT);

            switch (result) {
                case CONVERTED -> converted++;
                case IGNORED -> ignored++;
                case FAILED -> failed++;
            }
        }

        System.out.println();
        System.out.println("========== RESULTADO ==========");
        System.out.println("Convertidos: " + converted);
        System.out.println("Ignorados: " + ignored);
        System.out.println("Falharam: " + failed);
        System.out.println("===============================");
    }

    public static ConvertResult convertImage(File inputFile, String fromFormat, String toFormat) {
        String fileName = inputFile.getName();

        String lowerName = fileName.toLowerCase(Locale.ROOT);
        String fromExtension = "." + fromFormat.toLowerCase(Locale.ROOT);
        String toExtension = "." + toFormat.toLowerCase(Locale.ROOT);

        if (!lowerName.endsWith(fromExtension)) {
            return ConvertResult.IGNORED;
        }

        File outputFile = createOutputFile(inputFile, fromExtension, toExtension);
        File tempFile = new File(outputFile.getParentFile(), outputFile.getName() + ".tmp");

        try {
            System.out.println();
            System.out.println("Convertendo: " + inputFile.getName());

            if (outputFile.exists()) {
                System.out.println("Já existe: " + outputFile.getName());
                return ConvertResult.IGNORED;
            }

            BufferedImage originalImage = ImageIO.read(inputFile);

            if (originalImage == null) {
                System.out.println("Falha: o Java não conseguiu ler essa imagem.");
                return ConvertResult.FAILED;
            }

            BufferedImage forcedImage = forceRgbImage(originalImage, Color.WHITE);

            boolean written = writeJpg(forcedImage, tempFile, JPG_QUALITY);

            if (!written) {
                Files.deleteIfExists(tempFile.toPath());
                System.out.println("Falha: nenhum writer conseguiu salvar o JPG.");
                return ConvertResult.FAILED;
            }

            if (!tempFile.exists() || tempFile.length() <= 0) {
                Files.deleteIfExists(tempFile.toPath());
                System.out.println("Falha: o arquivo temporário ficou vazio.");
                return ConvertResult.FAILED;
            }

            Files.move(tempFile.toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            if (!outputFile.exists() || outputFile.length() <= 0) {
                System.out.println("Falha: o JPG final não foi criado corretamente.");
                return ConvertResult.FAILED;
            }

            if (DELETE_ORIGINAL_AFTER_SUCCESS) {
                Files.delete(inputFile.toPath());
                System.out.println("Original removido: " + inputFile.getName());
            }

            System.out.println("Convertido com sucesso: " + outputFile.getName());
            return ConvertResult.CONVERTED;
        } catch (Exception exception) {
            try {
                Files.deleteIfExists(tempFile.toPath());
            } catch (IOException ignored) {
            }

            System.out.println("Falha ao converter " + inputFile.getName() + ": " + exception.getMessage());
            return ConvertResult.FAILED;
        }
    }

    private static File createOutputFile(File inputFile, String fromExtension, String toExtension) {
        String fileName = inputFile.getName();
        String baseName = fileName.substring(0, fileName.length() - fromExtension.length());

        return new File(inputFile.getParentFile(), baseName + toExtension);
    }

    private static BufferedImage forceRgbImage(BufferedImage originalImage, Color backgroundColor) {
        BufferedImage rgbImage = new BufferedImage(
                originalImage.getWidth(),
                originalImage.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D graphics = rgbImage.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, originalImage.getWidth(), originalImage.getHeight());

        graphics.drawImage(originalImage, 0, 0, null);
        graphics.dispose();

        return rgbImage;
    }

    private static boolean writeJpg(BufferedImage image, File outputFile, float quality) throws IOException {
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

        if (!writers.hasNext()) {
            writers = ImageIO.getImageWritersByFormatName("jpeg");
        }

        if (!writers.hasNext()) {
            return false;
        }

        ImageWriter writer = writers.next();

        try (ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputFile)) {
            if (imageOutputStream == null) {
                return false;
            }

            writer.setOutput(imageOutputStream);

            ImageWriteParam writeParam = writer.getDefaultWriteParam();

            if (writeParam.canWriteCompressed()) {
                writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                writeParam.setCompressionQuality(Math.max(0.0f, Math.min(1.0f, quality)));
            }

            writer.write(null, new IIOImage(image, null, null), writeParam);
            imageOutputStream.flush();

            return true;
        } finally {
            writer.dispose();
        }
    }

    public enum ConvertResult {
        CONVERTED,
        IGNORED,
        FAILED
    }

}