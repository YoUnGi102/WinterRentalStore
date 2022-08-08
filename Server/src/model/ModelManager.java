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

    private CustomerDAO customerDao;
    private StaffDAO staffDAO;
    private TypeDAO typeDAO;
    private ItemDAO itemDAO;
    private Staff currentUser;

    private RentDAO rentDAO;
    public ModelManager() {
        staffDAO = new StaffImplementation();
        itemDAO = new ItemImplementation();
        typeDAO = new TypeImplementation();
        customerDao = new CustomerImplementation();
        rentDAO = new RentImplementation();
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
    public void addCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException {
        customerDao.insert(customer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException, NotBoundException, SQLException {
        customerDao.delete(customer);
    }

    @Override
    public ArrayList<Customer> getCustomers(String keyWord) throws RemoteException, NotBoundException, SQLException {
        return customerDao.select(keyWord);
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
        return null;
    }

    @Override
    public ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException {
        return null;
    }

    @Override
    public Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException, NotBoundException {

    }

    @Override
    public void removeEmployee(Employee employee) throws RemoteException, NotBoundException {

    }

    @Override
    public void addRent(Rent rent) throws RemoteException, NotBoundException, SQLException {
        rentDAO.insert(rent);
    }
}
