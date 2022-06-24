package src.models;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class Key {
    private PublicKey publickey;
    private PrivateKey privatekey;
    private Certificate certificate;
    private String password;

    public Key(PublicKey publickey, PrivateKey privatekey, Certificate certificate, String password) {
        this.publickey = publickey;
        this.privatekey = privatekey;
        this.certificate = certificate;
        this.password = password;
    }

    public PublicKey getPublickey() {
        return publickey;
    }

    public void setPublickey(PublicKey publickey) {
        this.publickey = publickey;
    }

    public PrivateKey getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(PrivateKey privatekey) {
        this.privatekey = privatekey;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
