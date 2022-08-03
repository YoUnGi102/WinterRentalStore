package view;

import alerts.ErrorAlert;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.Customer;
import viewModel.FilterItemsViewModel;
import viewModel.ItemTableView;
import viewModel.RentViewModel;

public class RentViewController {

    @FXML
    private TableView<ItemTableView> items;

    @FXML
    private TableColumn<ItemTableView, String> nameColumn, typeColumn;
    @FXML
    private TableColumn<ItemTableView, Integer> sizeColumn;
    @FXML
    private TableColumn<ItemTableView, Double> priceColumn;

    @FXML
    private Label customerName, total, startDate, endDate, email, phone, passport;

    private ViewHandler handler;
    private RentViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, RentViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;
        if(viewModel.getCustomer() != null){
            Customer customer = viewModel.getCustomer();
            customerName.setText(customer.getFirstName() + " " + customer.getLastName());
            email.setText(customer.getEmail());
            phone.setText(customer.getPhoneNumber());
            passport.setText(customer.getPassportNumber());
        }
    }

    @FXML
    void addCustomer() {
        // TODO ADD CUSTOMER
    }

    @FXML
    void back() {
        handler.openView("");
    }

    @FXML
    void confirm() {

    }

    @FXML
    void removeItem() {
        ItemTableView itemView = items.getSelectionModel().getSelectedItem();
        if(itemView != null){
            items.getItems().remove(itemView);
            items.refresh();
        }else{
            new ErrorAlert("No item was selected");
        }
    }

    @FXML
    void searchCustomer() {
        // TODO ADD SEARCH CUSTOMER
    }
    public Region getRoot() {
        return root;
    }
}
