package Classes;

public class User {

    protected String userName;
    protected String password;

    public User() {
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
