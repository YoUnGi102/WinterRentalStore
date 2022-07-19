package viewModel;

import mediator.RemoteModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LogInViewModel {

    private final RemoteModel model;

    public LogInViewModel(RemoteModel model) {
        this.model = model;
    }

    public boolean logIn(String username, String password) throws NotBoundException, RemoteException {
        return model.logIn(username, password);
    }
}
