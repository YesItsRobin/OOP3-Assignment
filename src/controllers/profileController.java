package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    }

    public void editButtonPress(ActionEvent actionEvent) {
    }
}