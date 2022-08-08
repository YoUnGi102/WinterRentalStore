package view;

import alerts.ErrorAlert;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.Customer;
import model.Item;
import viewModel.FilterItemsViewModel;
import viewModel.ItemTableView;
import viewModel.RentViewModel;

import java.time.LocalDateTime;

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

    private ObjectProperty<Customer> customer;

    public void init(ViewHandler handler, RentViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;

        customer = new SimpleObjectProperty<>();

        viewModel.bindStartDate(startDate.textProperty());
        viewModel.bindEndDate(endDate.textProperty());
        viewModel.bindTotal(total.textProperty());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        viewModel.bindCustomer(customer);
        customer.addListener((observableValue, oldVal, newVal) -> {
            if(newVal != null){
                customerName.setText(newVal.getFirstName() + " " + newVal.getLastName());
                email.setText(newVal.getEmail());
                phone.setText(newVal.getPhoneNumber());
                passport.setText(newVal.getPassportNumber());
            }else{
                customerName.setText("");
                email.setText("");
                phone.setText("");
                passport.setText("");
            }
        });

        if(viewModel.getCustomer() != null){
            Customer customer = viewModel.getCustomer();
            customerName.setText(customer.getFirstName() + " " + customer.getLastName());
            email.setText(customer.getEmail());
            phone.setText(customer.getPhoneNumber());
            passport.setText(customer.getPassportNumber());
        }
        viewModel.bindShoppingCart(items.itemsProperty());


    }

    @FXML
    void addCustomer() {
        handler.openView(ViewHandler.ADD_CUSTOMER_VIEW);
    }

    @FXML
    void back() {
        handler.openView(ViewHandler.FILTER_ITEMS_VIEW);
    }

    @FXML
    void confirm() {
        viewModel.
    }

    @FXML
    void removeItem() {
        ItemTableView itemView = items.getSelectionModel().getSelectedItem();
        if(itemView != null){
            viewModel.removeFromBasket(itemView);
            items.refresh();
        }else{
            new ErrorAlert("No item was selected");
        }
    }

    @FXML
    void emptyCart() {
        viewModel.clearShoppingCart();
    }
    @FXML
    void searchCustomer() {
        handler.openView(ViewHandler.FILTER_CUSTOMERS_VIEW);
    }
    public Region getRoot() {
        return root;
    }
}
