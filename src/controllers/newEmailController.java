package src.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import src.models.Contact;
import src.models.BMessage;
import src.models.User;
import src.models.ezButton;

import javax.mail.MessagingException;

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


    public void send() throws MessagingException {
        BMessage BMessage = new BMessage(messageBox.getText(), User.getInstance().getContact(), contactMenu.getValue(), titleBox.getText());
        BMessage.send();
        System.out.println(BMessage);
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
