package view;

import alerts.ErrorAlert;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RentViewController {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
    @FXML
    private TableView<Item> items;

    @FXML
    private TableColumn<Item, String> nameColumn, typeColumn;
    @FXML
    private TableColumn<Item, Integer> sizeColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;

    @FXML
    private Label customerName, total, startDate, endDate, email, phone, passport;

    private ViewHandler handler;
    private RentViewModel viewModel;
    private Region root;

    private ObjectProperty<Customer> customer;
    private ObjectProperty<LocalDateTime> start;
    private ObjectProperty<LocalDateTime> end;
    public void init(ViewHandler handler, RentViewModel viewModel, Region root){
        customer = new SimpleObjectProperty<>();
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;

        start = new SimpleObjectProperty<>();
        end = new SimpleObjectProperty<>();

        customer.addListener((observableValue, oldVal, newVal) -> {
            if(newVal != null){
                Customer customer = viewModel.getCustomer();
                customerName.setText(customer.getFirstName() + " " + customer.getLastName());
                email.setText(customer.getEmail());
                phone.setText(customer.getPhoneNumber());
                passport.setText(customer.getPassportNumber());
            }else{
                customerName.setText("");
                email.setText("");
                phone.setText("");
                passport.setText("");
            }
        });

        start.addListener((observableValue, oldVal, newVal) -> {
            if(newVal != null){
                startDate.setText(newVal.format(FORMATTER));
            }else{
                startDate.setText("");
            }
        });

        end.addListener((observableValue, oldVal, newVal) -> {
            if(newVal != null){
                endDate.setText(newVal.format(FORMATTER));
            }else{
                endDate.setText("");
            }
        });

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        viewModel.bindShoppingCart(items.itemsProperty());
        viewModel.bindCustomer(customer);

    }

    @FXML
    void addCustomer() {
        // TODO ADD CUSTOMER
    }

    @FXML
    void back() {
        handler.openView(ViewHandler.FILTER_ITEMS_VIEW);
    }

    @FXML
    void confirm() {

    }

    @FXML
    void removeItem() {
        Item item = items.getSelectionModel().getSelectedItem();
        if(item != null){
            items.getItems().remove(item);
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
