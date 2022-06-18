package src.views;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class View  {
    Pane pane;

    public View(Pane pane) {
        this.pane = pane;
        pane.setStyle("-fx-background-color: #000000");
        hide();
    }

    public void hide() {
        pane.setVisible(false);
    }

    public void show() {
        pane.setVisible(true);
    }

    public AnchorPane getPane() {
        return (AnchorPane) pane;
    }
}