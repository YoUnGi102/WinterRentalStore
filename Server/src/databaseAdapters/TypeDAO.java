package databaseAdapters;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface TypeDAO {

    ArrayList<String> selectTypes() throws SQLException;
    HashMap<String, String> selectTypeUnitPairs() throws SQLException;
    void insert(String type, String sizeUnit);

}
