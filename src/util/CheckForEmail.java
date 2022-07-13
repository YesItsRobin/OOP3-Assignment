package src.util;

//Needs to become it's own thread
//Checks every 10 minutes

import src.models.BMessage;
import src.models.Contact;
import src.models.User;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class CheckForEmail extends Thread {

    private String host;
    private String username;
    private String password;

    public CheckForEmail() {
        this(User.getInstance().getContact().getHost(),User.getInstance().getContact().getEmail(), User.getInstance().getPassword());
    }

    private CheckForEmail(String host, String username, String password) {
        this.host=host;
        this.username=username;
        this.password=password;
    }


    public void run(){
        //infinite loop
        while(true){
            try {
                Thread.sleep(600000); //10 mins.. I think
                check();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void check(){
        Folder folder = null;
        Store store = null;
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "pop3"); // Google uses POP3S not POP3
            Session session = Session.getDefaultInstance(props);
            // session.setDebug(true);
            store = session.getStore();
            store.connect(host, username, password);
            folder = store.getDefaultFolder().getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message[] messages = folder.getMessages();
            for (Message message:messages){
                User.getInstance().addEmail(new BMessage(message));
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (folder != null) {
                try {
                    folder.close(true);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
            if (store != null) {
                try {
                    store.close();
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
