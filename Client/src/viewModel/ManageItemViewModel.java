package viewModel;

import javafx.beans.property.*;
import mediator.RemoteModel;
import model.Item;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ManageItemViewModel {

    private RemoteModel model;
    private IntegerProperty itemIdProperty;
    private StringProperty nameProperty;
    private StringProperty typeProperty;
    private IntegerProperty sizeProperty;
    private StringProperty sizeUnitProperty;
    private DoubleProperty pricePerDayProperty;
    private BooleanProperty rentedProperty;

    public ManageItemViewModel(RemoteModel model) {
        this.model = model;
        itemIdProperty = new SimpleIntegerProperty();
        nameProperty = new SimpleStringProperty();
        typeProperty = new SimpleStringProperty();
        sizeProperty = new SimpleIntegerProperty();
        sizeUnitProperty = new SimpleStringProperty();
        pricePerDayProperty = new SimpleDoubleProperty();
        rentedProperty = new SimpleBooleanProperty();
    }

    public Item getItemById(int itemId) throws NotBoundException, RemoteException, SQLException {
        return model.getItemById(itemId);
    }

    public void addItem(Item item) throws NotBoundException, RemoteException, SQLException {
        model.addItem(item);
    }

    public void removeItem(Item item) throws NotBoundException, RemoteException, SQLException {
        model.removeItem(item);
    }

    public int getItemIdProperty() {
        return itemIdProperty.get();
    }

    public void setItemIdProperty(int itemIdProperty) {
        this.itemIdProperty.set(itemIdProperty);
    }

    public IntegerProperty getItemIdPropertyProperty() {
        return itemIdProperty;
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty.set(nameProperty);
    }

    public StringProperty getNamePropertyProperty() {
        return nameProperty;
    }

    public String getTypeProperty() {
        return typeProperty.get();
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty.set(typeProperty);
    }

    public StringProperty getTypePropertyProperty() {
        return typeProperty;
    }

    public int getSizeProperty() {
        return sizeProperty.get();
    }

    public void setSizeProperty(int sizeProperty) {
        this.sizeProperty.set(sizeProperty);
    }

    public IntegerProperty getSizePropertyProperty() {
        return sizeProperty;
    }

    public String getSizeUnitProperty() {
        return sizeUnitProperty.get();
    }

    public void setSizeUnitProperty(String sizeUnitProperty) {
        this.sizeUnitProperty.set(sizeUnitProperty);
    }

    public StringProperty getSizeUnitPropertyProperty() {
        return sizeUnitProperty;
    }

    public double getPricePerDayProperty() {
        return pricePerDayProperty.get();
    }

    public void setPricePerDayProperty(double pricePerDayProperty) {
        this.pricePerDayProperty.set(pricePerDayProperty);
    }

    public DoubleProperty getPricePerDayPropertyProperty() {
        return pricePerDayProperty;
    }

    public boolean isRentedProperty() {
        return rentedProperty.get();
    }

    public void setRentedProperty(boolean rentedProperty) {
        this.rentedProperty.set(rentedProperty);
    }

    public BooleanProperty isRentedPropertyProperty() {
        return rentedProperty;
    }
}
