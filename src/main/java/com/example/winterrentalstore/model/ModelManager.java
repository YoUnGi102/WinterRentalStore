package com.example.winterrentalstore.model;

import com.example.winterrentalstore.server.ServerI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ModelManager implements Model{

    public static final int PORT = 1039;

    private Client client;

    public ModelManager(){

    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", PORT);
        ServerI server = (ServerI) registry.lookup("RMIServer");
        client = new Client(server);
        // TODO (STAFF OBJECT)
        return client.logIn(username, password);
    }

    @Override
    public void logOut() {
    }

}
