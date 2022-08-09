package viewModel;

import com.sun.jdi.request.DuplicateRequestException;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Item;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterItemsViewModel implements PropertyChangeListener {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final String UPDATE_SHOPPING_CART = "update_shopping_cart";
    public static final String UPDATE_CUSTOMER = "update_customer";
    public static final String UPDATE_START_DATE = "update_start_date";
    public static final String UPDATE_END_DATE = "update_end_date";
    public static final String UPDATE_TOTAL = "update_total";
    private final Model model;
    private ObjectProperty<ObservableList<ItemTableView>> shoppingCart;
    private ObjectProperty<ObservableList<ItemTableView>> searchedItems;
    private StringProperty itemsAmount;

    private PropertyChangeListener rentViewModelListener;

    public FilterItemsViewModel(Model model){
        searchedItems = new SimpleObjectProperty<>();
        itemsAmount = new SimpleStringProperty();
        shoppingCart = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        this.model = model;
    }

    public void setRentViewModelListener(PropertyChangeListener rentViewModelListener){
        this.rentViewModelListener = rentViewModelListener;
    }

    public void bindSearchedItems(ObjectProperty<ObservableList<ItemTableView>> searchedItems){
        this.searchedItems.bindBidirectional(searchedItems);
    }

    public void bindItemsAmount(StringProperty itemsAmount){
        itemsAmount.bind(this.itemsAmount);
    }

    public void getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws SQLException, NotBoundException, RemoteException {
        PropertyChangeEvent startDate = new PropertyChangeEvent(this, UPDATE_START_DATE, null, start.format(FORMATTER));
        rentViewModelListener.propertyChange(startDate);
        PropertyChangeEvent endDate = new PropertyChangeEvent(this, UPDATE_END_DATE, null, end.format(FORMATTER));
        rentViewModelListener.propertyChange(endDate);
        ArrayList<Item> items = model.getItems(start, end, type, minSize, maxSize, minPrice, maxPrice);
        ObservableList<ItemTableView> searchData = FXCollections.observableArrayList();
        for (Item item : items)
            searchData.add(new ItemTableView(item));
        searchedItems.set(searchData);
    }

    public int getShoppingCartSize(){
        return shoppingCart.get().size();
    }

    public void addToBasket(ItemTableView item) throws DuplicateRequestException{
        for (ItemTableView i : shoppingCart.get()) {
            if(i.getItem().equals(item.getItem())){
                throw new DuplicateRequestException("The item is already in the shopping cart");
            }
        }
        shoppingCart.get().add(item);
        itemsAmount.set(String.valueOf(shoppingCart.get().size()));
        rentViewModelListener.propertyChange(new PropertyChangeEvent(this, UPDATE_SHOPPING_CART, null, shoppingCart.get()));
    }

    public ArrayList<String> getItemTypes() throws SQLException, RemoteException {
        return model.getItemTypes();
    }

    public HashMap<String, String> getTypeUnitPairs() throws SQLException, RemoteException {
        return model.getTypeUnitPairs();
    }
    public void clear() {
        shoppingCart.getValue().clear();
        itemsAmount.set(String.valueOf(shoppingCart.get().size()));
        rentViewModelListener.propertyChange(new PropertyChangeEvent(this, UPDATE_SHOPPING_CART, null, shoppingCart.get()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case UPDATE_SHOPPING_CART:
                ObservableList<ItemTableView> cart = (ObservableList<ItemTableView>) evt.getNewValue();
                shoppingCart.set(cart);
                itemsAmount.setValue(String.valueOf(shoppingCart.get().size()));
                break;
            case UPDATE_CUSTOMER:
                Customer customer = (Customer) evt.getNewValue();
                break;
        }
    }
}
