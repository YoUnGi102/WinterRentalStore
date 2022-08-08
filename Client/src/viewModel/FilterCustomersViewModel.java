package viewModel;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import model.Customer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static viewModel.FilterItemsViewModel.UPDATE_CUSTOMER;

public class FilterCustomersViewModel {
    private RemoteModel model;

    private ObjectProperty<ObservableList<CustomerTableView>> searchedCustomers;

    private PropertyChangeListener rentViewModelListener;
    public FilterCustomersViewModel(RemoteModel model){
        searchedCustomers = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        this.model = model;
    }

    public void setRentViewModelListener(PropertyChangeListener listener){
        this.rentViewModelListener = listener;
    }

    public void bindSearchedCustomers(ObjectProperty<ObservableList<CustomerTableView>> searchedCustomers){
        searchedCustomers.bind(this.searchedCustomers);
    }

    public void removeCustomer(Customer customer) throws SQLException, NotBoundException, RemoteException {
        model.removeCustomer(customer);
    }

    public void search(String keyword) throws SQLException, NotBoundException, RemoteException {
        ObservableList<CustomerTableView> customers = FXCollections.observableArrayList();
        for (Customer c : model.getCustomers(keyword)) {
            customers.add(new CustomerTableView(c));
        }
        searchedCustomers.setValue(customers);
    }

    public void rentTo(Customer customer){
        rentViewModelListener.propertyChange(new PropertyChangeEvent(this, UPDATE_CUSTOMER, null, customer));
    }

}
