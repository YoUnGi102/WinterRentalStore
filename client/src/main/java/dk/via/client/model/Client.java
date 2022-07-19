package dk.via.client.model;

import java.io.Serial;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements RemoteModel {

    @Serial
    private static final long serialVersionUID = 1L;
    private final RemoteModel server;
    
    public Client(RemoteModel server) throws RemoteException {
        this.server = server;
    }

    @Override
    public boolean logIn(RemoteModel client, String username, String password) throws RemoteException {
        return server.logIn(this, username, password);
    }

    @Override
    public void logOut(RemoteModel client) throws RemoteException {
        server.logOut(this);
    }

    @Override
    public Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException {
        return server.getCustomerByPassport(passportNumber);
    }

    @Override
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException {
        server.addCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException {
        server.removeCustomer(customer);
    }

    @Override
    public Item getItemById(int itemId) throws RemoteException, NotBoundException {
        return server.getItemById(itemId);
    }

    @Override
    public void addItem(Item item) throws RemoteException, NotBoundException {
        server.addItem(item);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException {
        server.removeItem(item);
    }
}

