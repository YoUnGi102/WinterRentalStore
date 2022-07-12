package com.example.winterrentalstore.server;

import com.example.winterrentalstore.model.Client;
import com.example.winterrentalstore.model.ClientI;

import java.io.Serial;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerI {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ArrayList<ClientI> clients;

    protected Server() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public boolean logIn(ClientI client, String username, String password) throws RemoteException{
        // TODO ADD CHECKING FOR CREDENTIALS
        if(true){
            clients.add(client);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void logOut(ClientI client) throws RemoteException {
        clients.remove(client);
    }
}
