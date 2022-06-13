package src.models;

public class User {
    private Key privatekey;
    private String password;

    private static User user;

    private User() {
        this.password = null;
        this.privatekey = null;
    }

    public static User getInstance(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public Key getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(Key privatekey) {
        this.privatekey = privatekey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
