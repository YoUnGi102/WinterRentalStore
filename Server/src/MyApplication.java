import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mediator.Server;

import java.io.IOException;
import java.rmi.NotBoundException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            new Server();
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("view/server-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}