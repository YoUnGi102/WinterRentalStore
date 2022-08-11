package databaseAdapters;

import model.Item;
import model.Staff;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static databaseAdapters.DatabaseConnection.SCHEMA;
import static databaseAdapters.TypeImplementation.SIZE_UNIT;

public class ItemImplementation implements ItemDAO{

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
    public static final String ITEM_TABLE = "item";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String SIZE = "size";
    public static final String PRICE = "pricePerDay";
    public static final String INVENTORY_ITEM_TABLE = "inventoryItem";

    public static final String INVENTORY_ITEM_ID = "inventoryId";
    public static final String ITEM_ID = "itemId";

    private DatabaseConnection databaseConnection;

    public ItemImplementation(){
        databaseConnection = DatabaseConnection.getInstance();
    }
    @Override
    public void insert(Item item, int numberOfPieces) throws SQLException {

        if(numberOfPieces == 0){
            throw new IllegalArgumentException("You cannot add 0 items to the system!");
        }

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
    public ArrayList<Item> select(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws SQLException {
        ArrayList<Item> items = new ArrayList<>();

        System.out.println(FORMATTER.format(start) + " " + FORMATTER.format(end));

        Connection connection = databaseConnection.getConnection();
        System.out.println("type " + type);
        String sql = String.format(
                "SELECT inventoryId, name, I.type, size, pricePerDay, T.sizeUnit " +
                        "FROM InventoryItem II " +
                        "INNER JOIN Item I on II.itemId = I.itemId " +
                        "INNER JOIN Type T on I.type = T.type " +
                        "WHERE inventoryId NOT IN (SELECT inventoryitemId FROM RentedItem) and I.size >= ?::int and I.size <= ?::int and I.pricePerDay >= ?::double precision and " +
                        "I.pricePerDay < ?::double precision " + (type == null || type.equals("") ?" ":"and I.type = ? ") +
                        "UNION " +
                        "SELECT inventoryId, name, I.type, size, pricePerDay, T.sizeUnit " +
                        "FROM InventoryItem II " +
                        "INNER JOIN Item I on II.itemId = I.itemId " +
                        "INNER JOIN Type T on T.type = I.type " +
                        "INNER JOIN RentedItem RI on II.inventoryId = RI.inventoryItemId " +
                        "INNER JOIN Rent R on RI.rentId = R.rentId " +
                        "WHERE (R.startDateTime > ?::timestamp or R.endDateTime < ?::timestamp) " +
                        "and I.size >= ? and I.size <= ? and I.pricePerDay >= ? and I.pricePerDay <= ?" + (type == null || type.equals("") ?" ":"and I.type = ? "));
        System.out.println(sql);
        System.out.println("minSize: " + minSize + "\nmaxSize: " + maxSize + "\nminPrice: " + minPrice + "\nmaxPrice: "+maxPrice);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, minSize);
        statement.setInt(2, maxSize);
        statement.setDouble(3, minPrice);
        statement.setDouble(4, maxPrice);

        if(type == null || type.equals("")){
            statement.setString(5, FORMATTER.format(start));
            statement.setString(6, FORMATTER.format(start));
            statement.setInt(7, minSize);
            statement.setInt(8, maxSize);
            statement.setDouble(9, minPrice);
            statement.setDouble(10, maxPrice);
        }else {
            statement.setString(5, type);
            statement.setString(6, FORMATTER.format(start));
            statement.setString(7, FORMATTER.format(start));
            statement.setInt(8, minSize);
            statement.setInt(9, maxSize);
            statement.setDouble(10, minPrice);
            statement.setDouble(11, maxPrice);
            statement.setString(12, type);
        }

        ResultSet set = statement.executeQuery();
        while(set.next()){
            int id = set.getInt(INVENTORY_ITEM_ID);
            String resName = set.getString(NAME);
            String resType = set.getString(TYPE);
            String resUnit = set.getString(SIZE_UNIT);
            int resSize = set.getInt(SIZE);
            double resPrice = set.getDouble(PRICE);
            Item item = new Item(id, resName, resType, resSize, resUnit, resPrice);
            items.add(item);
        }

        connection.close();
        return items;
    }
    @Override
    public void update(Item item) throws SQLException {

    }
}
