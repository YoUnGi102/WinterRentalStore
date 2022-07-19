package mediator;

import model.Customer;
import model.Item;
import model.Model;
import model.ModelManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteModel {

    private static final long serialVersionUID = 1L;
    private static final int PORT = 1099;

    private final ArrayList<RemoteModel> clients;
    private Model model;

    public Server() throws RemoteException, NotBoundException, MalformedURLException {
        clients = new ArrayList<>();
        startRegistry();
        model = new ModelManager();
    }

    private void startRegistry() throws RemoteException, MalformedURLException {
        Registry registry = LocateRegistry.createRegistry(PORT);
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            System.out.println("Object already exported");
        }
        Naming.rebind("RMIServer", this);
        System.out.println("Starting server...");
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException {
        // TODO ADD CHECKING FOR CREDENTIALS
        if (true) {
            model.logIn(username, password);
            System.out.println("User " + username + " successfully logged in");
            return true;
        } else {
            System.out.println("User " + username + " was refused access");
            return false;
        }
    }

    @Override
    public void logOut(RemoteModel client) throws RemoteException {
        clients.remove(client);
    }

    @Override
    public Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException {
        return model.getCustomerByPassport(passportNumber);
    }

    @Override
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException {
        model.addCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException {
        model.removeCustomer(customer);
    }

    @Override
    public Item getItemById(int itemId) throws RemoteException, NotBoundException {
        return model.getItemById(itemId);
    }

    @Override
    public void addItem(Item item) throws RemoteException, NotBoundException {
        model.addItem(item);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException {
        model.removeItem(item);
    }
}
