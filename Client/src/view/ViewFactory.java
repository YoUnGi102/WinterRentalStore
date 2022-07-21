package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import viewModel.ViewModelFactory;

import java.io.IOError;
import java.io.IOException;

import static view.ViewHandler.EMPLOYEE_VIEW;
import static view.ViewHandler.LOGIN_VIEW;


public class ViewFactory {

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    private LoginViewController loginViewController;

    private ManageEmployeeViewController manageEmployeeViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.loginViewController = null;
    }

    public Region loadLoginView() {
        if (loginViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(LOGIN_VIEW));
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

    public Region loadEmployeeView()
    {
        if (manageEmployeeViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(EMPLOYEE_VIEW));
            try {
                Region root = loader.load();
                manageEmployeeViewController = loader.getController();
                manageEmployeeViewController.init(viewHandler, viewModelFactory.getManageEmployeeViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return manageEmployeeViewController.getRoot();
    }
}
