package com.groupsecond.socketswebproxyclient;

import com.groupsecond.socketswebproxycommon.ServerResponse;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class SocketsController {
    public static final int NUM_THREAD_POOL_SIZE = 3;
    private static ScheduledExecutorService ioThread = new ScheduledThreadPoolExecutor(NUM_THREAD_POOL_SIZE);

    @FXML
    public WebView socketsWebview;
    @FXML
    public TextField url;
    @FXML
    public TextField serverUrl;
    @FXML
    private Label welcomeText;

    @FXML
    public void onLoadUrlButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Loading: " + url.getText() + " in server IP address: " + serverUrl.getText());

        ioThread.submit(() -> {
            ServerResponse response = SocketClient.establishAndSendMessage(serverUrl.getText(), url.getText());

            Platform.runLater(() -> {
                // UI Thread
                if (response != null) {
                    socketsWebview.getEngine().loadContent(response.getContent());
                }
            });
        });
    }
}