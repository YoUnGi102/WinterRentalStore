package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Model;
import model.Rent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import static viewModel.FilterItemsViewModel.UPDATE_CUSTOMER;

public class FilterCustomersViewModel {
    private Model model;

    private ObjectProperty<ObservableList<CustomerTableView>> searchedCustomers;
    private PropertyChangeListener listener;
    private MenuViewModel prevView;
    public FilterCustomersViewModel(Model model){
        searchedCustomers = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        this.model = model;
    }

    public void setPrevView(MenuViewModel prevView){
        this.prevView = prevView;
    }
    public void setListener(PropertyChangeListener listener){
        this.listener = listener;
    }
    public boolean isRent(){
        return prevView == null;
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
         listener.propertyChange(new PropertyChangeEvent(this, UPDATE_CUSTOMER, null, customer));
    }

}
