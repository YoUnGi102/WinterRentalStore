package model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Model {
    boolean logIn(String username, String password) throws RemoteException, NotBoundException;

    void logOut();

    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException;

    void addCustomer(Customer customer) throws RemoteException, NotBoundException;

    void removeCustomer(Customer customer) throws RemoteException, NotBoundException;

    Item getItemById(int itemId) throws RemoteException, NotBoundException;

    void addItem(Item item) throws RemoteException, NotBoundException;

    void removeItem(Item item) throws RemoteException, NotBoundException;

    ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException;

    ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException;

    Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException;

    void addEmployee(Employee employee) throws RemoteException, NotBoundException;

    void removeEmployee(Employee employee) throws RemoteException, NotBoundException;
}
