import databaseAdapters.*;
import javafx.collections.ObservableList;
import model.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        ItemDAO itemDAO = new ItemImplementation();
        Item item = new Item("Random SKIS", "skis", 150, "cm", 20);
        itemDAO.insert(item, 3);


    }

}
