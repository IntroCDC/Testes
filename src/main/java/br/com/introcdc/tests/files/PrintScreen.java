package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 09/03/2024 - 04:38
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PrintScreen {

    public static void main(String[] args) throws Exception {
        System.out.println("Tirando print...");
        int monitor = 1;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        if (screens.length <= monitor) {
            GraphicsDevice secondScreen = screens[monitor - 1];
            DisplayMode dm = secondScreen.getDisplayMode();
            int screenWidth = dm.getWidth();
            int screenHeight = dm.getHeight();

            Rectangle screenBounds = secondScreen.getDefaultConfiguration().getBounds();

            BufferedImage image = new Robot().createScreenCapture(new Rectangle(screenBounds.x, screenBounds.y, screenWidth, screenHeight));

            System.out.println("Salvando...");
            ImageIO.write(image, "png", new File("print.png"));
            System.out.println("Pronto!");
        } else {
            System.out.println("Monitor não encontrado.");
        }
    }

}
