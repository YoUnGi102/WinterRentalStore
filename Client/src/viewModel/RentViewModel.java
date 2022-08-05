package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import model.Customer;
import model.Item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;
import static viewModel.FilterItemsViewModel.*;

public class RentViewModel implements PropertyChangeListener {

    private final RemoteModel model;
    private ObjectProperty<ObservableList<ItemTableView>> shoppingCart;
    private ObjectProperty<Customer> customer;

    private PropertyChangeListener filterItemsListener;

    private StringProperty startDate;
    private StringProperty endDate;
    private StringProperty total;

    public RentViewModel(RemoteModel model){
        customer = new SimpleObjectProperty<>();
        shoppingCart = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        startDate = new SimpleStringProperty();
        endDate = new SimpleStringProperty();
        total = new SimpleStringProperty();
        this.model = model;
    }

    public void setFilterItemsListener(PropertyChangeListener filterItemsListener){
        this.filterItemsListener = filterItemsListener;
    }

    public void bindStartDate(StringProperty startDate){
        startDate.bind(this.startDate);
    }

    public void bindEndDate(StringProperty endDate){
        endDate.bind(this.endDate);
    }

    public void bindTotal(StringProperty total){
        total.bind(this.total);
    }

    public void removeFromBasket(ItemTableView itemTableView){
        shoppingCart.get().remove(itemTableView);
        calculateTotal();
        filterItemsListener.propertyChange(new PropertyChangeEvent(this, UPDATE_SHOPPING_CART, null, shoppingCart.get()));
    }

    public void bindShoppingCart(ObjectProperty<ObservableList<ItemTableView>> shoppingCart){
        shoppingCart.bind(this.shoppingCart);
    }

    public void bindCustomer(ObjectProperty<Customer> customer){
        this.customer.bindBidirectional(customer);
    }
    public Customer getCustomer() {
        return customer.get();
    }

    public void clearShoppingCart(){
        shoppingCart.get().clear();
        calculateTotal();
        filterItemsListener.propertyChange(new PropertyChangeEvent(this, UPDATE_SHOPPING_CART, null, shoppingCart.get()));
    }
    public void setCustomer(Customer customer) {
        this.customer.set(customer);
    }

    public void calculateTotal(){
        if(startDate.get() == null || endDate.get() == null)
            return;
        LocalDateTime start = LocalDateTime.parse(startDate.get(), FORMATTER);
        LocalDateTime end = LocalDateTime.parse(endDate.get(), FORMATTER);
        double days = DAYS.between(start.toLocalDate(), end.toLocalDate()) + Math.abs(start.getHour()-end.getHour())/12.0;
        double sumForDay = 0;
        for (ItemTableView i : shoppingCart.get()) {
            sumForDay += i.getItem().getPricePerDay();
        }
        total.set(sumForDay * days + " € ("+ days+ " days)");
        System.out.println(sumForDay*days);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case UPDATE_SHOPPING_CART:
                ObservableList<ItemTableView> cart = (ObservableList<ItemTableView>) evt.getNewValue();
                shoppingCart.set(cart);
                calculateTotal();
                break;
            case UPDATE_CUSTOMER:
                Customer customer = (Customer) evt.getNewValue();
                break;
            case UPDATE_START_DATE:
                String startDate = (String) evt.getNewValue();
                System.out.println("START DATE UPDATE");
                calculateTotal();
                this.startDate.setValue(startDate);
                break;
            case UPDATE_END_DATE:
                String endDate = (String) evt.getNewValue();
                this.endDate.setValue(endDate);
                System.out.println("END DATE UPDATE");
                calculateTotal();
                break;
            case UPDATE_TOTAL:
        }
    }
}
