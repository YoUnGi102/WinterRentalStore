package view;

import alerts.DatabaseAlert;
import alerts.ErrorAlert;
import alerts.ServerAlert;
import alerts.SuccessAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.Customer;
import viewModel.AddCustomerViewModel;

import javax.xml.crypto.Data;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AddCustomerViewController {

    @FXML
    private TextField fName, lName, phone, email, passport;

    private ViewHandler handler;
    private AddCustomerViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, AddCustomerViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;
    }

    @FXML
    void cancel() {
        clear();
        if(viewModel.isRent()){
            handler.openView(ViewHandler.RENT_VIEW);
        }else {
            handler.openView(ViewHandler.FILTER_CUSTOMERS_VIEW);
        }

    }

    public void clear(){
        fName.clear();
        lName.clear();
        passport.clear();
        phone.clear();
        email.clear();
    }

    public AddCustomerViewModel getViewModel(){
        return viewModel;
    }

    @FXML
    void confirm() throws NotBoundException {
        String fName = this.fName.getText();
        String lName = this.lName.getText();
        String email = this.email.getText();
        String phone = this.phone.getText();
        String passport = this.passport.getText();

        if (fName.equals("") || lName.equals("") || email.equals("") || phone.equals("") || passport.equals("")) {
            new ErrorAlert("Missing information in one or more fields!");
            return;
        }

        String allowedChars = "0123456789+";
        for (char c : phone.toCharArray()) {
            if (!allowedChars.contains(String.valueOf(c))) {
                new ErrorAlert("Incorrect Phone Number format!");
                return;
            }
        }

        int mail = 0;
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '@' && mail == 0) {
                mail++;
            } else if (c == '.' && mail == 1) {
                mail++;
            }
        }
        if (mail != 2) {
            new ErrorAlert("Incorrect Email Format, correct format: [text]@[text].[text]");
            return;
        }
        Customer customer = new Customer(fName, lName, passport, phone, email);
        try {
            viewModel.addCustomer(customer);
            new SuccessAlert("New Customer Successfully added");
            if (viewModel.isRent()) {
                clear();
                handler.openView(ViewHandler.RENT_VIEW);
            } else {
                clear();
                handler.openView(ViewHandler.FILTER_CUSTOMERS_VIEW);
            }
        } catch (org.postgresql.util.PSQLException e) {
            System.out.println(e.getSQLState() + " " + e.getErrorCode());
            if (Integer.parseInt(e.getSQLState()) == 23505) {
                new ErrorAlert("Customer with this passport, email or phone number is already in the system");
            } else {
                new DatabaseAlert();
            }
        } catch (SQLException e) {
            new DatabaseAlert();
        } catch (RemoteException e) {
            new ServerAlert();
        }
    }


    public Region getRoot() {
        return root;
    }
}
