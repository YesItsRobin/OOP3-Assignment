package src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import src.models.BMessage;
import src.models.Contact;
import src.models.User;
//import src.util.CheckForEmail;

import javax.mail.MessagingException;

import java.io.FileInputStream;
import java.io.IOException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import src.util.CheckForEmail;

import java.security.*;
import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate; //not used?


public class Main  extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../views/mainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setResizable(false);
        stage.setTitle("Beemail");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws
            MessagingException,
            NoSuchAlgorithmException,
            CertificateException,
            NoSuchProviderException,
            IOException,
            KeyStoreException,
            UnrecoverableKeyException {
        int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        System.out.println(maxKeySize);

        // ADDING BOUNCY CASTLES AS PROVIDER --- MAKE DYNAMIC
        Security.addProvider(new BouncyCastleProvider()); // adds BouncyCastle as provider to security as "BC"

        //CertificateFactory certificateFactory = CertificateFactory.
        //      getInstance("X.509", "BC");
        // END

        // Not used?:
        //X509Certificate certificate = (X509Certificate) certificateFactory.
        //       generateCertificate(new FileInputStream("data/Baeldung.cer"));

        char[] keystorePassword = "password".toCharArray();
        char[] keyPassword = "password".toCharArray();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new FileInputStream("data/Baeldung.p12"), keystorePassword);

        PrivateKey key = (PrivateKey) keyStore.getKey("baeldung", keyPassword);

        System.out.println(key);

        // LAUNCH APPLICATION
        launch();
        // END
    }
}
