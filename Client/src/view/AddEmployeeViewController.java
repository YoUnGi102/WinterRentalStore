package view;

import alerts.DatabaseAlert;
import alerts.ErrorAlert;
import alerts.ServerAlert;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Staff;
import viewModel.AddEmployeeViewModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.ServerError;
import java.sql.SQLException;

public class AddEmployeeViewController {

    @FXML
    private TextField fName, lName, email, username;
    @FXML
    private PasswordField password;

    private ViewHandler handler;
    private AddEmployeeViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, AddEmployeeViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;
    }

    @FXML
    public void add() {
        String fName = this.fName.getText();
        String lName = this.lName.getText();
        String username = this.username.getText();
        String password = this.password.getText();
        String email = this.email.getText();

        if(fName.equals("") || lName.equals("") || username.equals("") || password.equals("") || email.equals("")){
            new ErrorAlert("One or more fields are empty");
            return;
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
        try {
            viewModel.addStaff(new Staff(username, email, fName, lName, "employee"));
        } catch (SQLException e) {
            new DatabaseAlert();
        } catch (NotBoundException | RemoteException e) {
            new ServerAlert();
        }
    }

    @FXML
    public void cancel(){
        clear();
        handler.openView(ViewHandler.MENU_VIEW);
    }

    public void clear(){
        fName.clear();
        lName.clear();
        password.clear();
        email.clear();
        username.clear();
    }

    public Region getRoot() {
        return root;
    }

}
