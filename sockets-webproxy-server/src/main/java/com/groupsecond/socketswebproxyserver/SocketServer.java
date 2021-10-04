package com.groupsecond.socketswebproxyserver;

import com.groupsecond.socketswebproxycommon.ClientRequest;
import com.groupsecond.socketswebproxycommon.ServerResponse;

import javax.net.ServerSocketFactory;
import java.net.*;
import java.io.*;

public class SocketServer {
    public static final String HOSTNAME = "0.0.0.0";
    private ServerSocket serverSocket;

    public void start(int port) {
        try {
            serverSocket = ServerSocketFactory.getDefault().createServerSocket();
            serverSocket.bind(new InetSocketAddress(HOSTNAME, port));
            while (true) {
                new EchoClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class EchoClientHandler extends Thread {
        private HttpService httpService = new HttpService();
        private Socket clientSocket;
        private ObjectOutputStream out;
        private ObjectInputStream in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());

                ClientRequest clientRequest = (ClientRequest) in.readObject();
                processClientRequest(out, clientRequest);

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void processClientRequest(ObjectOutputStream out, ClientRequest clientRequest) throws IOException {
            System.out.println(clientRequest.toString());

            ServerResponse response = new ServerResponse();
            response.setSessionId(clientRequest.getSessionId());
            response.setUrl(clientRequest.getUrl());

            try {
                response.setContent(httpService.fetchContentFromUrl(clientRequest.getUrl()));
            } catch (IOException | InterruptedException e) {
                response.setContent(e.getMessage());
            }

            out.writeObject(response);
        }
    }
}