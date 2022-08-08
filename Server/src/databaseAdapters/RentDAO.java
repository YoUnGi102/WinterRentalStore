package databaseAdapters;

import model.Rent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentDAO {

    void insert(Rent rent) throws SQLException;
    ArrayList<Rent> selectRents(String keyWord);
    void update(Rent rent);
    void delete(Rent rent);

}
