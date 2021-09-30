package com.groupsecond.socketswebproxy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class SocketsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        FXMLLoader fxmlLoader = new FXMLLoader(SocketsApplication.class.getResource("sockets-webproxy.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,800);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setTitle("Web Proxy");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}