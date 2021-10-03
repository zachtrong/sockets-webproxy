package com.groupsecond.socketswebproxy;

import java.io.*;

public class ClientApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Server side TCP socket");

        ClientRequest serverResponse = new ClientRequest("abc", "def");

        System.out.println("Convert object to byte array: " + serializeObjectToByteArray(serverResponse));

        ClientRequest serverResponse2 = (ClientRequest) deserializeByteArrayToObject(serializeObjectToByteArray(serverResponse));

        System.out.println("Get Session ID from Object: " + serverResponse2.getSessionId());
        System.out.println("Get URL from Object: " + serverResponse2.getUrl());

    }

    public static byte[] serializeObjectToByteArray(Object yourObject) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(yourObject);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            return yourBytes;
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    public static Object deserializeByteArrayToObject(byte[] yourBytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
        ObjectInput in = null;
        Object o = new Object();
        try {
            in = new ObjectInputStream(bis);
            o = in.readObject();
            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return o;
    }
}
