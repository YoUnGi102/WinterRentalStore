package com.example.winterrentalstore.viewModel;

import com.example.winterrentalstore.model.Item;
import com.example.winterrentalstore.model.Model;
import javafx.beans.property.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ManageItemViewModel {
    private Model model;
    private IntegerProperty itemIdProperty;
    private StringProperty nameProperty;
    private StringProperty typeProperty;
    private IntegerProperty sizeProperty;
    private StringProperty sizeUnitProperty;
    private DoubleProperty pricePerDayProperty;
    private BooleanProperty rentedProperty;

    public ManageItemViewModel(Model model) {
        this.model = model;
        itemIdProperty = new SimpleIntegerProperty();
        nameProperty = new SimpleStringProperty();
        typeProperty = new SimpleStringProperty();
        sizeProperty = new SimpleIntegerProperty();
        sizeUnitProperty = new SimpleStringProperty();
        pricePerDayProperty = new SimpleDoubleProperty();
        rentedProperty = new SimpleBooleanProperty();
    }

    public Item getItemById(int itemId) throws NotBoundException, RemoteException {
        return model.getItemById(itemId);
    }

    public void addItem(Item item) throws NotBoundException, RemoteException {
        model.addItem(item);
    }

    public void removeItem(Item item) throws NotBoundException, RemoteException {
        model.removeItem(item);
    }

    public int getItemIdProperty() {
        return itemIdProperty.get();
    }

    public IntegerProperty getItemIdPropertyProperty() {
        return itemIdProperty;
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public StringProperty getNamePropertyProperty() {
        return nameProperty;
    }

    public String getTypeProperty() {
        return typeProperty.get();
    }

    public StringProperty getTypePropertyProperty() {
        return typeProperty;
    }

    public int getSizeProperty() {
        return sizeProperty.get();
    }

    public IntegerProperty getSizePropertyProperty() {
        return sizeProperty;
    }

    public String getSizeUnitProperty() {
        return sizeUnitProperty.get();
    }

    public StringProperty getSizeUnitPropertyProperty() {
        return sizeUnitProperty;
    }

    public double getPricePerDayProperty() {
        return pricePerDayProperty.get();
    }

    public DoubleProperty getPricePerDayPropertyProperty() {
        return pricePerDayProperty;
    }

    public boolean isRentedProperty() {
        return rentedProperty.get();
    }

    public BooleanProperty isRentedPropertyProperty() {
        return rentedProperty;
    }

    public void setItemIdProperty(int itemIdProperty) {
        this.itemIdProperty.set(itemIdProperty);
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty.set(nameProperty);
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty.set(typeProperty);
    }

    public void setSizeProperty(int sizeProperty) {
        this.sizeProperty.set(sizeProperty);
    }

    public void setSizeUnitProperty(String sizeUnitProperty) {
        this.sizeUnitProperty.set(sizeUnitProperty);
    }

    public void setPricePerDayProperty(double pricePerDayProperty) {
        this.pricePerDayProperty.set(pricePerDayProperty);
    }

    public void setRentedProperty(boolean rentedProperty) {
        this.rentedProperty.set(rentedProperty);
    }
}
