package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import src.main.main;
import src.models.ezButton;
import src.util.FxmlLoader;
import src.views.View;

import java.io.IOException;

public class menuController {
    @FXML
    public AnchorPane mainPane;
    public Button pButton1;
    public Button cButton1;
    public Button eButton1;
    public BorderPane infoPane;
    private Pane eView;
    private Pane pView;
    private Pane cView;
    private ezButton pButton;
    private ezButton cButton;
    private ezButton eButton;

    @FXML
    public void initialize() throws IOException {
        mainPane.setStyle("-fx-background-color: #000000");
        buttons();
        views();
        infoPane.setCenter(eView);
    }

    private void buttons(){
        this.pButton = new ezButton(this.pButton1);
        this.cButton = new ezButton(this.cButton1);
        this.eButton = new ezButton(this.eButton1);
    }

    private void views() throws IOException {
        eView = FxmlLoader.getPane("emailPane");
        pView = FxmlLoader.getPane("profilePane");
        cView = FxmlLoader.getPane("contactsPane");
    }
    public void cButtonPress() {
        infoPane.setCenter(cView);
    }

    public void pButtonPress() {
        infoPane.setCenter(pView);
    }

    public void eButtonPress() {
        infoPane.setCenter(eView);
    }
    public void pButtonPress2() {
        pButton.press();
    }

    public void cButtonPress2() {
        cButton.press();
    }
    public void eButtonPress2() {
        eButton.press();
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


}