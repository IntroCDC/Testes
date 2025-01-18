package br.com.introcdc.tests.remote;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ServerNio {
    public static void main(final String[] args) throws Exception {
        final Runnable server = new Runnable() {
            @Override
            public void run() {
                try {
                    new ServerNio("localhost", 8090).startServer();
                } catch (final IOException e) {
                    e.printStackTrace();
                }

            }
        };

        final Runnable client = new Runnable() {
            @Override
            public void run() {
                try {
                    new ClientNio().startClient();
                } catch (final IOException e) {
                    e.printStackTrace();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        new Thread(server).start();
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                new Thread(client, "client-A").start();
                new Thread(client, "client-B").start();
            }
        }, 1000);
    }

    @SuppressWarnings("rawtypes")
	public final Map<SocketChannel, List> dataMapper;
    private final InetSocketAddress listenAddress;

    private Selector selector;

    public ServerNio(final String address, final int port) throws IOException {
        this.listenAddress = new InetSocketAddress(address, port);
        this.dataMapper = new HashMap<>();
    }

    // accept a connection made to this channel's socket
    @SuppressWarnings("rawtypes")
	private void accept(final SelectionKey key) throws IOException {
        final ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        final SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);
        final Socket socket = channel.socket();
        final SocketAddress remoteAddr = socket.getRemoteSocketAddress();
        System.out.println("Connected to: " + remoteAddr);

        // register channel with selector for further IO
        this.dataMapper.put(channel, new ArrayList());
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    // read from the socket channel
    private void read(final SelectionKey key) throws IOException {
        final SocketChannel channel = (SocketChannel) key.channel();
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        int numRead = -1;
        numRead = channel.read(buffer);

        if (numRead == -1) {
            this.dataMapper.remove(channel);
            final Socket socket = channel.socket();
            final SocketAddress remoteAddr = socket.getRemoteSocketAddress();
            System.out.println("Connection closed by client: " + remoteAddr);
            channel.close();
            key.cancel();
            return;
        }

        final byte[] data = new byte[numRead];
        System.arraycopy(buffer.array(), 0, data, 0, numRead);
        System.out.println("Got: " + new String(data));
    }

    // create server channel
    private void startServer() throws IOException {
        this.selector = Selector.open();
        final ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        // retrieve server socket and bind to port
        serverChannel.socket().bind(this.listenAddress);
        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started...");

        while (true) {
            // wait for events
            this.selector.select();

            // work on selected keys
            @SuppressWarnings("rawtypes")
			final Iterator keys = this.selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                final SelectionKey key = (SelectionKey) keys.next();

                // this is necessary to prevent the same key from coming up
                // again the next time around.
                keys.remove();

                if (!key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                    this.accept(key);
                } else if (key.isReadable()) {
                    this.read(key);
                }
            }
        }
    }
}
