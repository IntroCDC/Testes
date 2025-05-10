package br.com.introcdc.tests.redirector;
/*
 * Written by IntroCDC, Bruno Coelho at 15/01/2025 - 22:13
 */

import java.io.*;
import java.net.*;

public class ConnectionRedirector {

    public static void main(String[] args) {
        int localPort = 25565;
        String remoteHost = "192.168.0.3";
        int remotePort = 25565;

        try (ServerSocket serverSocket = new ServerSocket(localPort)) {
            System.out.println("Redirecionador ativo na porta " + localPort +
                    " para " + remoteHost + ":" + remotePort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão recebida de: " + clientSocket.getInetAddress());

                new Thread(() -> handleConnection(clientSocket, remoteHost, remotePort)).start();
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleConnection(Socket clientSocket, String remoteHost, int remotePort) {
        try (Socket remoteSocket = new Socket(remoteHost, remotePort)) {
            System.out.println("Conectado ao host remoto: " + remoteHost + ":" + remotePort);

            Thread clientToRemote = new Thread(() -> transferData(clientSocket, remoteSocket));
            Thread remoteToClient = new Thread(() -> transferData(remoteSocket, clientSocket));

            clientToRemote.start();
            remoteToClient.start();

            clientToRemote.join();
            remoteToClient.join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro durante a conexão: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar o socket do cliente: " + e.getMessage());
            }
        }
    }

    private static void transferData(Socket inputSocket, Socket outputSocket) {
        try (InputStream in = inputSocket.getInputStream();
             OutputStream out = outputSocket.getOutputStream()) {

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Erro na transferência de dados: " + e.getMessage());
        }
    }

}
