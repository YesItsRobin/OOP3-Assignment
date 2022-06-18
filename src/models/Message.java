package src.models;

import java.time.LocalDateTime;

public class Message {
    private String body;
    private Contact sender;
    private Contact receiver;
    private String title;
    private LocalDateTime date;

    public Message(String body, Contact sender, Contact receiver, String title) {
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.date = null;
    }


    public void send() {
        setDate(LocalDateTime.now());
        //it is first signed using the private key of the user
        //Key privatekey = User.getInstance().getPrivatekey();

        //then encrypted using the public key of the receiver
        //Key publickey = receiver.getPublickeyCertificate();
    }

    public void receive() {
        //it is stored on permanent storage (hard disk) in its encrypted form

        //When reading it the application first decrypts it using the private key of the user
        //Key privatekey = User.getInstance().getPrivatekey();

        //then decrypted using the public key of the sender
        //Key publickey = sender.getPublickeyCertificate();
    }

    private void encrypt(Key publickey) {
        //it is encrypted using the public key of the receiver
        String encrypted="";
        setBody(encrypted);
    }

    private void decrypt(Key privatekey) {
        //it is decrypted using the private key of the user
        String decrypted = "";
        setBody(decrypted);
    }

    private void sign(Key privatekey) {
        //it is signed using the private key of the sender
        String signed = "";
        setBody(signed);
    }

    private void checkSignature(Key publickey) {
        //it is checked using the public key of the sender
        String checked = "";
        setBody(checked);
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Contact getReceiver() {
        return receiver;
    }

    public void setReceiver(Contact receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
