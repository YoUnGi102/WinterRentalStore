package dk.via.client.model;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteModel extends Remote {

    boolean logIn(RemoteModel clientI, String username, String password) throws RemoteException;
    void logOut(RemoteModel clientI) throws RemoteException;

    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException;
    void addCustomer(Customer customer) throws RemoteException, NotBoundException;
    void removeCustomer(Customer customer) throws RemoteException, NotBoundException;
    Item getItemById(int itemId) throws RemoteException, NotBoundException;
    void addItem(Item item) throws RemoteException, NotBoundException;
    void removeItem(Item item) throws RemoteException, NotBoundException;

}
