package viewModel;

import javafx.beans.property.Property;
import model.Item;
import model.Model;

import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddItemViewModel {

    private Model model;
    public AddItemViewModel(Model model){
        this.model = model;
    }
    public ArrayList<String> getItemTypes() throws SQLException, RemoteException {
        return model.getItemTypes();
    }
    public HashMap<String, String> getTypeUnitParis() throws SQLException, RemoteException {
        return model.getTypeUnitPairs();
    }

    public void addItem(Item item, int numberOfPieces) throws SQLException, NotBoundException, RemoteException {
        model.addItem(item, numberOfPieces);
    }
    public void addType(String type, String sizeUnit) throws SQLException, NotBoundException, RemoteException {
        model.addType(type, sizeUnit);
    }


}
