package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.models.ezButton;
import src.util.FxmlLoader;

import java.io.IOException;

public class menuController {
    @FXML
    public AnchorPane mainPane;
    public Button pButton1;
    public Button cButton1;
    public Button eButton1;
    public BorderPane infoPane;
    public Button newButton1;
    private ezButton newButton;
    private ezButton pButton;
    private ezButton cButton;
    private ezButton eButton;

    @FXML
    public void initialize() throws IOException {
        mainPane.setStyle("-fx-background-color: #000000");
        buttons();
        infoPane.setStyle("-fx-background-color: #60C460");
        infoPane.setCenter(FxmlLoader.getPane("emailPane"));
    }

    private void buttons(){
        this.pButton = new ezButton(this.pButton1);
        this.cButton = new ezButton(this.cButton1);
        this.eButton = new ezButton(this.eButton1);
        this.newButton = new ezButton(this.newButton1);
    }

    public void cButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("contactsPane"));
        cButton.smaller();
    }

    public void pButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("profilePane"));
        pButton.smaller();
    }

    public void eButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("emailPane"));
        eButton.smaller();
    }
    public void pButtonPress2() {
        pButton.press();
        pButton.getButton().setPrefHeight(60);
    }

    public void cButtonPress2() {
        cButton.press();
        cButton.getButton().setPrefHeight(60);
    }
    public void eButtonPress2() {
        eButton.press();
        eButton.getButton().setPrefHeight(60);
    }

    public void pButtonPress3() {
        pButton.unhover();
    }

    public void cButtonPress3() {
        cButton.unhover();
    }

    public void eButtonPress3() {
        eButton.unhover();
    }

    public void pButtonHover() {
        pButton.hover();
    }

    public void cButtonHover() {
        cButton.hover();
    }

    public void eButtonHover() {
        eButton.hover();
    }


    public void newEmail() {
        infoPane.setCenter(FxmlLoader.getPane("newEmailPane"));
        newButton.smaller();
    }

    public void hover() {
        newButton.hover();
    }

    public void unhover() {
        newButton.unhover();
    }

    public void press() {
        newButton.press();
        newButton.getButton().setPrefHeight(60);
    }
}