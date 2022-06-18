package src.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.models.Contact;
import src.models.User;
import src.models.ezButton;

public class contactsController {
    public TextField cName;
    public TextField cEmail;
    public TextField cPubCert;
    public AnchorPane cPane;
    public ListView cListView;
    public Label contDetails;
    @FXML
    private Button rButton1;
    @FXML
    private Button aButton1;
    private ezButton rButton;
    private ezButton aButton;

    @FXML
    public void initialize() {
        buttons();
        cListView.getItems().clear();
        cListView.getItems().addAll(User.getInstance().getContacts());
        cListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2 && click.getButton() == MouseButton.PRIMARY) {
                    Contact selectedcontact = (Contact) cListView.getSelectionModel().getSelectedItem();
                    contDetails.setText(selectedcontact.toString());
                }
            }
        });
    }

    private void buttons(){
        this.rButton = new ezButton(this.rButton1);
        this.aButton = new ezButton(this.aButton1);
    }

    public void rButtonPress() {
        User.getInstance().removeContact((Contact) cListView.getSelectionModel().getSelectedItem());
        initialize();
    }

    public void aButtonPress() {
        User.getInstance().addContact(new Contact(cName.getText(), cEmail.getText(), cPubCert.getText()));
        initialize();
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
