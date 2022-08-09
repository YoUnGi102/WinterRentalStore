package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import viewModel.ManageItemViewModel;
import viewModel.RentViewModel;
import viewModel.ViewModelFactory;

import java.io.IOError;
import java.io.IOException;

import static view.ViewHandler.*;


public class ViewFactory {

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private ManageEmployeeViewController manageEmployeeViewController;
    private LoginViewController loginViewController;
    private ManageItemViewController manageItemViewController;
    private AddItemViewController addItemViewController;
    private MenuViewController menuViewController;
    private RentViewController rentViewController;
    private FilterItemsViewController filterItemsViewController;
    private AddCustomerViewController addCustomerViewController;
    private FilterCustomersViewController filterCustomersViewController;
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.loginViewController = null;
        this.addItemViewController = null;
        this.manageItemViewController = null;
        this.menuViewController = null;
        this.filterItemsViewController = null;
        this.rentViewController = null;
        this.addCustomerViewController = null;
        this.filterCustomersViewController = null;
        loadAddCustomerView();
        loadFilterCustomersView();
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
    public Region loadEmployeeView() {
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
    public Region loadManageItemView() {
        if (manageItemViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(MANAGE_ITEM_VIEW));
            try {
                Region root = loader.load();
                manageItemViewController = loader.getController();
                manageItemViewController.init(viewHandler, viewModelFactory.getManageItemViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return manageItemViewController.getRoot();
    }
    public Region loadAddItemView() {
        if (addItemViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ADD_ITEM_VIEW));
            try {
                Region root = loader.load();
                addItemViewController = loader.getController();
                addItemViewController.init(viewHandler, viewModelFactory.getAddItemViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return addItemViewController.getRoot();
    }
    public Region loadMenuView(){
        if(menuViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(MENU_VIEW));
            try {
                Region root = loader.load();
                menuViewController = loader.getController();
                menuViewController.init(viewHandler, viewModelFactory.getMenuViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        filterCustomersViewController.getViewModel().setListener(viewModelFactory.getMenuViewModel());
        return menuViewController.getRoot();
    }
    public Region loadFilterItemsView(){
        if(filterItemsViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FILTER_ITEMS_VIEW));
            try {
                Region root = loader.load();
                filterItemsViewController = loader.getController();
                filterItemsViewController.init(viewHandler, viewModelFactory.getFilterItemsViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return filterItemsViewController.getRoot();
    }
    public Region loadRentView(){
        if(rentViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(RENT_VIEW));
            try {
                Region root = loader.load();
                rentViewController = loader.getController();
                rentViewController.init(viewHandler, viewModelFactory.getRentViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        filterCustomersViewController.getViewModel().setListener(viewModelFactory.getRentViewModel());
        addCustomerViewController.getViewModel().setRentViewListener(viewModelFactory.getRentViewModel());
        return rentViewController.getRoot();
    }
    public Region loadAddCustomerView(){
        if(addCustomerViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ADD_CUSTOMER_VIEW));
            try {
                Region root = loader.load();
                addCustomerViewController = loader.getController();
                addCustomerViewController.init(viewHandler, viewModelFactory.getAddCustomerViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return addCustomerViewController.getRoot();
    }
    public Region loadFilterCustomersView(){
        if(filterCustomersViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FILTER_CUSTOMERS_VIEW));
            try {
                Region root = loader.load();
                filterCustomersViewController = loader.getController();
                filterCustomersViewController.init(viewHandler, viewModelFactory.getFilterCustomersViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        addCustomerViewController.getViewModel().setRentViewListener(null);
        return filterCustomersViewController.getRoot();
    }
}
