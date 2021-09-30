package com.nhom2.socketswebproxy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class SocketsController {
    @FXML
    public WebView socketsWebview;
    @FXML
    public TextField textInput;
    @FXML
    private Label welcomeText;

    @FXML
    public void onLoadButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Loading " + textInput.getText());
        socketsWebview.getEngine().load(textInput.getText());
    }
}