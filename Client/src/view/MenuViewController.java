package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import viewModel.MenuViewModel;

import java.rmi.RemoteException;
import java.sql.SQLException;

import static view.ViewHandler.*;

public class MenuViewController {

    @FXML
    private Button employee, items;
    private ViewHandler viewHandler;
    private MenuViewModel viewModel;
    private Region root;
    public void init(ViewHandler viewHandler, MenuViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        setAccess();
    }

    public void setAccess(){
        if(viewModel.getStaff() != null && viewModel.getStaff().getUserType().equals("manager")){
            employee.setVisible(true);
            items.setVisible(true);
        }else{
            employee.setVisible(false);
            items.setVisible(false);
        }
    }
    @FXML
    void customer() {
        viewHandler.openView(FILTER_CUSTOMERS_VIEW);
    }

    @FXML
    void employee() {
        viewHandler.openView(ADD_EMPLOYEE_VIEW);
    }

    @FXML
    void items() {
        viewHandler.openView(ViewHandler.MANAGE_ITEM_VIEW);
    }

    @FXML
    void logOut() {
        try {
            viewModel.logOut();
            viewHandler.openView(ViewHandler.LOGIN_VIEW);
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void renting() {
        viewHandler.openView(FILTER_ITEMS_VIEW);
    }
    public Region getRoot() {
        return root;
    }
}
