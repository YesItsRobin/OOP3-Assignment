package src.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class KeyPairHandler {
    private static KeyPairHandler keyPairHandler;

    public static KeyPairHandler getInstance(){
        if(keyPairHandler == null){
            keyPairHandler = new KeyPairHandler();
        }
        return keyPairHandler;
    }

    public X509Certificate getPublicKey(String certFileLocation) throws
            CertificateException,
            NoSuchProviderException,
            FileNotFoundException
    {
        CertificateFactory certificateFactory =
                CertificateFactory.getInstance("X.509", "BC");
        X509Certificate certificate = (X509Certificate) certificateFactory.
                generateCertificate(new FileInputStream(certFileLocation));
        return certificate;
    }

    public PrivateKey getPrivateKey(String pass) throws
            KeyStoreException,
            IOException,
            UnrecoverableKeyException,
            NoSuchAlgorithmException,
            CertificateException
    {
        char[] keystorePassword = pass.toCharArray();
        char[] keyPassword = pass.toCharArray();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new FileInputStream("data/Baeldung.p12"), keystorePassword);

        PrivateKey key = (PrivateKey) keyStore.getKey("baeldung", keyPassword);
        return key;
    }
}


/* CERTIFICATION

*/