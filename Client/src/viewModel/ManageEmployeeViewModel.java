package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.RemoteModel;

public class ManageEmployeeViewModel {
    private StringProperty usernameProperty;
    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private StringProperty emailProperty;
    private StringProperty passwordProperty;
    private StringProperty staffTypeProperty;

    private RemoteModel model;

    public ManageEmployeeViewModel(RemoteModel model) {
        this.model = model;
        usernameProperty = new SimpleStringProperty();
        firstNameProperty = new SimpleStringProperty();
        lastNameProperty = new SimpleStringProperty();
        emailProperty = new SimpleStringProperty();
        passwordProperty = new SimpleStringProperty();
        staffTypeProperty = new SimpleStringProperty();
    }

    public String getUsernameProperty() {
        return usernameProperty.get();
    }

    public StringProperty getUsernamePropertyProperty() {
        return usernameProperty;
    }

    public String getFirstNameProperty() {
        return firstNameProperty.get();
    }

    public StringProperty getFirstNamePropertyProperty() {
        return firstNameProperty;
    }

    public String getLastNameProperty() {
        return lastNameProperty.get();
    }

    public StringProperty getLastNamePropertyProperty() {
        return lastNameProperty;
    }

    public String getEmailProperty() {
        return emailProperty.get();
    }

    public StringProperty getEmailPropertyProperty() {
        return emailProperty;
    }

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public StringProperty getPasswordPropertyProperty() {
        return passwordProperty;
    }

    public String getStaffTypeProperty() {
        return staffTypeProperty.get();
    }

    public StringProperty getStaffTypePropertyProperty() {
        return staffTypeProperty;
    }

    public void setUsernameProperty(String usernameProperty) {
        this.usernameProperty.set(usernameProperty);
    }

    public void setFirstNameProperty(String firstNameProperty) {
        this.firstNameProperty.set(firstNameProperty);
    }

    public void setLastNameProperty(String lastNameProperty) {
        this.lastNameProperty.set(lastNameProperty);
    }

    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    public void setPasswordProperty(String passwordProperty) {
        this.passwordProperty.set(passwordProperty);
    }

    public void setStaffTypeProperty(String staffTypeProperty) {
        this.staffTypeProperty.set(staffTypeProperty);
    }
}
