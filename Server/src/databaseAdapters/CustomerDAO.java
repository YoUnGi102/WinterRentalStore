package databaseAdapters;

import model.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {

    void insert(Customer customer) throws SQLException;
    void delete(Customer customer);
    ArrayList<Customer> select(String keyWord) throws SQLException;
    void update(Customer customer);

}
