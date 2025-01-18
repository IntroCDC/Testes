package br.com.introcdc.tests.tests;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/01/2025 - 22:50
 */

public class Test {

    public static void main(String[] args) {
        String test = "aaaa|bbbb|ccc|dddd";
        String[] aaaaa = test.split("\\|");
        System.out.println(aaaaa.length);
    }

}
