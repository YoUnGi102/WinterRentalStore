import databaseAdapters.*;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import mediator.Server;
import model.*;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.SHA256Digest;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;

public class test {

    public static void main(String[] args) throws SQLException {

//        StaffDAO staffDAO = new StaffImplementation();
//        try {
//            Staff staff = staffDAO.logIn("admin", "password");
//            System.out.println(staff);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        StaffDAO staffDAO = new StaffImplementation();
        System.out.println(staffDAO.logIn("admin", "password").getUserType());
        System.out.println();

        staffDAO.insert(new Staff("morgan.jones", "morgan.jones@gmail.com", "Morgan", "Jones", "employee"), "password");


//        RentDAO rentDAO = new RentImplementation();
//        ItemDAO itemDAO = new ItemImplementation();
//
//        LocalDateTime start = LocalDateTime.now();
//        LocalDateTime end = start.plus(2, ChronoUnit.DAYS);
//        ArrayList<Item> items = new ArrayList<>();
//        items.add(new Item(1, "Skdksd", "skis", 9, "", 3));
//        Staff staff = new Staff("admin", "", "", "", "");
//        Customer customer = new Customer("John", "Way", "02293434", "", "");
//        try {
//            rentDAO.insert(new Rent(start, end, customer, items, staff, 30));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

}
