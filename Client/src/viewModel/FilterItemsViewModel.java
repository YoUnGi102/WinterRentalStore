package viewModel;

import com.sun.jdi.request.DuplicateRequestException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import model.Customer;
import model.Item;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterItemsViewModel {

    private final RemoteModel model;
    private ObjectProperty<ObservableList<Item>> shoppingCart;
    private ObjectProperty<ObservableList<ItemTableView>> searchedItems;
    private IntegerProperty itemsAmount;

    public FilterItemsViewModel(RemoteModel model, RentViewModel rentViewModel){
        searchedItems = new SimpleObjectProperty<>();
        itemsAmount = new SimpleIntegerProperty();
        shoppingCart = new SimpleObjectProperty<>(FXCollections.observableArrayList());
        rentViewModel.bindShoppingCart(shoppingCart);
        this.model = model;
    }

    public void bindSearchedItems(ObjectProperty<ObservableList<ItemTableView>> searchedItems){
        this.searchedItems.bindBidirectional(searchedItems);
    }

    public void bindItemsAmount(IntegerProperty itemsAmount){
        this.itemsAmount.bindBidirectional(itemsAmount);
    }

    public void getItems(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws SQLException, NotBoundException, RemoteException {
        ArrayList<Item> items = model.getItems(start, end, type, minSize, maxSize, minPrice, maxPrice);
        ObservableList<ItemTableView> searchData = FXCollections.observableArrayList();
        for (Item item : items)
            searchData.add(new ItemTableView(item));
        searchedItems.set(searchData);
    }

    public void addToBasket(Item item) throws DuplicateRequestException{
        if(shoppingCart.get().contains(item)){
            throw new DuplicateRequestException("The item is already in the shopping cart");
        }
        shoppingCart.get().add(item);
        System.out.println("Item added");
        itemsAmount.set(shoppingCart.get().size());
    }

    public ArrayList<String> getItemTypes() throws SQLException, RemoteException {
        return model.getItemTypes();
    }

    public HashMap<String, String> getTypeUnitPairs() throws SQLException, RemoteException {
        return model.getTypeUnitPairs();
    }
    public void clear() {
        shoppingCart.getValue().clear();
    }
}
