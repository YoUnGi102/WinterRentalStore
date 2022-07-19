package dk.via.server;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteModel {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ArrayList<RemoteModel> clients;

    protected Server() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public boolean logIn(RemoteModel client, String username, String password) throws RemoteException{
        // TODO ADD CHECKING FOR CREDENTIALS
        if(true){
            clients.add(client);
            System.out.println("User " + username + " successfully logged in");
            return true;
        }else{
            System.out.println("User " + username + " was refused access");
            return false;
        }
    }

    @Override
    public void logOut(RemoteModel client) throws RemoteException {
        clients.remove(client);
    }
}
