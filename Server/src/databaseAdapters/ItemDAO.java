package databaseAdapters;

import javafx.collections.ObservableList;
import model.Item;
import model.Staff;

import java.sql.SQLException;
import java.util.HashMap;

public interface ItemDAO {

    void insert(Item item, int numberOfPieces) throws SQLException;
    void delete(Item item) throws SQLException;
    // TODO FILTERING ObservableList<Item> select(String) throws SQLException;
    void update(Item item) throws SQLException;

}
