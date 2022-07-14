package src.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import src.main.Main;

import java.util.Objects;

public class FxmlLoader {
    private static Pane view;

    public static Pane getPane(String filename) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("../views/" + filename + ".fxml")));
            view = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
