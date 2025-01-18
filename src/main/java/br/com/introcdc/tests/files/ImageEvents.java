package br.com.introcdc.tests.files;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.imageio.ImageIO;

public class ImageEvents {

    // TODO CPU Usage
    public static void printUsage() {
        final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (final Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                } catch (final Exception e) {
                    value = e + " Error";
                }
                System.out.println(method.getName() + " = " + value);
            }
        }
    }

    // TODO Take A Print
    public static void takeAPrint() throws Exception {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final Rectangle screenRect = new Rectangle(screenSize);
        final Robot robot = new Robot();
        final BufferedImage screenCapturedImage = robot.createScreenCapture(screenRect);
        ImageIO.write(screenCapturedImage, "png", new File("C:/Users/Intro/Desktop/printScreen.png"));
    }

}
