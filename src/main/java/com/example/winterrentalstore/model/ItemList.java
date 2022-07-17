package com.example.winterrentalstore.model;

import java.util.ArrayList;

public class ItemList {

    private ArrayList<Item> items;

    public ItemList() {
        items = new ArrayList<Item>();
    }

    public Item getItemById(int itemId) {
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

}
