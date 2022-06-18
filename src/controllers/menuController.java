package src.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
    private ezButton pButton;
    private ezButton cButton;
    private ezButton eButton;

    @FXML
    public void initialize() throws IOException {
        mainPane.setStyle("-fx-background-color: #000000");
        buttons();
        infoPane.setCenter(FxmlLoader.getPane("emailPane"));
    }

    private void buttons(){
        this.pButton = new ezButton(this.pButton1);
        this.cButton = new ezButton(this.cButton1);
        this.eButton = new ezButton(this.eButton1);
    }

    public void cButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("contactsPane"));
    }

    public void pButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("profilePane"));
    }

    public void eButtonPress() {
        infoPane.setCenter(FxmlLoader.getPane("emailPane"));
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