package src.models;

public class User {
    private String privatekey;  //NEEDS TO BECOME A KEY OBJECT BUT I CAN'T FIGURE OUT HOW TO CREATE ONE
    private String password;
    private Contact contact;

    private static User user;

    private User() {
        this.password = null;
        this.privatekey = null;
        this.contact = new Contact();
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
}
