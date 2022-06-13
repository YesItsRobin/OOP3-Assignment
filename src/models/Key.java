package src.models;

public class Key {
    private Key publickey;
    private Key privatekey;
    private String certificate;
    private String password;

    public Key(Key publickey, Key privatekey, String certificate, String password) {
        this.publickey = publickey;
        this.privatekey = privatekey;
        this.certificate = certificate;
        this.password = password;
    }



    public Key getPublickey() {
        return publickey;
    }

    public void setPublickey(Key publickey) {
        this.publickey = publickey;
    }

    public Key getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(Key privatekey) {
        this.privatekey = privatekey;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
