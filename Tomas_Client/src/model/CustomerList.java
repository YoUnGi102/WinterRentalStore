package dk.via.client.model;

import java.util.ArrayList;

public class CustomerList {
    private ArrayList<Customer> customers;

public CustomerList() {
        customers = new ArrayList<Customer>();
    }

    public Customer getCustomerByPassport(int passportNumber) {
        for (Customer customer : customers) {
            if (customer.getPassportNumber() == passportNumber) {
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
