package com.groupsecond.socketswebproxyclient;

import com.groupsecond.socketswebproxycommon.ClientRequest;
import com.groupsecond.socketswebproxycommon.ServerResponse;

import java.net.*;
import java.io.*;

public class SocketClient {
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerResponse sendMessage(ClientRequest request) throws IOException, ClassNotFoundException {
        out.writeObject(request);
        ServerResponse response = (ServerResponse) in.readObject();
        return response;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

