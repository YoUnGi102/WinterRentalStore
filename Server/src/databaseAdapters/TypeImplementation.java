package databaseAdapters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Staff;

import javax.xml.crypto.Data;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static databaseAdapters.DatabaseConnection.SCHEMA;

public class TypeImplementation implements TypeDAO {


    public static final String TABLE_NAME = "type";
    public static final String TYPE = "type";
    public static final String SIZE_UNIT = "sizeUnit";

    private DatabaseConnection databaseConnection;

    public TypeImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public ArrayList<String> selectTypes() throws SQLException {

        ArrayList<String> types = new ArrayList<>();

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT "+TYPE+" FROM "  + SCHEMA + "." + TABLE_NAME);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            types.add(resultSet.getString(TYPE));
        }

        connection.close();
        return types;
    }

    @Override
    public HashMap<String, String> selectTypeUnitPairs() throws SQLException {

        HashMap<String, String> typeUnitPairs = new HashMap<>();

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT "+TYPE + ", " + SIZE_UNIT+" FROM "  + SCHEMA + "." + TABLE_NAME);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            typeUnitPairs.put(resultSet.getString(TYPE), resultSet.getString(SIZE_UNIT));
        }

        connection.close();
        return typeUnitPairs;
    }

    @Override
    public void insert(String type, String sizeUnit) throws SQLException {

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO " + SCHEMA +"."+TABLE_NAME + "(" +TYPE + ", " + SIZE_UNIT+") VALUES (?,?)");
        statement.setString(1, type);
        statement.setString(2, sizeUnit);
        statement.executeUpdate();

        connection.close();
    }
}
