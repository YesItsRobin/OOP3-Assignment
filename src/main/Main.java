package src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import src.models.BMessage;
import src.models.Contact;
import src.models.User;
//import src.util.CheckForEmail;

import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;

import java.io.FileInputStream;
import java.io.IOException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
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
            InvalidKeyException,
            CMSException {
        int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        System.out.println(maxKeySize);
        Security.addProvider(new BouncyCastleProvider());
        //Symmetric cryptography
        //Crypto.crypt();

        /*// BMAIL
        User.getInstance().getContact().setEmail("user@email.com");
        User.getInstance().getContact().setHost("smtp.gmail.com");//smtp.gmail.com,com.sun.mail
        User.getInstance().addEmail(new BMessage("this is the text thing",User.getInstance().getContact(),new Contact("Bob","Bob@bobberson.com","the key?"),"this is the subject"));
        // END */

        //PublicKey  pk = (PublicKey) KeyPairHandler.getInstance().getPublicKey("data/Baeldung.cer");
        X509Certificate cert = KeyPairHandler.getInstance().getPublicKey("data/Baeldung.cer");
        PublicKey publicKey = cert.getPublicKey();

        byte[] encryptedBytes = Baeldung.getInstance().encrypt("hello world", cert);

        System.out.println(encryptedBytes);
        String s = new String(encryptedBytes);
        System.out.println(s);

        //RSAEncryptionHandler.getInstance().encrypt("hello world", publicKey);

        // LAUNCH APPLICATION
        launch();
        // END
    }
}
