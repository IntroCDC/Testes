package br.com.introcdc.tests.remote;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientNio {

    public void startClient() throws IOException, InterruptedException {

        final InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
        final SocketChannel client = SocketChannel.open(hostAddress);

        System.out.println("Client... started");

        final String threadName = Thread.currentThread().getName();

        // Send messages to server
        final String[] messages = new String[] { threadName + ": test1", threadName + ": test2", threadName + ": test3" };

        for (final String message2 : messages) {
            final byte[] message = new String(message2).getBytes();
            final ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println(message2);
            buffer.clear();
            Thread.sleep(5000);
        }
        client.close();
    }
}
