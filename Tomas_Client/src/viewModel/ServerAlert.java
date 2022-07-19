package dk.via.client.viewModel;

import javafx.scene.control.Alert;

public class ServerAlert extends Alert {

    public ServerAlert() {
        super(AlertType.ERROR);
        setContentText("It appears there is a problem with the server");
    }
}
