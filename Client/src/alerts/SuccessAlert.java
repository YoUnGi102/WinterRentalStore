package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class SuccessAlert extends Alert {

    public SuccessAlert(String message) {
        super(AlertType.NONE);
        setContentText(message);
        setTitle("Success");
        getButtonTypes().add(ButtonType.OK);
        show();
    }
}
