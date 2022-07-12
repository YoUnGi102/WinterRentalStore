package com.example.winterrentalstore.model;

import java.rmi.RemoteException;

public interface ClientI {

    boolean logIn(ClientI client, String username, String password) throws RemoteException;
    void logOut(ClientI client) throws RemoteException;

}
