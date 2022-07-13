package src.models;

public class Contact {
    private String name;
    private String email;
    private String publicKeyCertificate;
    private String ip;
    private String port;
    private String host;

    public Contact(String name, String email, String publicKeyCertificate, String ip, String port, String host) {
        this.name = name;
        this.email = email;
        this.publicKeyCertificate = publicKeyCertificate;
        this.ip = ip;
        this.port = port;
        this.host = host;
    }

    public Contact(String name, String email, String publicKeyCertificate) {
        this(name, email, publicKeyCertificate, null, null, null);
    }


    public Contact(){
        this(null, null, null, null, null, null);
    }

    @Override
    public String toString() {
        return name +"     " + email;
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

    public String getPublicKeyCertificate() {
        return publicKeyCertificate;
    }

    public void setPublicKeyCertificate(String publicKeyCertificate) {
        this.publicKeyCertificate = publicKeyCertificate;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
