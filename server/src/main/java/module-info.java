module dk.via.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens dk.via.server to javafx.fxml;
    exports dk.via.server;
    exports dk.via;
    opens dk.via to javafx.fxml;
}