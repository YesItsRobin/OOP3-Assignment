package src.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class menuController {

    @FXML
    public AnchorPane pane;
    public Button pButton;
    public Button cButton;

    @FXML
    public void initialize() {
        pane.setStyle("-fx-background-color: #000000;");
        cButton.setStyle("-fx-background-color: #006400;");
        pButton.setStyle("-fx-background-color: #006400;");
    }

}
