package databaseAdapters;

import model.Item;
import model.Staff;

import javax.xml.crypto.Data;
import java.sql.*;

import static databaseAdapters.DatabaseConnection.SCHEMA;

public class ItemImplementation implements ItemDAO{

    public static final String ITEM_TABLE = "item";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String SIZE = "size";
    public static final String PRICE = "pricePerDay";
    public static final String INVENTORY_ITEM_TABLE = "inventoryItem";

    public static final String ITEM_ID = "itemId";

    private DatabaseConnection databaseConnection;

    public ItemImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public void insert(Item item, int numberOfPieces) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        String sql = "INSERT INTO "  + SCHEMA + "." + ITEM_TABLE + "(" + NAME + "," + TYPE + "," + SIZE + "," + PRICE + ")" +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,  item.getName());
        statement.setString(2, item.getType());
        statement.setInt(3, item.getSize());
        statement.setDouble(4, item.getPricePerDay());
        statement.executeUpdate();

        ResultSet set = statement.getGeneratedKeys();
        if(set.next()){
            int key = set.getInt(1);
            System.out.println(key);
            for (int i = 0; i < numberOfPieces; i++) {
                statement = connection.prepareStatement("INSERT INTO "  + SCHEMA + "." + INVENTORY_ITEM_TABLE + "(" + ITEM_ID + ")" + "VALUES (?)");
                statement.setInt(1, key);
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void delete(Item item) throws SQLException {

    }

    @Override
    public void update(Item item) throws SQLException {

    }
}
