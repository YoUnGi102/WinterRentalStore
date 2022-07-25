package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import viewModel.AddItemViewModel;
import viewModel.ManageItemViewModel;

import java.awt.event.ActionEvent;
import java.io.IOError;
import java.io.IOException;

import static view.ViewHandler.EMPLOYEE_VIEW;

public class ManageItemViewController {

    private ViewHandler handler;
    private ManageItemViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, ManageItemViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;
    }

    @FXML
    void addItem() {
        handler.openView(ViewHandler.ADD_ITEM_VIEW);
    }

    public Region getRoot() {
        return root;
    }
}