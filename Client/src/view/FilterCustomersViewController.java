package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.Customer;
import viewModel.CustomerTableView;
import viewModel.FilterCustomersViewModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Filter;

public class FilterCustomersViewController {

    @FXML
    private TextField searchBar;

    @FXML
    private TableView<CustomerTableView> customerList;

    @FXML
    private TableColumn<CustomerTableView, String> firstName, lastName, passport, phone, email;

    private ViewHandler handler;
    private FilterCustomersViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, FilterCustomersViewModel viewModel, Region root) {
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;

        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        viewModel.bindSearchedCustomers(customerList.itemsProperty());

    }

    public Region getRoot(){
        return root;
    }

    @FXML
    void cancel() {
        if(viewModel.isRent()){
            handler.openView(ViewHandler.RENT_VIEW);
        }else{
            handler.openView(ViewHandler.MENU_VIEW);
        }
    }

    @FXML
    void add(){
        handler.openView(ViewHandler.ADD_CUSTOMER_VIEW);
    }

    @FXML
    void remove() {

    }

    @FXML
    void rent() {
        if(customerList.getSelectionModel().getSelectedItem() == null)
            return;

        Customer customer = customerList.getSelectionModel().getSelectedItem().getCustomer();
        viewModel.rentTo(customer);
        System.out.println("HELLO");
        if(viewModel.isRent()){
            handler.openView(ViewHandler.RENT_VIEW);
        }else{
            handler.openView(ViewHandler.FILTER_ITEMS_VIEW);
        }

    }

    @FXML
    void search() {
        try {
            viewModel.search(searchBar.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public FilterCustomersViewModel getViewModel() {
        return viewModel;
    }
}
