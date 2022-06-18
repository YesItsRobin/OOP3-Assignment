package src.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import src.models.ezButton;

public class contactsController {
    @FXML
    private Button rButton1;
    @FXML
    private Button aButton1;
    private ezButton rButton;
    private ezButton aButton;

    @FXML
    public void initialize() {
        buttons();
    }

    private void buttons(){
        this.rButton = new ezButton(this.rButton1);
        this.aButton = new ezButton(this.aButton1);
    }

    public void rButtonPress() {
    }

    public void aButtonPress() {
    }

    public void aButtonPress2() {
        aButton.press();
    }

    public void rButtonPress2() {
        rButton.press();
    }

    public void rButtonHover() {
        rButton.hover();
    }

    public void aButtonHover() {
        aButton.hover();
    }
    public void rButtonPress3() {
        rButton.unhover();
    }

    public void aButtonPress3() {
        aButton.unhover();
    }
}
