package com.groupsecond.socketswebproxycommon;

import com.google.gson.Gson;

import java.io.*;

public class SerializationService {

    public static String serializeObjectToJson(Object object) throws IOException {
        return new Gson().toJson(object);
    }

    public static ClientRequest deserializeJsonToClientRequest(String json) {
        return new Gson().fromJson(json, ClientRequest.class);
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
