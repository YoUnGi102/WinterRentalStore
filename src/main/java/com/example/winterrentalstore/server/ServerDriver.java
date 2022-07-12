package com.example.winterrentalstore.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerDriver {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        int port = 5099;
        ServerI server = new Server();
        Registry registry = LocateRegistry.createRegistry(port);
        Remote exported = UnicastRemoteObject.exportObject(server, port);
        registry.bind("server", exported);
        System.out.println("Server running on port " + port);
    }

}
