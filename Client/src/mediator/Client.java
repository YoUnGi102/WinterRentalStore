package mediator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject {

    private static final long serialVersionUID = 1L;
    private final RemoteModel server;
    public Client(RemoteModel server) throws RemoteException {
        this.server = server;
    }

}

