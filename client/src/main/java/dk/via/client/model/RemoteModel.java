package dk.via.client.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteModel extends Remote {

    boolean logIn(RemoteModel clientI, String username, String password) throws RemoteException;
    void logOut(RemoteModel clientI) throws RemoteException;

}
