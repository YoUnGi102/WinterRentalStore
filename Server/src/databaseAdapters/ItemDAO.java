package databaseAdapters;

import model.Item;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
public interface ItemDAO {
    void insert(Item item, int numberOfPieces) throws SQLException;
    void delete(Item item) throws SQLException;
    ArrayList<Item> select(LocalDateTime start, LocalDateTime end, String type, int minSize, int maxSize, double minPrice, double maxPrice) throws SQLException;
    void update(Item item) throws SQLException;

}
