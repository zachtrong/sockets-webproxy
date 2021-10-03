package com.groupsecond.socketswebproxyserver;

import java.io.*;

public class ServerApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SocketServer server = new SocketServer();
        server.start(6666);
    }

}
