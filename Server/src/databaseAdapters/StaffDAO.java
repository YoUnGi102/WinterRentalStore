package databaseAdapters;

import javafx.collections.ObservableList;
import model.Staff;

import java.sql.SQLException;

public interface StaffDAO {

    void insert(Staff staff, String password) throws SQLException;
    void delete(Staff staff) throws SQLException;
    ObservableList<Staff> select(String keyWord) throws SQLException;
    void update(Staff staff) throws SQLException;
    Staff logIn(String username, String password) throws SQLException;
    void changePassword(Staff staff, String oldPassword, String newPassword);

}
