package model;

public class Client {
    private String username;
    private String password;

    public void logIn(String username, String password){
        this.username=username;
        this.password=password;
    }
}
