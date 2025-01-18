package br.com.introcdc.tests.killer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class ACMain {

    public static final Calendar calendar = Calendar.getInstance();
    private static final Timer timer = new Timer();
    private static int times = 0;

    public static int getHours() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static String getTime() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
    }

    public static void main(final String[] args) {
        System.out.println("Testando... Horas: (" + getHours() + ")" + getTime());
        try {
            if (getHours() < 5) {
                times++;
                sendMessage("VAI DORMIR RAFAEL!");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM chrome.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM csgo.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM javaw.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM hl2.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM gta5.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM rocketleague.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM rl.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM gs.exe");
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /IM goatsimulator.exe");
                if (times == 60) {
                    sendMessage("Desligando computador...");
                    Runtime.getRuntime().exec("cmd.exe /c shutdown -s -t 60");
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                main(args);
            }
        }, 1000);
    }

    public static void sendMessage(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message, "VAI DORMIR", 1);
            }
        }).start();
    }

}
