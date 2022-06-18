package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.models.ezButton;

public class newEmailController {
    public MenuButton contactMenu;
    public TextField titleBox;
    public TextArea messageBox;
    public Button sendButton1;
    public ezButton sendButton;

    @FXML
    public void initialize() {
        sendButton = new ezButton(sendButton1);
        contactMenu.setStyle("-fx-background-color: #006400");
    }


    public void send() {
    }

    public void hover() {
        sendButton.hover();
    }

    public void unhover() {
        sendButton.unhover();
    }

    public void press() {
        sendButton.press();
    }
}
