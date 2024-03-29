package view;
import alerts.DatabaseAlert;
import alerts.ErrorAlert;
import alerts.ServerAlert;
import com.sun.jdi.request.DuplicateRequestException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.Item;
import viewModel.FilterItemsViewModel;
import viewModel.ItemTableView;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

import static view.ViewHandler.MENU_VIEW;
import static view.ViewHandler.RENT_VIEW;

public class FilterItemsViewController {

    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;

    @FXML
    private ChoiceBox<String> startTime;
    @FXML
    private ChoiceBox<String> endTime;
    @FXML
    private ChoiceBox<String> type;

    @FXML
    private TextField sizeMin, sizeMax, priceMin, priceMax;

    @FXML
    private TableView<ItemTableView> itemsList;

    @FXML
    private TableColumn<ItemTableView, String> nameColumn, typeColumn;

    @FXML
    private TableColumn<ItemTableView, Integer> sizeColumn;

    @FXML
    private TableColumn<ItemTableView, Double> priceColumn;

    @FXML
    private Label itemsNum;

    private ViewHandler handler;
    private FilterItemsViewModel viewModel;
    private Region root;

    public void init(ViewHandler handler, FilterItemsViewModel viewModel, Region root){

        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;
        ObservableList<String> times = FXCollections.observableArrayList(
                        "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18");
        startTime.setItems(times);
        endTime.setItems(times);

        viewModel.bindItemsAmount(itemsNum.textProperty());
        itemsNum.textProperty().addListener(((observableValue, s, t1) -> {
            if(Integer.parseInt(t1) > 0){
                startDate.setDisable(true);
                endDate.setDisable(true);
                startTime.setDisable(true);
                endTime.setDisable(true);
            }else{
                startDate.setDisable(false);
                endDate.setDisable(false);
                startTime.setDisable(false);
                endTime.setDisable(false);
            }
        }));

        try {
            type.setItems(FXCollections.observableArrayList(viewModel.getItemTypes()));
        } catch (SQLException e) {
            new DatabaseAlert();
        } catch (RemoteException e) {
            new ServerAlert();
        }
        viewModel.bindSearchedItems(itemsList.itemsProperty());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

    };

    @FXML
    void add() {
        try{
            viewModel.addToBasket(itemsList.getSelectionModel().getSelectedItem());
        }catch (DuplicateRequestException e){
            new ErrorAlert("This item is already in the shopping cart");
        }
    }

    @FXML
    void cancel() {
        viewModel.clear();
        handler.openView(MENU_VIEW);
    }

    @FXML
    void clear(){
        viewModel.clear();
    }

    @FXML
    void cart() {
        handler.openView(RENT_VIEW);
    }

    @FXML
    void search() {

        LocalDateTime start, end;
        try {
            start = LocalDateTime.of(startDate.getValue(), LocalTime.of(Integer.parseInt(startTime.getValue()), 0));
            end = LocalDateTime.of(endDate.getValue(), LocalTime.of(Integer.parseInt(endTime.getValue()), 0));
        }catch (NullPointerException | NumberFormatException e){
            new ErrorAlert("You have to specify start and end date of the rent");
            return;
        }

        String type = this.type.getValue();

        try{
            int sizeMin = (this.sizeMin.getText().equals("")) ? 0 : Integer.parseInt(this.sizeMin.getText());
            int sizeMax = (this.sizeMax.getText().equals("")) ? 1000000 : Integer.parseInt(this.sizeMax.getText());
            double priceMin = (this.priceMin.getText().equals("")) ? 0 : Double.parseDouble(this.priceMin.getText());
            double priceMax = (this.priceMax.getText().equals("")) ? 1000000 : Double.parseDouble(this.priceMax.getText());
            viewModel.getItems(start, end, type, sizeMin, sizeMax, priceMin, priceMax);
        }catch (NumberFormatException e) {
            new ErrorAlert("Incorrect format of the search information");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Region getRoot() {
        return root;
    }
}
