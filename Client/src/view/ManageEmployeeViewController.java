package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.LogInViewModel;
import viewModel.ManageEmployeeViewModel;

public class ManageEmployeeViewController {
    private ManageEmployeeViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    @FXML
    private TextField usernameID;
    @FXML
    private TextField passwordID;
    @FXML
    private TextField firstNameID;
    @FXML
    private TextField lastNameID;
    @FXML
    private TextField emailID;
    @FXML
    private ChoiceBox<String> staffTypeID;


    public void init(ViewHandler viewHandler, ManageEmployeeViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        usernameID.textProperty().bindBidirectional(viewModel.getUsernamePropertyProperty());
        passwordID.textProperty().bindBidirectional(viewModel.getPasswordPropertyProperty());
        firstNameID.textProperty().bindBidirectional(viewModel.getFirstNamePropertyProperty());
        lastNameID.textProperty().bindBidirectional(viewModel.getLastNamePropertyProperty());
        emailID.textProperty().bindBidirectional(viewModel.getEmailPropertyProperty());
        staffTypeID.valueProperty().bindBidirectional(viewModel.getStaffTypePropertyProperty());
        staffTypeID.getItems().addAll("Manager", "Employee");

        reset();
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        viewModel.reset();
    }

}

