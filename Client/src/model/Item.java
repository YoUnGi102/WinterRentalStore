package model;

import javafx.beans.property.*;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private StringProperty name;
    private StringProperty type;
    private IntegerProperty size;
    private StringProperty sizeUnit;
    private DoubleProperty pricePerDay;

    public Item(int itemId, String name, String type, int size, String sizeUnit, double pricePerDay) {
        this(name, type, size, sizeUnit, pricePerDay);
        this.itemId = itemId;
    }
    public Item(String name, String type, int size, String sizeUnit, double pricePerDay) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.size = new SimpleIntegerProperty(size);
        this.sizeUnit = new SimpleStringProperty(sizeUnit);
        this.pricePerDay = new SimpleDoubleProperty(pricePerDay);
    }
    public int getItemId() {
        return itemId;
    }
    public String getName() {
        return name.getValue();
    }
    public String getType() {
        return type.getValue();
    }
    public int getSize() {
        return size.getValue();
    }
    public String getSizeUnit() {
        return sizeUnit.getValue();
    }
    public double getPricePerDay() {
        return pricePerDay.getValue();
    }

    public StringProperty nameProperty() {
        return name;
    }
    public StringProperty typeProperty() {
        return type;
    }
    public IntegerProperty sizeProperty() {
        return size;
    }
    public StringProperty sizeUnitProperty() {
        return sizeUnit;
    }
    public DoubleProperty pricePerDayProperty() {
        return pricePerDay;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Item){
            Item item = (Item) obj;
            return
                    itemId == item.itemId &&
                            name.equals(item.name) &&
                            type.equals(item.type) &&
                            size == item.size &&
                            pricePerDay == item.pricePerDay;
        }
        else return false;
    }
}