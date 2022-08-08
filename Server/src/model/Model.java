package model;

import javafx.collections.ObservableList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
public interface Model {

    // LOGIN
    boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException;
    void logOut();

    // MANAGE ITEM AND TYPES
    void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException;
    void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException;
    void removeItem(Item item) throws RemoteException, NotBoundException, SQLException;
    ArrayList<String> getItemTypes() throws RemoteException, SQLException;
    HashMap<String, String> getTypeUnitPairs() throws RemoteException, SQLException;
    ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException;

    // MANAGE CUSTOMER
    void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;
    void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;

    ArrayList<Customer> getCustomers(String keyWord) throws RemoteException, NotBoundException, SQLException;

    // EMPLOYEES
    ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException;

    ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException;

    Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException;

    void addEmployee(Employee employee) throws RemoteException, NotBoundException;

    void removeEmployee(Employee employee) throws RemoteException, NotBoundException;

    void addRent(Rent rent) throws RemoteException, NotBoundException, SQLException;
}
