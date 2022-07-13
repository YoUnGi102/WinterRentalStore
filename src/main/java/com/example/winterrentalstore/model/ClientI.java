package com.example.winterrentalstore.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientI extends Remote {

    boolean logIn(String username, String password) throws RemoteException;
    void logOut() throws RemoteException;

}
