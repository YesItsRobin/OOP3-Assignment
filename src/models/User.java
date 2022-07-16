package src.models;

import java.security.PrivateKey;
import java.util.ArrayList;

public class User {
    private String privatekey;  //NEEDS TO BECOME A KEY OBJECT BUT I CAN'T FIGURE OUT HOW TO CREATE ONE
    private String password;
    private Contact contact;
    private ArrayList<Contact> contacts;
    private ArrayList<BMessage> emailList;

    private static User user;

    private User() {
        this.password = null;
        this.privatekey = null;
        this.contact = new Contact();
        this.contacts = new ArrayList<>();
        contacts.add(new Contact("John", "john@upcmail.nl","key123"));
        this.emailList = new ArrayList<>();
    }

    public static User getInstance(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact){
        this.contacts.remove(contact);
    }

    public ArrayList<BMessage> getEmails() {
        return emailList;
    }
    public void addEmail(BMessage email){
        //TO-DO
        //write to file
        this.emailList.add(email);
    }
}
