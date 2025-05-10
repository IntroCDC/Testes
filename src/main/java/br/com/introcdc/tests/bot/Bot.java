package br.com.introcdc.tests.bot;
/*
 * Written by IntroCDC, Bruno Coelho at 29/11/2024 - 02:07
 */

import java.util.Scanner;

public class Bot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.print("> ");
            String line = scanner.nextLine();
            System.out.println(BotBrain.NAME + ": " + BotBrain.replyTo(line));
        }
    }

}
