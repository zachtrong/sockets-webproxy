package com.groupsecond.socketswebproxy;

import java.net.*;
import java.io.*;

public class  SocketClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String sendMessage(String msg) {
        String resp = "";
        try {
            out.println(msg);
            resp = in.readLine();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
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

