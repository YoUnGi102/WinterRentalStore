package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Rent {

    private LocalDateTime start;
    private LocalDateTime end;
    private Customer customer;
    private ArrayList<Item> items;
    private Staff staff;

    private double total;

    public Rent(LocalDateTime start, LocalDateTime end, Customer customer, ArrayList<Item> items, Staff staff, double total) {
        this.start = start;
        this.end = end;
        this.customer = customer;
        this.items = items;
        this.staff = staff;
        this.total = total;
    }

    public LocalDateTime getStart() {
        return start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
    public Customer getCustomer() {
        return customer;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public Staff getStaff() {
        return staff;
    }
    public double getTotal() {
        return total;
    }
}
