import javafx.application.Application;
import mediator.RemoteModel;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginTest {

    RemoteModel model;

    @BeforeEach
    void initModel(){
        try {
            model = (RemoteModel) java.rmi.Naming.lookup("rmi://localhost:1099/RMIServer");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loginWithIncorrectParameters(){
        String username = "john";
        String password = "pass";
        try {
            Assertions.assertFalse(model.logIn(username, password));
        } catch (NotBoundException | RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loginWithCorrectParameters() {
        String username = "admin";
        String password = "password";
        try {
            Assertions.assertTrue(model.logIn(username, password));
        } catch (NotBoundException | RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
