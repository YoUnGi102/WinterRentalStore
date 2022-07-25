package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ErrorAlert extends Alert {

    public ErrorAlert(String message) {
        super(AlertType.NONE);
        setContentText(message);
        setTitle("Error");
        getButtonTypes().add(ButtonType.OK);
        show();
    }

}
