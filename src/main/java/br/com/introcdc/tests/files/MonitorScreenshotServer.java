package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 02/05/2026 - 16:44
 */

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitorScreenshotServer {

    private static final File OUTPUT_FOLDER = new File("C:/Kindome/site/monitors");
    private static final float JPG_QUALITY = 0.72f;
    private static final int CAPTURE_DELAY_SECONDS = 1;

    private static List<MonitorCapture> monitorCaptures;
    private static byte[][] lastJpgBytes;

    public static void main(String[] args) throws Exception {
        OUTPUT_FOLDER.mkdirs();

        loadMonitors();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleWithFixedDelay(() -> {
            try {
                captureAllMonitors();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }, 0, CAPTURE_DELAY_SECONDS, TimeUnit.SECONDS);

        System.out.println("Capturando monitores a cada " + CAPTURE_DELAY_SECONDS + " segundo(s)...");
    }

    private static void loadMonitors() throws Exception {
        GraphicsDevice[] devices = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getScreenDevices();

        MonitorCapture[] captures = new MonitorCapture[devices.length];

        for (int i = 0; i < devices.length; i++) {
            GraphicsConfiguration configuration = devices[i].getDefaultConfiguration();
            Rectangle bounds = configuration.getBounds();
            Robot robot = new Robot(devices[i]);

            captures[i] = new MonitorCapture(i + 1, robot, bounds);
        }

        monitorCaptures = Arrays.asList(captures);
        lastJpgBytes = new byte[devices.length][];

        System.out.println("Monitores encontrados: " + devices.length);
    }

    private static void captureAllMonitors() throws Exception {
        for (int i = 0; i < monitorCaptures.size(); i++) {
            MonitorCapture monitorCapture = monitorCaptures.get(i);

            BufferedImage image = monitorCapture.robot().createScreenCapture(monitorCapture.bounds());
            byte[] jpgBytes = toJpgBytes(image, JPG_QUALITY);

            if (Arrays.equals(lastJpgBytes[i], jpgBytes)) {
                continue;
            }

            lastJpgBytes[i] = jpgBytes;

            File finalFile = new File(OUTPUT_FOLDER, "monitor_" + monitorCapture.index() + ".jpg");
            File tempFile = new File(OUTPUT_FOLDER, "monitor_" + monitorCapture.index() + ".tmp.jpg");

            Files.write(tempFile.toPath(), jpgBytes);

            Files.move(
                    tempFile.toPath(),
                    finalFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE
            );
        }
    }

    private static byte[] toJpgBytes(BufferedImage image, float quality) throws Exception {
        BufferedImage rgbImage = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D graphics = rgbImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

        if (!writers.hasNext()) {
            throw new IllegalStateException("Nenhum escritor JPG encontrado.");
        }

        ImageWriter writer = writers.next();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ImageOutputStream output = ImageIO.createImageOutputStream(byteArrayOutputStream)) {

            ImageWriteParam params = writer.getDefaultWriteParam();
            params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            params.setCompressionQuality(quality);

            writer.setOutput(output);
            writer.write(null, new IIOImage(rgbImage, null, null), params);

            output.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            writer.dispose();
        }
    }

    private record MonitorCapture(int index, Robot robot, Rectangle bounds) {
    }

}