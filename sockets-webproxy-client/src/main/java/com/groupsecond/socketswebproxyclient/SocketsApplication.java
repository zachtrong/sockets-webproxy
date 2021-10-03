package com.groupsecond.socketswebproxyclient;

import com.groupsecond.socketswebproxycommon.ClientRequest;
import com.groupsecond.socketswebproxycommon.ServerResponse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class SocketsApplication extends Application {

    public static final int NUM_THREAD_POOL_SIZE = 3;
    private ScheduledExecutorService ioThread = new ScheduledThreadPoolExecutor(NUM_THREAD_POOL_SIZE);

    private void startSocketService() {
        ioThread.submit(() -> {
            SocketClient client = new SocketClient();
            client.startConnection("127.0.0.1", 6666);

            ClientRequest clientRequest = new ClientRequest("1000000", "https://example.com");
            try {
                ServerResponse response = client.sendMessage(clientRequest);

                System.out.println(response);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        //client.stopConnection();
    }

    @Override
    public void start(Stage stage) throws IOException {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        FXMLLoader fxmlLoader = new FXMLLoader(SocketsApplication.class.getResource("sockets-webproxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,800);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setTitle("Sockets Web Proxy - Group 2");
        stage.setScene(scene);
        stage.show();

        startSocketService();
    }

    public static void main(String[] args) {
        launch();
    }
}