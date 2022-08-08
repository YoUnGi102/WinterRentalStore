package viewModel;

import mediator.RemoteModel;
import model.Customer;
import view.FilterItemsViewController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddCustomerViewModel {

    private RemoteModel model;

    private PropertyChangeListener listener;
    public AddCustomerViewModel(RemoteModel model){
        this.model = model;
    }

    public void setRentViewListener(PropertyChangeListener listener){
        this.listener = listener;
    }

    public boolean isRent(){
        return listener != null;
    }
    public void addCustomer(Customer customer) throws SQLException, NotBoundException, RemoteException {
        model.addCustomer(customer);
        if(listener != null){
            listener.propertyChange(new PropertyChangeEvent(this, FilterItemsViewModel.UPDATE_CUSTOMER, null, customer));
        }
    }



}
