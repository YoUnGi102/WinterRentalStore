package view;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.LogInViewModel;
import viewModel.ServerAlert;

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

    public void logIn() throws NotBoundException, RemoteException, SQLException {
//        try {
        viewModel.logIn(username.getText(), password.getText());
        // navigation test page
        viewHandler.openView(ViewHandler.EMPLOYEE_VIEW);
//        } catch (NotBoundException | RemoteException e) {
//            (new ServerAlert()).show();
//        }
    }

    public Region getRoot() {
        return root;
    }
}
