package view;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.LogInViewModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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

    public void logIn() throws NotBoundException, RemoteException {
        //try {
        viewModel.logIn(username.getText(), password.getText());
//        } catch (NotBoundException | RemoteException e) {
//            (new ServerAlert()).show();
//        }
    }

    public Region getRoot() {
        return root;
    }
}
