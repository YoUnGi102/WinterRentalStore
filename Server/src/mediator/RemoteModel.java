package mediator;

import javafx.collections.ObservableList;
import model.Customer;
import model.Employee;
import model.Item;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public interface RemoteModel extends Remote {

    boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException;
    void logOut() throws RemoteException, SQLException;
    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException, SQLException;
    void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;
    void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;

    ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException;
    Item getItemById(int itemId) throws RemoteException, NotBoundException, SQLException;
    void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException;
    void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException;
    void removeItem(Item item) throws RemoteException, NotBoundException, SQLException;
    ArrayList<String> getItemTypes() throws RemoteException, SQLException;
    HashMap<String, String> getTypeUnitPairs() throws RemoteException, SQLException;

    ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException, SQLException;

    ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException, SQLException;

    Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException, SQLException;

    void addEmployee(Employee employee) throws RemoteException, NotBoundException, SQLException;

    void removeEmployee(Employee employee) throws RemoteException, NotBoundException, SQLException;
}
