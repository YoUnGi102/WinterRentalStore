package dk.via.client.model;

import dk.via.client.model.RemoteModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ModelManager implements Model {

    public static final int PORT = 1039;

    private Client client;

    public ModelManager(){

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
        return client.getCustomerByPassport(passportNumber);
    }

    @Override
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException {
        client.addCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException {
        client.removeCustomer(customer);
    }

    @Override
    public Item getItemById(int itemId) throws RemoteException, NotBoundException {
        return client.getItemById(itemId);
    }

    @Override
    public void addItem(Item item) throws RemoteException, NotBoundException {
        client.addItem(item);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException {
        client.removeItem(item);
    }

}