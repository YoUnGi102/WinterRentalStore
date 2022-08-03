package model;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerList {
    private ArrayList<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<Customer>();
    }

    public Customer getCustomerByPassport(String passportNumber) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getPassportNumber(), passportNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

}
