package com.example.winterrentalstore.model;

import com.example.winterrentalstore.server.Server;
import com.example.winterrentalstore.server.ServerI;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientI{

    @Serial
    private static final long serialVersionUID = 1L;
    private final ServerI server;
    
    public Client(ServerI server) throws RemoteException {
        this.server = server;
    }

    @Override
    public boolean logIn(ClientI client, String username, String password) throws RemoteException {
        return server.logIn(client, username, password);
    }

    @Override
    public void logOut(ClientI client) throws RemoteException {
        server.logOut(client);
    }
}

