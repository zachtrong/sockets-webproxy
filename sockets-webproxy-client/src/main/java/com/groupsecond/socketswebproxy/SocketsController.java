package com.groupsecond.socketswebproxy;

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
    public TextField IPAddress;
    @FXML
    private Label welcomeText;

    @FXML
    public void onLoadButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Loading " + textInput.getText() + " in server IP address" + IPAddress.getText());
        socketsWebview.getEngine().load(textInput.getText());
    }
}