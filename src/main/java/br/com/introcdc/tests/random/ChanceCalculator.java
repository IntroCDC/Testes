package br.com.introcdc.tests.random;
/*
 * Written by IntroCDC, Bruno Coelho at 01/04/2021 - 17:58
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChanceCalculator {

    public static void main(String[] args) {
        int bTotal = 0;
        int tries = 0;
        int total = 0;
        int[] numbers = new int[10];
        Random random = new Random();
        Map<Integer, Integer> all = new HashMap<>();

        for (; ; ) {
            bTotal++;
            tries++;
            int n = random.nextInt(1000) + 1;
            all.put(n, all.getOrDefault(n, 0) + 1);
            if (n == 215) {
                System.out.println("Vitória registrada: " + n + " (" + tries + ")");

                numbers[total] = tries;
                tries = 0;
                total++;
                if (total == 10) {
                    break;
                }
            }
        }

        int most = mostDAIUHASDH(all);
        System.out.print("Números (" + most + " - " + all.get(most) + "/" + bTotal + "): ");
        for (int a : numbers) {
            System.out.print(a + " - ");
        }
    }

    public static int mostDAIUHASDH(Map<Integer, Integer> all) {
        int most = -1;
        int selected = 0;
        for (int key : all.keySet()) {
            if (all.get(key) > most) {
                most = all.get(key);
                selected = key;
            }
        }
        return selected;
    }

}
