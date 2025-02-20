package br.com.introcdc.tests.tests;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/01/2025 - 22:50
 */

public class Test {

    public static void main(String[] args) throws Exception {
        String postContent = "Live\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "        Tipo: Gameplay\n" +
                "\n" +
                "\n" +
                "        Local: @Kindome\n" +
                "\n" +
                "\n" +
                "        Data: 12/02/2025 - 13/02/2025\n" +
                "\n" +
                "\n" +
                "        Participações: @Bruno Coelho";

        System.out.println(postContent);
        postContent = postContent.replaceAll("(\\r?\\n){2,}", "\n");
        postContent = postContent.trim();
        System.out.println(postContent);
    }

}
