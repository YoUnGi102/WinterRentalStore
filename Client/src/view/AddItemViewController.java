package view;

import alerts.DatabaseAlert;
import alerts.ErrorAlert;
import alerts.ServerAlert;
import alerts.SuccessAlert;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import mediator.RemoteModel;
import model.Item;
import viewModel.AddItemViewModel;
import viewModel.ManageItemViewModel;

import javax.xml.namespace.QName;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

public class AddItemViewController {

    @FXML private ChoiceBox<String> type;
    @FXML private TextField name, customType, customUnit, size, price, pieces;

    @FXML
    private HBox custom;

    @FXML
    private Label unit;

    private ViewHandler handler;
    private AddItemViewModel viewModel;
    private Region root;

    private HashMap<String, String> typeUnitPairs;

    public void init(ViewHandler handler, AddItemViewModel viewModel, Region root){
        this.handler = handler;
        this.viewModel = viewModel;
        this.root = root;

        custom.setVisible(false);
        custom.setManaged(false);

        ObservableList<String> itemTypes = FXCollections.observableArrayList();
//        try {
        try {
            itemTypes.addAll(viewModel.getItemTypes());
            typeUnitPairs = viewModel.getTypeUnitParis();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        itemTypes.add("custom");
//        } catch (SQLException | RemoteException e) {
//            new ServerAlert();
//            handler.openView(ViewHandler.MANAGE_ITEM_VIEW);
//        }

        type.setItems(itemTypes);
        type.setValue(itemTypes.get(0));

        type.valueProperty().addListener((observableValue, oldVal, newVal) -> {
            if(newVal.equals("custom")){
                custom.setVisible(true);
                custom.setManaged(true);
                unit.setText("");
            }else{
                unit.setText(typeUnitPairs.get(newVal));
                custom.setVisible(false);
                custom.setManaged(false);
            }
        });

    }

    @FXML
    void cancel() {
        clear();
        handler.openView(ViewHandler.MANAGE_ITEM_VIEW);
    }

    @FXML
    void confirm() throws SQLException, NotBoundException, RemoteException {

            if(name.getText().equals("") || type.getValue() == null ||
                    size.getText().equals("") ||
                    price.getText().equals("") ||
                    pieces.getText().equals("")){
                new ErrorAlert("Some of the fields were left empty");
                return;
            }

            String name = this.name.getText();
            String type = this.type.getValue();
            String sizeUnit = typeUnitPairs.get(type);
            if (type.equals("custom")) {
                type = customType.getText();
                for (String key : typeUnitPairs.keySet()) {
                    if(key.equals("type")){
                        new ErrorAlert("The type of item you entered already exists");
                        return;
                    }
                }
                sizeUnit = customUnit.getText();
                viewModel.addType(type, sizeUnit);
            }

            Integer size = null, pieces = null;
            Double price = null;
            try{
                size = Integer.parseInt(this.size.getText());
            }catch(NumberFormatException e){
                new ErrorAlert("Entered information (size) is invalid");
                return;
            }
            try{
                price = Double.parseDouble(this.price.getText());
            }catch(NumberFormatException e){
                new ErrorAlert("Entered information (price) is invalid");
                return;
            }
            try{
                pieces = Integer.parseInt(this.pieces.getText());
            }catch(NumberFormatException e){
                new ErrorAlert("Entered information (pieces) is invalid");
                return;
            }



            Item item = new Item(name, type, size, sizeUnit, price);

        try {
            viewModel.addItem(item, pieces);
            handler.openView(ViewHandler.MANAGE_ITEM_VIEW);
            new SuccessAlert(pieces + " items were successfully added to the inventory");
            clear();
        } catch (SQLException e) {
            new DatabaseAlert();
        } catch (NotBoundException | RemoteException e) {
            new ServerAlert();
        }
    }

    public void clear(){
        name.clear();
        type.setValue("skis");
        size.clear();
        price.clear();
        pieces.clear();
    }

    public Region getRoot() {
        return root;
    }
}
