package model;

public class ModelManager implements Model{
    private Client client1 = new Client();

    @Override
    public void logIn(String username, String password) {
    client1.logIn(username,password);
    }

    @Override
    public void logOut() {
    }

}
