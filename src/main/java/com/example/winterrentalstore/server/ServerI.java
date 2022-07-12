package com.example.winterrentalstore.server;

import com.example.winterrentalstore.model.ClientI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerI extends Remote {

    boolean logIn(ClientI clientI, String username, String password) throws RemoteException;
    void logOut(ClientI clientI) throws RemoteException;

}
