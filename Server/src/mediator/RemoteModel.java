package mediator;

import model.Customer;
import model.Item;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RemoteModel extends Remote {

    boolean logIn(String username, String password) throws RemoteException, NotBoundException, SQLException;

    void logOut(RemoteModel clientI) throws RemoteException;

    Customer getCustomerByPassport(int passportNumber) throws RemoteException, NotBoundException;

    void addCustomer(Customer customer) throws RemoteException, NotBoundException;

    void removeCustomer(Customer customer) throws RemoteException, NotBoundException;

    Item getItemById(int itemId) throws RemoteException, NotBoundException;

    void addItem(Item item) throws RemoteException, NotBoundException;

    void removeItem(Item item) throws RemoteException, NotBoundException;

}
