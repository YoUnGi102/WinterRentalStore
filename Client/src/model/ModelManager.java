package model;

import mediator.RemoteModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ModelManager implements Model{

    private Staff staff;
    private RemoteModel server;

    public ModelManager(RemoteModel server){
        this.server = server;
        this.staff = null;
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException, IllegalStateException {
        staff = server.logIn(username, password);
        return staff != null;
    }
    @Override
    public void logOut() throws RemoteException, SQLException {
        server.logOut();
    }
    @Override
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException {
        server.addCustomer(customer);
    }
    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException {
        server.removeCustomer(customer);
    }
    @Override
    public ArrayList<Customer> getCustomers(String keyWord) throws RemoteException, NotBoundException, SQLException {
        return server.getCustomers(keyWord);
    }
    @Override
    public ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException {
        return server.getItems(start, end, type, minSize, maxSize, minPrice, maxPrice);
    }
    @Override
    public void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException {
        server.addItem(item, numberOfPieces);
    }
    @Override
    public void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException {
        server.addType(type, sizeUnit);
    }
    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException, SQLException {
        server.removeItem(item);
    }
    @Override
    public ArrayList<String> getItemTypes() throws RemoteException, SQLException {
        return server.getItemTypes();
    }
    @Override
    public HashMap<String, String> getTypeUnitPairs() throws RemoteException, SQLException {
        return server.getTypeUnitPairs();
    }
    @Override
    public ArrayList<Staff> getAllStaff() throws RemoteException, NotBoundException, SQLException {
        return server.getEmployees();
    }
    @Override
    public void addStaff(Staff employee) throws RemoteException, NotBoundException, SQLException {
        server.addEmployee(employee);
    }
    @Override
    public void removeStaff(Staff employee) throws RemoteException, NotBoundException, SQLException {
        server.removeEmployee(employee);
    }
    @Override
    public void addRent(Rent rent) throws SQLException, NotBoundException, RemoteException {
        server.addRent(rent);
    }
    @Override
    public Staff getStaff() {
        return staff;
    }
}
