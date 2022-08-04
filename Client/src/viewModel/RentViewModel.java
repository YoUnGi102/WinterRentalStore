package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import model.Customer;
import model.Item;

import java.time.LocalDateTime;

public class RentViewModel {

    private final RemoteModel model;
    private ObjectProperty<ObservableList<Item>> shoppingCart;
    private ObjectProperty<Customer> customer;

    public RentViewModel(RemoteModel model){
        customer = new SimpleObjectProperty<>();
        shoppingCart = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        this.model = model;
    }
    public void bindShoppingCart(ObjectProperty<ObservableList<Item>> shoppingCart){
        this.shoppingCart.bindBidirectional(shoppingCart);
    }
    public void bindCustomer(ObjectProperty<Customer> customer){
        this.customer.bindBidirectional(customer);
    }

    public void bindStartDate(ObjectProperty<LocalDateTime> start){

    }

    public void bindEndDate(ObjectProperty<LocalDateTime> end){

    }
    public Customer getCustomer() {
        return customer.get();
    }

    public void setCustomer(Customer customer) {
        this.customer.set(customer);
    }
}
