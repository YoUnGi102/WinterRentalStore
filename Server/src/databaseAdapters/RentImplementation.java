package databaseAdapters;

import model.Item;
import model.Rent;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

import static databaseAdapters.DatabaseConnection.SCHEMA;
import static databaseAdapters.ItemImplementation.FORMATTER;

public class RentImplementation implements RentDAO {

    public static final String RENT_TABLE = "rent";
    public static final String START_DATE_TIME = "startDateTime";
    public static final String END_DATE_TIME = "endDateTime";
    public static final String USERNAME = "username";
    public static final String PASSPORT_NUMBER = "passportNumber";
    public static final String TOTAL = "total";

    public static final String RENTED_ITEM_TABLE = "RentedItem";

    private DatabaseConnection databaseConnection;

    public RentImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public void insert(Rent rent) throws SQLException {

        Connection connection = databaseConnection.getConnection();

        String sql = "INSERT INTO "  + SCHEMA + "." + RENT_TABLE + "(" + START_DATE_TIME + "," + END_DATE_TIME + "," + USERNAME + "," + PASSPORT_NUMBER + ", " + TOTAL + ") VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,  rent.getStart().format(FORMATTER));
        statement.setString(2, rent.getEnd().format(FORMATTER));
        statement.setString(3, rent.getStaff().getUsername());
        statement.setString(4, rent.getCustomer().getPassportNumber());
        statement.setDouble(5, rent.getTotal());
        statement.executeUpdate();

        ResultSet set = statement.getGeneratedKeys();
        int id = set.getInt("rentId");
        for (Item i : rent.getItems()) {
            statement = connection.prepareStatement("INSERT INTO "+SCHEMA+"."+RENTED_ITEM_TABLE+"(rentId, inventoryItemId) VALUES (?,?)");
            statement.setInt(1, id);
            statement.setInt(2, i.getItemId());
        }
    }

    @Override
    public ArrayList<Rent> selectRents(String keyWord) {
        return null;
    }
    @Override
    public void update(Rent rent) {
    }
    @Override
    public void delete(Rent rent) {
    }


}
