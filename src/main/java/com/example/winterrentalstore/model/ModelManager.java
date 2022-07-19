package com.example.winterrentalstore.model;

import dk.via.client.model.RemoteModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ModelManager implements Model {

    public static final int PORT = 1039;

    private Client client;
    private CustomerList customerList;
    private ItemList itemList;

    public ModelManager() {
        this.client = null;
        this.customerList = new CustomerList();
        this.itemList = new ItemList();

    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", PORT);
        RemoteModel server = (RemoteModel) registry.lookup("RMIServer");
        client = new Client(server);
        // TODO (STAFF OBJECT)
        return client.logIn(client, username, password);
    }

    @Override
    public void logOut() {
    }

    @Override
    public Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException {
        return customerList.getCustomerByPassport(passportNumber);
    }

    @Override
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException {
        customerList.addCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException {
        customerList.removeCustomer(customer);
    }

    @Override
    public Item getItemById(int itemId) throws RemoteException, NotBoundException {
        return itemList.getItemById(itemId);
    }

    @Override
    public void addItem(Item item) throws RemoteException, NotBoundException {
        itemList.addItem(item);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException {
        itemList.removeItem(item);
    }

}
