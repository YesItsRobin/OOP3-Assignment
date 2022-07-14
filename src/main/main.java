package src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.models.BMessage;
import src.models.Contact;
import src.models.User;
import src.util.CheckForEmail;

import javax.mail.MessagingException;
import java.io.IOException;

public class main  extends Application {
    @Override
    public void start(Stage stage) throws IOException, MessagingException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("../views/mainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setResizable(false);
        stage.setTitle("Beemail");
        stage.setScene(scene);
        stage.show();
        User.getInstance().getContact().setEmail("user@email.com");
        User.getInstance().getContact().setHost("smtp.gmail.com");
        User.getInstance().addEmail(new BMessage("this is the text thing",User.getInstance().getContact(),new Contact("Bob","Bob@bobberson.com","the key?"),"this is the subject"));
    }

    public static void main(String[] args) {
        launch();
    }
}
