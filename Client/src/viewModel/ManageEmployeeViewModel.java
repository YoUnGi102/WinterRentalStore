package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.RemoteModel;
import model.Employee;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ManageEmployeeViewModel {
    private final ObjectProperty<Employee> employee;
    private StringProperty usernameProperty;
    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private StringProperty emailProperty;
    private StringProperty passwordProperty;
    private StringProperty staffTypeProperty;

    private final StringProperty errorMessage;

    private RemoteModel model;

    public ManageEmployeeViewModel(RemoteModel model) {
        this.model = model;
        usernameProperty = new SimpleStringProperty();
        firstNameProperty = new SimpleStringProperty();
        lastNameProperty = new SimpleStringProperty();
        emailProperty = new SimpleStringProperty();
        passwordProperty = new SimpleStringProperty();
        staffTypeProperty = new SimpleStringProperty();
        employee = new SimpleObjectProperty<>();
        errorMessage = new SimpleStringProperty();
    }

    public ArrayList<Employee> getEmployees() throws RemoteException, NotBoundException {
        return model.getEmployees();
    }

    public ArrayList<Employee> getEmployeesByType(String type) throws RemoteException, NotBoundException {
        return model.getEmployeesByType(type);
    }

    public Employee getEmployeeByUsername(String username) throws RemoteException, NotBoundException {
        return model.getEmployeeByUsername(username);
    }

    public void addEmployee(Employee employee) throws RemoteException, NotBoundException {
        model.addEmployee(employee);
    }

    public void removeEmployee(Employee employee) throws RemoteException, NotBoundException {
        model.removeEmployee(employee);
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

    public void reset() {
  try {
            Employee selectedEmployee = employee.get();
            firstNameProperty.set(selectedEmployee.getFirstName());
            lastNameProperty.set(selectedEmployee.getLastName());
            usernameProperty.set(selectedEmployee.getUsername());
            emailProperty.set(selectedEmployee.getEmail());
            passwordProperty.set(selectedEmployee.getPassword());
            staffTypeProperty.set(selectedEmployee.getStaffType());
        } catch (Exception e) {
            errorMessage.set("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Employee getEmployee() {
        return employee.get();
    }

    public ObjectProperty<Employee> employeeProperty() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee.set(employee);
    }

    public String getErrorMessage() {
        return errorMessage.get();
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.set(errorMessage);
    }

}
