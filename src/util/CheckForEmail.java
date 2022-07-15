package src.util;

//Needs to become it's own thread
//Checks every 10 minutes

import src.models.BMessage;
import src.models.Contact;
import src.models.User;

import javax.mail.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;

public class CheckForEmail implements Runnable {

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
        System.out.println("start check for email");
        //infinite loop
        while(host!=null){
            try {
                check();
                System.out.println("Checked for emails");
                Thread.sleep(600000); //10 mins.. I think
                //Thread.sleep(5000); //5 sec.. I think
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void check() throws IOException {
        if (User.getInstance().hasValidIp()){
            //email throught sockets?
        }
        else {
            Folder folder = null;
            Store store = null;
            try {
                Properties properties = System.getProperties();
                Session session = Session.getDefaultInstance(properties);
                store = session.getStore("pop3");
                // session.setDebug(true);
                store = session.getStore();
                store.connect(host, username, password);
                folder = store.getDefaultFolder().getFolder("INBOX");
                folder.open(Folder.READ_ONLY);
                Message[] messages = folder.getMessages();
                for (Message message : messages) {
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

}
