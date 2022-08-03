package viewModel;

import mediator.RemoteModel;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MenuViewModel {

    private RemoteModel model;

    public MenuViewModel(RemoteModel model){
        this.model = model;
    }

    public void logOut() throws SQLException, RemoteException {
        model.logOut();
    }

}
