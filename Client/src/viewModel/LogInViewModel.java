package viewModel;

import mediator.RemoteModel;
import model.Model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class LogInViewModel {
    private final Model model;
    public LogInViewModel(Model model) {
        this.model = model;
    }
    public boolean logIn(String username, String password) throws NotBoundException, RemoteException, SQLException, IllegalStateException {
        return model.logIn(username, password);
    }
}
