package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ServerAlert extends Alert {

    public ServerAlert() {
        super(AlertType.NONE);
        setContentText("Unable to Connect to the Server");
        getButtonTypes().add(ButtonType.OK);
        show();
    }
}
