package databaseAdapters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String USERNAME = "cgvfnzab";
    private static final String PASSWORD = "9tlfavFzzVjEzdgOQrSG-gRxqj-SDNLJ";
    private static final String DATABASE = "cgvfnzab";
    private static final String HOST = "abul.db.elephantsql.com";
    private static final String URL = "jdbc:postgresql://"+HOST+"/"+DATABASE;
    public static final String SCHEMA = "public";

    private static final DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
