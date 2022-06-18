package src.models;

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

}
