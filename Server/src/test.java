import databaseAdapters.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();



    }

}
