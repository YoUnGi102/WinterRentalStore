package mediator;

import model.*;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public interface RemoteModel extends Remote {
    Staff logIn(String username, String password) throws RemoteException, NotBoundException, SQLException, IllegalStateException;
    void logOut() throws RemoteException, SQLException;
    void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;
    void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;
    ArrayList<Customer> getCustomers(String keyWord) throws RemoteException, NotBoundException, SQLException;
    ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException;
    void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException;
    void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException;
    void removeItem(Item item) throws RemoteException, NotBoundException, SQLException;
    ArrayList<String> getItemTypes() throws RemoteException, SQLException;
    HashMap<String, String> getTypeUnitPairs() throws RemoteException, SQLException;
    ArrayList<Staff> getEmployees() throws RemoteException, NotBoundException, SQLException;
    ArrayList<Staff> getEmployeesByType(String type) throws RemoteException, NotBoundException, SQLException;
    Staff getEmployeeByUsername(String username) throws RemoteException, NotBoundException, SQLException;
    void addEmployee(Staff employee) throws RemoteException, NotBoundException, SQLException;
    void removeEmployee(Staff employee) throws RemoteException, NotBoundException, SQLException;
    void addRent(Rent rent) throws SQLException, NotBoundException, RemoteException;
}