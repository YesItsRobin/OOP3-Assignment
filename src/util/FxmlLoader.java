package src.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import src.main.main;

import java.util.Objects;

public class FxmlLoader {
    private static Pane view;

    public static Pane getPane(String filename) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(main.class.getResource("../views/" + filename + ".fxml")));
            view = (Pane) fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
