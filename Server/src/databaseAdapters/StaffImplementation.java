package databaseAdapters;

import javafx.collections.ObservableList;
import model.Staff;

import javax.xml.crypto.Data;
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
    private static final String STAFF_TYPE = "staffType";
    private DatabaseConnection databaseConnection;

    public StaffImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public void insert(Staff staff, String password) throws SQLException {
//        try(Connection connection = databaseConnection.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + SCHEMA + "." + TABLE_NAME +
//                    "("+ROOM_NUMBER+", "+DATE_FROM+", "+DATE_TO+ ", " + USERNAME + ") VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
//            statement.setInt(1, booking.getRoom().getRoomNumber());
//            statement.setDate(2, Date.valueOf(DATE_FORMATTER.format(booking.getDateFrom())));
//            statement.setDate(3, Date.valueOf(DATE_FORMATTER.format(booking.getDateTo())));
//            statement.setString(4, booking.getCreatedBy().getUsername());
//            statement.executeUpdate();
//
//            ResultSet keys = statement.getGeneratedKeys();
//            if (keys.next()) {
//                booking.setBookingId(keys.getInt(1));
//            } else {
//                throw new SQLException("No keys generated");
//            }
//
//            StringBuilder sql = new StringBuilder("INSERT INTO " + SCHEMA+"."+GUEST_BOOKING_TABLE +
//                    "("+BOOKING_ID+", "+GUEST_ID+") VALUES ");
//            for (int i = 0; i < booking.getGuests().size(); i++) {
//                if(i != booking.getGuests().size()-1)
//                    sql.append("(?,?),");
//                else
//                    sql.append("(?,?);");
//            }
//
//            statement = connection.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
//
//            int counter = 0;
//            for (Guest guest : booking.getGuests()) {
//                statement.setInt(counter*2+1, booking.getBookingId());
//                statement.setString(counter*2+2, guest.getPassportNumber());
//                counter++;
//            }
//            statement.executeUpdate();
//
//        }
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
