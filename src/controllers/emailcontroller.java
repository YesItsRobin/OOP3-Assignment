package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.models.User;
import src.models.ezButton;
import src.util.FxmlLoader;

public class emailcontroller {
    public AnchorPane ePane;
    public ListView emailList;
    public Label emailLabel;

    @FXML
    public void initialize() {
        emailList.getItems().addAll(User.getInstance().getEmails());
    }
}
