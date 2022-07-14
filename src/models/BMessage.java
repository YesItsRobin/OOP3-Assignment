package src.models;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.sun.mail.smtp.SMTPMessage;
import javax.mail.internet.MimeMessage;

// API doc
// https://javaee.github.io/javamail/docs/api/

public class BMessage {
    private Contact sender;
    private Contact receiver;
    private Message msg;
    String mailhost;

    String prot = "smtp";
    String mailer = "smtpsend";

    public BMessage(String text, Contact sender, Contact receiver, String subject) throws MessagingException {
        this.sender=sender;
        this.receiver=receiver;
        this.mailhost=sender.getHost();
        createMsg();

        msg.setFrom(new InternetAddress(sender.getEmail()));
        msg.setText(text);
        msg.setRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(receiver.getEmail()));
        msg.setSubject(subject);

    }

    private void createMsg() {
        //Properties props = new Properties();
        Properties props = System.getProperties();
        System.out.println("HELLO: " + prot);
        props.put("mail." + prot + ".host", mailhost );
        Session session = Session.getDefaultInstance(props, null);
        this.msg = new MimeMessage(session);
    }

    public BMessage(javax.mail.Message message) throws MessagingException, IOException {
        msg=message;
        this.sender=null;
        this.receiver=null;
        this.mailhost=null;
    }


    public void send() throws MessagingException {
        //it is first signed using the private key of the user
        //Key privatekey = User.getInstance().getPrivatekey();


        //then encrypted using the public key of the receiver
        //Key publickey = receiver.getPublickeyCertificate();


        //Initialize the JavaMail Session.
        Properties props = System.getProperties();
        props.put("mail." + prot + ".host", mailhost);

	    /*


	    *DON'T THINK THIS IS NEEDED


	    *
	     * Create a Provider representing our extended SMTP transport
	     * and set the property to use our provider.
	     *
	    Provider p = new Provider(Provider.Type.TRANSPORT, prot,
		"smtpsend$SMTPExtension", "JavaMail demo", "no version");
	    props.put("mail." + prot + ".class", "smtpsend$SMTPExtension");
	     */

        // Get a Session object
        Session session = Session.getInstance(props, null);

	    /*
	     * Register our extended SMTP transport.
	     *
	    session.addProvider(p);
	     */

        //Construct the message and send it.
        getMsg().setHeader("B-Mailer", mailer);
        getMsg().setSentDate(new Date());
        // send it
        Transport.send(getMsg());
    }

    public void receive() {
        //it is stored on permanent storage (hard disk) in its encrypted form

        //When reading it the application first decrypts it using the private key of the user
        //Key privatekey = User.getInstance().getPrivatekey();

        //then decrypted using the public key of the sender
        //Key publickey = sender.getPublickeyCertificate();
    }

    private void encrypt(Key publickey) throws MessagingException {
        //it is encrypted using the public key of the receiver
        String encrypted = "";
        getMsg().setText(encrypted);
    }

    private void decrypt(Key privatekey) throws MessagingException {
        //it is decrypted using the private key of the user
        String decrypted = "";
        getMsg().setText(decrypted);
    }

    private void sign(Key privatekey) throws MessagingException {
        //it is signed using the private key of the sender
        String signed = "";
        getMsg().setText(signed);
    }

    private void checkSignature(Key publickey) throws MessagingException {
        //it is checked using the public key of the sender
        String checked = "";
        getMsg().setText(checked);
    }

    @Override
    public String toString() {
        return ""; //TO-DO
    }

    public javax.mail.Message getMsg() {
        return msg;
    }

    public Contact getSender() throws MessagingException {
        return sender;
    }

    public Contact getReceiver() throws MessagingException {
        return receiver;
    }

    public void setReceiver(Contact receiver) throws MessagingException {
        getMsg().setFrom(new InternetAddress(receiver.getEmail()));
    }

    public String getSubject() throws MessagingException {
        return getMsg().getSubject();
    }

    public void setSubject(String subject) throws MessagingException {
        getMsg().setSubject(subject);
    }

}
