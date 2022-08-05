package viewModel;

import mediator.RemoteModel;
import model.Customer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddCustomerViewModel {

    private RemoteModel model;

    public AddCustomerViewModel(RemoteModel model){
        this.model = model;
    }

    public void addCustomer(Customer customer) throws SQLException, NotBoundException, RemoteException {
        model.addCustomer(customer);
    }

}
