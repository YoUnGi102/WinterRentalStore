package com.example.winterrentalstore.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface Model {
    boolean logIn(String username, String password) throws RemoteException, NotBoundException;
    void logOut();

    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException;
    void addCustomer(Customer customer) throws RemoteException, NotBoundException;
    void removeCustomer(Customer customer) throws RemoteException, NotBoundException;
    Item getItemById(int itemId) throws RemoteException, NotBoundException;
    void addItem(Item item) throws RemoteException, NotBoundException;
    void removeItem(Item item) throws RemoteException, NotBoundException;
}
