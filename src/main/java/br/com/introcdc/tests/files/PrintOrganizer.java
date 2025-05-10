package br.com.introcdc.tests.files;
/*
 * Written by IntroCDC, Bruno Coelho at 13/03/2024 - 10:42
 */

import java.io.File;

public class PrintOrganizer {

    // Config
    public static String FOLDER = "F:\\Imagens\\Lightshot";
    public static String STARTER = "Screenshot_";
    public static String ENDING = ".png";

    // Executing
    public static int CURRENT = 1;
    public static int RENAMING = 1;
    public static int MAX_TEST = 10000;
    public static int TESTING = 0;
    public static int RENAMED = 0;

    public static void main(String[] args) {
        while (true) {
            File file = new File(FOLDER, STARTER + CURRENT + ENDING);
            if (file.exists()) {
                if (CURRENT != RENAMING) {
                    file.renameTo(new File(FOLDER, STARTER + RENAMING + ENDING));
                    RENAMED++;
                    System.out.println("RENOMEANDO " + STARTER + CURRENT + ENDING + " -> " + STARTER + RENAMING + ENDING +
                            " (" + RENAMED + " arquivos renomeados)");
                }
                RENAMING++;
                TESTING = 0;
            } else {
                TESTING++;
                if (TESTING % 50 == 0) {
                    System.out.println("TESTANDO ARQUIVOS ALÉM... (" + TESTING + "/" + MAX_TEST + ")");
                }
                if (TESTING >= MAX_TEST) {
                    System.out.println("O TESTADOR ATINGIU O LIMITE, O PROGRAMA PAROU DE EXECUTAR!");
                    System.out.println("TESTADOS: " + CURRENT);
                    System.out.println("MUDANÇA: " + CURRENT + " -> " + RENAMING);
                    System.out.println("RENOMEADOS: " + RENAMED);
                    break;
                }
            }
            CURRENT++;
            if (CURRENT % 100 == 0) {
                System.out.println("VERIFICANDO ARQUIVOS... " + CURRENT + "...");
            }
        }
    }

}
