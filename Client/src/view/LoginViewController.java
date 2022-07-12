package view;

import javafx.scene.control.PasswordField;
import javafx.scene.layout.Region;

import java.awt.*;

public class LoginViewController {
    private TextField username;
    private PasswordField password;
    private Region root;
    private ViewHandler viewHandler;
    private LogInViewModel viewModel;

    public void init(ViewHandler viewHandler, LogInViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }

    public void logIn(){
    // viewModel.logIn(username,password);
    }
}
