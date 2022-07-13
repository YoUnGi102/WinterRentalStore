package com.example.winterrentalstore.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface Model {
    boolean logIn(String username, String password) throws RemoteException, NotBoundException;
    void logOut();
}
