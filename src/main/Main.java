package src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;

import java.io.FileInputStream;
import java.io.IOException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import src.util.CheckForEmail;
import src.util.Baeldung;
import src.util.Crypto;
import src.util.KeyPairHandler;

import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
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
            UnrecoverableKeyException,
            InvalidAlgorithmParameterException,
            NoSuchPaddingException,
            InvalidKeyException {
        int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        Security.addProvider(new BouncyCastleProvider());

        //PublicKey  pk = (PublicKey) KeyPairHandler.getInstance().getPublicKey("data/Baeldung.cer");
        X509Certificate cert = KeyPairHandler.getInstance().getPublicKey("data/Baeldung.cer");
        PublicKey publicKey = cert.getPublicKey();


        //RSAEncryptionHandler.getInstance().encrypt("hello world", publicKey);

        // LAUNCH APPLICATION
        launch();
        // END
    }
}
