package model;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private String name;
    private String type;
    private int size;
    private String sizeUnit;
    private double pricePerDay;

    public Item(int itemId, String name, String type, int size, String sizeUnit, double pricePerDay) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.pricePerDay = pricePerDay;
    }
    public Item(String name, String type, int size, String sizeUnit, double pricePerDay) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.pricePerDay = pricePerDay;
    }
    public int getItemId() {
        return itemId;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getSize() {
        return size;
    }
    public String getSizeUnit() {
        return sizeUnit;
    }
    public double getPricePerDay() {
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