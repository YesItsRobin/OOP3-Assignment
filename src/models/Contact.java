package src.models;

public class Contact {
    private String name;
    private String email;
    private Key publickeyCertificate;
    private String ip;
    private String port;
    private String smtp;

    public Contact(String name, String email, Key publickeyCertificate, String ip, String port, String smtp) {
        this.name = name;
        this.email = email;
        this.publickeyCertificate = publickeyCertificate;
        this.ip = ip;
        this.port = port;
        this.smtp = smtp;
    }

    public Contact(String name, String email, Key publickeyCertificate) {
        this(name, email, publickeyCertificate, null, null, null);
    }

    public Contact(){
        this(null, null, null, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Key getPublickeyCertificate() {
        return publickeyCertificate;
    }

    public void setPublickeyCertificate(Key publickeyCertificate) {
        this.publickeyCertificate = publickeyCertificate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }
}
