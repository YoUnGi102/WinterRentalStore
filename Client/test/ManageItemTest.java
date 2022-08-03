import mediator.RemoteModel;
import model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ManageItemTest {

    RemoteModel model;

    @BeforeEach
    void initModel() throws MalformedURLException, NotBoundException, RemoteException {
        model = (RemoteModel) java.rmi.Naming.lookup("rmi://localhost:1099/RMIServer");
    }

    @Test
    void addNullItem() {
        Assertions.assertThrows(NullPointerException.class, () -> {model.addItem(null, 1);});
    }

    @Test
    void addZeroItems() {
        Item item = new Item("Test Item 1", "skis", 120, "cm", 10);
        Assertions.assertThrows(IllegalArgumentException.class, ()->model.addItem(item, 0));
    }

    @Test
    void addOneItem() throws SQLException, NotBoundException, RemoteException {
        Item item = new Item("Test Item 1", "skis", 120, "cm", 10);
        model.addItem(item, 1);
        // TODO GET ITEM BY NAME TO CHECK
    }

    @Test
    void addNewType() throws SQLException, NotBoundException, RemoteException {
        String type = "Test type";
        String unit = "Test unit";
        model.addType(type, unit);
        Assertions.assertTrue(model.getItemTypes().contains(type));
    }

    @Test
    void addMultipleItems() throws SQLException, NotBoundException, RemoteException {
        Item item = new Item("Test Item 2", "snowboard", 160, "cm", 23);
        model.addItem(item, 3);
        // TODO GET ITEM BY NAME TO CHECK
    }




}
