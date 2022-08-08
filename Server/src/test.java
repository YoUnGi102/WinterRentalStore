import databaseAdapters.*;
import javafx.collections.ObservableList;
import mediator.RemoteModel;
import mediator.Server;
import model.Customer;
import model.Item;
import model.Model;
import model.ModelManager;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class test {

    public static void main(String[] args) {
        RemoteModel remoteModel;
        try {
            remoteModel = new Server();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Model model = new ModelManager();

        CustomerDAO dao = new CustomerImplementation();
        try {
            for (Customer c : remoteModel.getCustomers("")) {
                System.out.println(c.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
//
//
//        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
//        Connection connection = databaseConnection.getConnection();
//
//        ItemDAO itemDAO = new ItemImplementation();
//        LocalDateTime start = LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(8, 0));
//        LocalDateTime end = LocalDateTime.of(LocalDate.of(2022, 1, 2), LocalTime.of(8, 0));
//        for (Item i : itemDAO.select(start, end, "", 0, 1000, 0, 1000)) {
//            System.out.println(i.getType() + " " + i.getName());
//        }


    }

}
