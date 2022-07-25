package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class DatabaseAlert extends Alert {

    public DatabaseAlert() {
        super(Alert.AlertType.NONE);
        setContentText("There is a problem connecting to the database.");
        getButtonTypes().add(ButtonType.OK);
        show();
    }

}
