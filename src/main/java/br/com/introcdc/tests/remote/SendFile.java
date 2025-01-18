package br.com.introcdc.tests.remote;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFile {
    static byte[] buffer = new byte[(int) SendFile.myFile.length()];
    static File myFile = new File("C:\\Users\\hieptq\\Desktop\\AtomSetup.exe");
    static OutputStream out = null;
    static ServerSocket receiver = null;
    static Socket socket = null;

    public static void main(final String[] args) throws IOException {
        SendFile.receiver = new ServerSocket(9099);
        SendFile.socket = SendFile.receiver.accept();
        System.out.println("Accepted connection from : " + SendFile.socket);
        final FileInputStream fis = new FileInputStream(SendFile.myFile);
        final BufferedInputStream in = new BufferedInputStream(fis);
        in.read(SendFile.buffer, 0, SendFile.buffer.length);
        SendFile.out = SendFile.socket.getOutputStream();
        System.out.println("Sending files");
        SendFile.out.write(SendFile.buffer, 0, SendFile.buffer.length);
        SendFile.out.flush();
        SendFile.out.close();
        in.close();
        SendFile.socket.close();
        System.out.println("Finished sending");
    }

}
