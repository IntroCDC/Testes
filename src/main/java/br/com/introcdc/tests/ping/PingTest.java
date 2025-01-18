package br.com.introcdc.tests.ping;
/*
 * Written by IntroCDC, Bruno Coêlho at 11/12/2024 - 22:46
 */

import br.com.introcdc.tests.audio.Audio;
import br.com.introcdc.tests.database.StringComponents;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PingTest {

    private static final String URL_TO_PING = "https://www.google.com";
    private static final int DELAY_IN_SECONDS = 1;
    private static boolean ERROR = false;

    private static final Logger logger = Logger.getLogger(PingTest.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("internet_monitor.log");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    URL url = new URL(URL_TO_PING);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(DELAY_IN_SECONDS * 1000);
                    conn.setRequestMethod("GET");
                    int responseCode = conn.getResponseCode();

                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        Audio.generateBeep(500, 2000);
                        logger.warning("A internet está instável às " + StringComponents.currentDate());
                    } else {
                        if (ERROR) {
                            ERROR = false;
                            Audio.generateBeep(500, 1000);
                            logger.info("Conectado novamente! " + StringComponents.currentDate());
                        }
                    }
                } catch (IOException e) {
                    if (!ERROR) {
                        ERROR = true;
                        Audio.generateBeep(500, 500);
                        logger.severe("Erro ao conectar: " + StringComponents.currentDate());
                    }
                }
            }
        }, 0, DELAY_IN_SECONDS * 1000);
    }

}
