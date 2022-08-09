package viewModel;

import model.Model;
import model.Staff;

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

    public Staff getStaff(){
        return model.getStaff();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
