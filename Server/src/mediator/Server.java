package mediator;

import javafx.collections.ObservableList;
import model.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
            UnicastRemoteObject.exportObject(this, 1099);
        } catch (RemoteException e) {
            System.out.println("Object already exported");
        }
        Naming.rebind("RMIServer", this);
        System.out.println("Starting server...");
    }
    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException {
        // TODO ADD Client Connection
        if (model.logIn(username, password)) {
            System.out.println("User " + username + " successfully logged in");
            return true;
        } else {
            System.out.println("User " + username + " was refused access");
            return false;
        }
    }
    @Override
    public void logOut() throws RemoteException {
        // TODO REMOVE CLIENT
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
    public ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException {
        return model.getItems(start, end, type, minSize, maxSize, minPrice, maxPrice);
    }
    @Override
    public Item getItemById(int itemId) throws RemoteException, NotBoundException {
        return model.getItemById(itemId);
    }

    @Override
    public void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException {
        model.addItem(item, numberOfPieces);
    }

    @Override
    public void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException {
        model.addType(type, sizeUnit);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException, SQLException {
        model.removeItem(item);
    }

    @Override
    public ArrayList<String> getItemTypes() throws RemoteException, SQLException {
        return model.getItemTypes();
    }

    @Override
    public HashMap<String, String> getTypeUnitPairs() throws RemoteException, SQLException {
        return model.getTypeUnitPairs();
    }

    @Override
    public ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException {
        return model.getEmployees();
    }

    @Override
    public ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException {
        return model.getEmployeesByType(type);
    }

    @Override
    public Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException {
        return model.getEmployeeByUsername(username);
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException, NotBoundException {
        model.addEmployee(employee);
    }

    @Override
    public void removeEmployee(Employee employee) throws RemoteException, NotBoundException {
        model.removeEmployee(employee);
    }
}
