package databaseAdapters;

import javafx.collections.ObservableList;
import model.Staff;

import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static databaseAdapters.DatabaseConnection.SCHEMA;

public class StaffImplementation implements StaffDAO {
    private static final String TABLE_NAME = "staff";
    private static final String USERNAME = "username";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String STAFF_TYPE = "stafftype";
    private DatabaseConnection databaseConnection;

    public StaffImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public void insert(Staff staff, String password) throws SQLException {

        try(Connection connection = databaseConnection.getConnection()) {
            String sql = "INSERT INTO " + SCHEMA+"."+TABLE_NAME + " ("+USERNAME+", "+EMAIL+", "+PASSWORD+", "+FIRST_NAME+", "+LAST_NAME+", "+STAFF_TYPE+") VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, staff.getUsername());
            statement.setString(2, staff.getEmail());
            statement.setString(3, password);
            statement.setString(4, staff.getFirstName());
            statement.setString(5, staff.getLastName());
            statement.setString(6, staff.getUserType());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Staff staff) throws SQLException{

    }

    @Override
    public ObservableList<Staff> select(String keyWord) throws SQLException{
        return null;
    }

    @Override
    public void update(Staff staff) throws SQLException{

    }

    @Override
    public Staff logIn(String username, String password) throws SQLException {

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Connection connection = databaseConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM "  + SCHEMA + "." + TABLE_NAME + " WHERE " + USERNAME + " = ? AND " + PASSWORD + " = ?");
        statement.setString(1,  username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            String resUsername = resultSet.getString(USERNAME);
            String resEmail = resultSet.getString(EMAIL);
            String resFName = resultSet.getString(FIRST_NAME);
            String resLName = resultSet.getString(LAST_NAME);
            String resStaffType = resultSet.getString(STAFF_TYPE);
            System.out.println(resStaffType);
            connection.close();
            return new Staff(resUsername, resEmail, resFName, resLName, resStaffType);
        } else {
            connection.close();
            return null;
        }
    }

    @Override
    public void changePassword(Staff staff, String oldPassword, String newPassword) {

    }


}
