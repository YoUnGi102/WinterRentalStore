package dk.via.client.viewModel;

import dk.via.client.model.Model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LogInViewModel {

    private final Model model;

    public LogInViewModel(Model model){
        this.model=model;
    }

    public boolean logIn(String username, String password) throws NotBoundException, RemoteException {
        return model.logIn(username, password);
    }
}
