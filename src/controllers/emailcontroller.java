package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.models.BMessage;
import src.models.User;
import src.models.ezButton;
import src.util.CheckForEmail;
import src.util.FxmlLoader;

import javax.mail.Message;

public class emailcontroller {
    public AnchorPane ePane;
    public ListView emailList;
    public Label emailLabel;

    @FXML
    public void initialize() {
        emailList.getItems().addAll(User.getInstance().getEmails());
        if (User.getInstance().isComplete()){
            loggedIn();
        }
        else{
            emailLabel.setText("Create profile to get emails");
            emailLabel.setTextFill(javafx.scene.paint.Color.RED);
            emailLabel.setFont(javafx.scene.text.Font.font("Arial", 30));
        }
    }

    public void loggedIn() {
        emailLabel.setText("Select an email to read it here");
        emailLabel.setFont(javafx.scene.text.Font.font("Arial", 10));
        CheckForEmail check = new CheckForEmail();
        check.run();
    }
    public void setText(Message message) {
        //set email
    }
}
