package back.bean;

public class User {
    int id;
    String name;
    String password;
    String xingming;
    String email;

    public User() {
    }

    public User(int id, String name, String password, String xingming, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.xingming = xingming;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
