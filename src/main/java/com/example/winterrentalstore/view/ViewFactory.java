package com.example.winterrentalstore.view;

import com.example.winterrentalstore.viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

import static com.example.winterrentalstore.view.ViewHandler.LOGIN_VIEW;

public class ViewFactory {

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    private LoginViewController loginViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.loginViewController = null;
    }

    public Region loadLoginView(){
        if (loginViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewHandler.class.getResource(LOGIN_VIEW));
            try {
                Region root = loader.load();
                loginViewController = loader.getController();
                loginViewController.init(viewHandler, viewModelFactory.getLoginViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return loginViewController.getRoot();
    }
}
