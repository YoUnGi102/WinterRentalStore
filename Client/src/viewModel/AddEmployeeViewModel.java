package viewModel;

import model.Model;
import model.Staff;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddEmployeeViewModel {

    private Model model;

    AddEmployeeViewModel(Model model){
        this.model = model;
    }

    public void addStaff(Staff staff, String password) throws SQLException, NotBoundException, RemoteException {
        model.addStaff(staff, password);
    }

}
