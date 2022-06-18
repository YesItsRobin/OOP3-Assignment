package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import src.models.Contact;
import src.models.Message;
import src.models.User;
import src.models.ezButton;

import java.util.ArrayList;

public class newEmailController {
    public ChoiceBox<Contact> contactMenu;
    public TextField titleBox;
    public TextArea messageBox;
    public Button sendButton1;
    public ezButton sendButton;

    @FXML
    public void initialize() {
        sendButton = new ezButton(sendButton1);
        contactMenu.setStyle("-fx-background-color: #006400");
        contactMenu.getItems().clear();
        contactMenu.getItems().addAll(User.getInstance().getContacts());
    }


    public void send() {
        Message message = new Message(messageBox.getText(), User.getInstance().getContact(), contactMenu.getValue(), titleBox.getText());
        message.send();
        System.out.println(message);
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
