package view;


import alerts.DatabaseAlert;
import alerts.ErrorAlert;
import alerts.ServerAlert;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.LogInViewModel;

import javax.xml.crypto.Data;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginViewController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    private Region root;
    private ViewHandler viewHandler;
    private LogInViewModel viewModel;

    public void init(ViewHandler viewHandler, LogInViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }
    public void logIn() {
        try {
            if(viewModel.logIn(username.getText(), password.getText()))
                viewHandler.openView(ViewHandler.MENU_VIEW);
            else
                new ErrorAlert("Username or password is incorrect");

        }catch (NotBoundException | RemoteException e){
            new ServerAlert();
        }catch (SQLException e){
            new DatabaseAlert();}
    }
    public Region getRoot() {
        return root;
    }
}
