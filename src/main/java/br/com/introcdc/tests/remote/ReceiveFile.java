package br.com.introcdc.tests.remote;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveFile {
    static int byteread;
    static int current = 0;
    static int maxsize = 999999999;
    static Socket socket = null;

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        final byte[] buffer = new byte[ReceiveFile.maxsize];
        final Socket socket = new Socket("localhost", 9099);
        final InputStream is = socket.getInputStream();
        final File test = new File("D:\\AtomSetup.exe");
        test.createNewFile();
        final FileOutputStream fos = new FileOutputStream(test);
        final BufferedOutputStream out = new BufferedOutputStream(fos);
        ReceiveFile.byteread = is.read(buffer, 0, buffer.length);
        ReceiveFile.current = ReceiveFile.byteread;

        do {
            ReceiveFile.byteread = is.read(buffer, 0, buffer.length - ReceiveFile.current);
            if (ReceiveFile.byteread >= 0) {
                ReceiveFile.current += ReceiveFile.byteread;
            }
        } while (ReceiveFile.byteread > -1);
        out.write(buffer, 0, ReceiveFile.current);
        out.flush();

        socket.close();
        fos.close();
        is.close();

    }
}
