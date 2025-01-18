package br.com.introcdc.tests.tests;
/*
 * Written by IntroCDC, Bruno Coêlho at 07/01/2025 - 21:09
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

public class ProcessWatcher {

    public static boolean isProcessRunning(long pid) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            Process process;
            if (os.contains("win")) {
                process = Runtime.getRuntime().exec("tasklist /FI \"PID eq " + pid + "\"");
            } else {
                process = Runtime.getRuntime().exec("ps -p " + pid);
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                if (line.contains(String.valueOf(pid))) {
                    input.close();
                    return true;
                }
            }
            input.close();
        } catch (Exception ignored) {
        }
        return false;
    }

    public static long getPID() {
        return Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
    }

}
