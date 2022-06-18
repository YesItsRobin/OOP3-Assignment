package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.models.Key;
import src.models.User;
import src.models.ezButton;

public class profileController {
    public Button editButton1;
    public TextField uPass;
    public TextField uPrivKey;
    public TextField Uemail;
    public TextField uName;
    public AnchorPane cPane;
    public ezButton editButton;

    @FXML
    public void initialize() {
        this.editButton = new ezButton(this.editButton1);
        this.uName.setText(User.getInstance().getContact().getName());
        this.Uemail.setText(User.getInstance().getContact().getEmail());
        this.uPrivKey.setText(User.getInstance().getPrivatekey());
        this.uPass.setText(User.getInstance().getPassword());
    }

    public void editButtonPress() {
        User.getInstance().getContact().setName(this.uName.getText());
        User.getInstance().getContact().setEmail(this.Uemail.getText());
        User.getInstance().setPrivatekey(this.uPrivKey.getText());
        User.getInstance().setPassword(this.uPass.getText());
        initialize();
    }

    public void hover() {
        editButton.hover();
    }

    public void unhover() {
        editButton.unhover();
    }

    public void pressed() {
        editButton.press();
    }

    public void released() {
        editButton.hover();
    }
}