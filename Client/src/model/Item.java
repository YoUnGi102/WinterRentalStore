package model;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private String name;
    private String type;
    private int size;
    private String sizeUnit;
    private double pricePerDay;
    private boolean rented;

    public Item(int itemId, String name, String type, int size, String sizeUnit, double pricePerDay, boolean rented) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.pricePerDay = pricePerDay;
        this.rented = rented;
    }

    public Item(int itemId, String name, String type, int size, String sizeUnit, double pricePerDay) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.pricePerDay = pricePerDay;
        this.rented = false;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public void rentItem() {
        this.rented = true;
    }

    public void returnItem() {
        this.rented = false;
    }

}