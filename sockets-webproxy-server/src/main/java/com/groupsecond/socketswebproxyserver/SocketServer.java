package com.groupsecond.socketswebproxyserver;

import com.groupsecond.socketswebproxycommon.ClientRequest;
import com.groupsecond.socketswebproxycommon.ServerResponse;

import java.net.*;
import java.io.*;

public class SocketServer {
    private ServerSocket serverSocket;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
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
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void processClientRequest(ObjectOutputStream out, ClientRequest clientRequest) throws IOException, InterruptedException {
            System.out.println(clientRequest.toString());

            ServerResponse response = new ServerResponse();
            response.setSessionId(clientRequest.getSessionId());
            response.setUrl(clientRequest.getUrl());
            response.setContent(httpService.fetchContentFromUrl(clientRequest.getUrl()));

            out.writeObject(response);
        }
    }
}