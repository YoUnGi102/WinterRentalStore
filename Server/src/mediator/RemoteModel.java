package mediator;

import model.Customer;
import model.Employee;
import model.Item;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RemoteModel extends Remote {

    void test() throws RemoteException;
    boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException;

    void logOut(RemoteModel clientI) throws RemoteException, SQLException;

    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException, SQLException;

    void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;

    void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException;

    Item getItemById(int itemId) throws RemoteException, NotBoundException, SQLException;

    void addItem(Item item) throws RemoteException, NotBoundException, SQLException;

    void removeItem(Item item) throws RemoteException, NotBoundException, SQLException;

    ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException, SQLException;

    ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException, SQLException;

    Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException, SQLException;

    void addEmployee(Employee employee) throws RemoteException, NotBoundException, SQLException;

    void removeEmployee(Employee employee) throws RemoteException, NotBoundException, SQLException;
}
