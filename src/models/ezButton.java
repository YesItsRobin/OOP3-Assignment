package src.models;

import javafx.scene.control.Button;

public class ezButton {
    javafx.scene.control.Button button;

    public ezButton(javafx.scene.control.Button button) {
        this.button = button;
        button.setStyle("-fx-background-color: #006400");
    }

    public void hover(){
        button.setStyle("-fx-background-color: #005000");
    }

    public void unhover(){
        button.setStyle("-fx-background-color: #006400");
    }

    public void press(){
        button.setStyle("-fx-background-color: #003800");
    }

    public void smaller(){
        button.setPrefHeight(50);
    }

    public Button getButton() {
        return button;
    }
}
