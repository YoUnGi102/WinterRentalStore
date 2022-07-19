package dk.via.client.model;

import dk.via.server.RemoteModel;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements RemoteModel{

    @Serial
    private static final long serialVersionUID = 1L;
    private final RemoteModel server;
    
    public Client(RemoteModel server) throws RemoteException {
        this.server = server;
    }

    @Override
    public boolean logIn(RemoteModel client, String username, String password) throws RemoteException {
        return server.logIn(this, username, password);
    }

    @Override
    public void logOut(RemoteModel client) throws RemoteException {
        server.logOut(this);
    }
}

