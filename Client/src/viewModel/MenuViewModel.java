package viewModel;

import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class MenuViewModel implements PropertyChangeListener {

    private Model model;

    public MenuViewModel(Model model){
        this.model = model;
    }

    public void logOut() throws SQLException, RemoteException {
        model.logOut();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
