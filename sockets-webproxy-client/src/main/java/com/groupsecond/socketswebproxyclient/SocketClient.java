package com.groupsecond.socketswebproxyclient;

import com.groupsecond.socketswebproxycommon.ClientRequest;
import com.groupsecond.socketswebproxycommon.ServerResponse;
import org.jetbrains.annotations.Nullable;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SocketClient {
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private static AtomicInteger SESSIONID = new AtomicInteger(1000000);

    @Nullable
    public static ServerResponse establishAndSendMessage(String serverUrl, String url) {
        SocketClient client = new SocketClient();
        client.startConnection(serverUrl, 6666);

        ClientRequest request = new ClientRequest(String.valueOf(SESSIONID.getAndIncrement()), url);
        ServerResponse response = null;
        try {
            response = client.sendMessage(request);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            client.stopConnection();
        }
        return response;
    }

    private void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ServerResponse sendMessage(ClientRequest request) throws IOException, ClassNotFoundException {
        out.writeObject(request);
        ServerResponse response = (ServerResponse) in.readObject();
        return response;
    }

    private void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

