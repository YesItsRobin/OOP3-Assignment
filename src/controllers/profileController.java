package src.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import src.models.User;
import src.models.ezButton;

public class profileController {
    public Button editButton1;
    public TextField uPass;
    public TextField Uemail;
    public TextField uName;
    public AnchorPane cPane;
    public ezButton editButton;
    public TextField uip;
    public TextField uSmtp;
    public TextField uCertPath;
    public TextField uPo;

    @FXML
    public void initialize() {
        this.editButton = new ezButton(this.editButton1);
        this.uName.setText(User.getInstance().getContact().getName());
        this.Uemail.setText(User.getInstance().getContact().getEmail());
        this.uPass.setText(User.getInstance().getPassword());
        this.uip.setText(User.getInstance().getContact().getIp());
        this.uSmtp.setText(User.getInstance().getContact().getHost());
        this.uCertPath.setText(User.getInstance().getContact().getPublicKeyCertificate());
        this.uPo.setText(User.getInstance().getContact().getPort());

    }

    public void editButtonPress() {
        User.getInstance().getContact().setName(this.uName.getText());
        User.getInstance().getContact().setEmail(this.Uemail.getText());
        User.getInstance().setPassword(this.uPass.getText());
        User.getInstance().getContact().setIp(this.uip.getText());
        User.getInstance().getContact().setHost(this.uSmtp.getText());
        User.getInstance().getContact().setPublicKeyCertificate(this.uCertPath.getText());
        User.getInstance().getContact().setPort(this.uPo.getText());
        if (User.getInstance().isComplete()){
            menuController.newButton.getButton().setDisable(false);
        }
        else{
            menuController.newButton.getButton().setDisable(true);
        }

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