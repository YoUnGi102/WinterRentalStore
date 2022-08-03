import databaseAdapters.*;
import javafx.collections.ObservableList;
import model.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        ItemDAO itemDAO = new ItemImplementation();
        LocalDateTime start = LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(8, 0));
        LocalDateTime end = LocalDateTime.of(LocalDate.of(2022, 1, 2), LocalTime.of(8, 0));
        for (Item i : itemDAO.select(start, end, "", 0, 1000, 0, 1000)) {
            System.out.println(i.getType() + " " + i.getName());
        }


    }

}
