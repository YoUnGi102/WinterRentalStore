package viewModel;

import javafx.beans.property.*;
import model.Customer;
import model.Customer;

public class CustomerTableView {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty passport;

    private Customer customer;

    public CustomerTableView(Customer customer){
        this.customer = customer;
        setCustomer(customer);
    }

    public void setCustomer(Customer customer){
        this.firstName = new SimpleStringProperty(customer.getFirstName());
        this.lastName = new SimpleStringProperty(customer.getLastName());
        this.email = new SimpleStringProperty(customer.getEmail());
        this.passport = new SimpleStringProperty(customer.getPassportNumber());
        this.phone = new SimpleStringProperty(customer.getPhoneNumber());
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getFirstName() {
        return firstName.get();
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public String getEmail() {
        return email.get();
    }
    public StringProperty emailProperty() {
        return email;
    }
    public String getPhone() {
        return phone.get();
    }
    public StringProperty phoneProperty() {
        return phone;
    }
    public String getPassport() {
        return passport.get();
    }
    public StringProperty passportProperty() {
        return passport;
    }
}
