package model;


import databaseAdapters.*;
import javafx.collections.ObservableList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;

public class ModelManager implements Model {

    private CustomerList customerList;
    private ItemList itemList;

    private EmployeeList employeeList;

    private StaffDAO staffDAO;
    private TypeDAO typeDAO;
    private ItemDAO itemDAO;
    private Staff currentUser;
    
    public ModelManager() {
        staffDAO = new StaffImplementation();
        itemDAO = new ItemImplementation();
        typeDAO = new TypeImplementation();

        customerList = new CustomerList();
        itemList = new ItemList();
        employeeList = new EmployeeList();
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException {
        currentUser = staffDAO.logIn(username, password);
        return currentUser != null;
        // TODO ADD EXCEPTION IF WRONG PASSWORD
    }
    @Override
    public void logOut() {
        // TODO
    }

    @Override
    public void addType(String type, String sizeUnit) throws RemoteException, NotBoundException, SQLException {
        typeDAO.insert(type,sizeUnit);
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
    public void addItem(Item item, int numberOfPieces) throws RemoteException, NotBoundException, SQLException {
        itemDAO.insert(item, numberOfPieces);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException, SQLException {
        itemDAO.delete(item);
    }

    @Override
    public ArrayList<String> getItemTypes() throws SQLException {
        return typeDAO.selectTypes();
    }

    @Override
    public HashMap<String, String> getTypeUnitPairs() throws SQLException {
        return typeDAO.selectTypeUnitPairs();
    }
    @Override
    public ArrayList<Item> getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws RemoteException, NotBoundException, SQLException {
        return itemDAO.select(start, end, type, minSize, maxSize, minPrice, maxPrice);
    }
    @Override
    public ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException {
        return employeeList.getEmployees();
    }

    @Override
    public ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException {
        return employeeList.getEmployeesByType(type);
    }

    @Override
    public Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException {
        return employeeList.getEmployeeByUsername(username);
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException, NotBoundException {
        employeeList.addEmployee(employee);
    }

    @Override
    public void removeEmployee(Employee employee) throws RemoteException, NotBoundException {
        employeeList.removeEmployee(employee);
    }

}
