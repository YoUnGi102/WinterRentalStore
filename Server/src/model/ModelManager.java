package model;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelManager implements Model {

    private CustomerList customerList;
    private ItemList itemList;

    public ModelManager() {
        customerList = new CustomerList();
        itemList = new ItemList();
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException, NotBoundException {
        // TODO
        return false;
    }

    @Override
    public void logOut() {
        // TODO
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
    public void addItem(Item item) throws RemoteException, NotBoundException {
        itemList.addItem(item);
    }

    @Override
    public void removeItem(Item item) throws RemoteException, NotBoundException {
        itemList.removeItem(item);
    }

}
