package databaseAdapters;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;

import static databaseAdapters.DatabaseConnection.SCHEMA;

public class CustomerImplementation implements CustomerDAO {

    public static final String CUSTOMER_TABLE = "customer";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASSPORT = "passportNumber";
    public static final String PHONE = "phoneNumber";

    private DatabaseConnection databaseConnection;

    public CustomerImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        String sql = "INSERT INTO "  + SCHEMA + "." + CUSTOMER_TABLE + "(" + FIRST_NAME + "," + LAST_NAME + "," + EMAIL + "," + PHONE + ", "+ PASSPORT+") " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,  customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3,  customer.getEmail());
        statement.setString(4, customer.getPhoneNumber());
        statement.setString(5, customer.getPassportNumber());
        statement.executeUpdate();

        connection.close();
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public ArrayList<Customer> select(String keyWord) throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();

        Connection connection = databaseConnection.getConnection();

        String sql = "SELECT * " +
                "FROM Customer c " +
                "WHERE (c.email LIKE ?) OR (c.passportNumber LIKE ?) OR (c.phoneNumber LIKE ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,  "%"+keyWord+"%");
        statement.setString(2, "%"+keyWord+"%");
        statement.setString(3,  "%"+keyWord+"%");
        ResultSet set = statement.executeQuery();

        while(set.next()){
            String fName = set.getString(FIRST_NAME);
            String lName = set.getString(LAST_NAME);
            String passport = set.getString(PASSPORT);
            String phone = set.getString(PHONE);
            String email = set.getString(EMAIL);
            customers.add(new Customer(fName, lName, passport, phone, email));
        }

        connection.close();

        return customers;
    }

    @Override
    public void update(Customer customer) {
    }

}
