package com.groupsecond.socketswebproxy;

public class Main {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        System.out.println(response);
        response = client.sendMessage("hello server again");
        System.out.println(response);
        client.stopConnection();
    }
}
