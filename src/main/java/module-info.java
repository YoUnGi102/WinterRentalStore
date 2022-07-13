module com.example.winterrentalstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    opens com.example.winterrentalstore.model to java.rmi;
    exports com.example.winterrentalstore.model;
    opens com.example.winterrentalstore to javafx.graphics, javafx.fxml;
    exports com.example.winterrentalstore;
    opens com.example.winterrentalstore.view to javafx.graphics, javafx.fxml;
    exports com.example.winterrentalstore.view;
    opens com.example.winterrentalstore.server to java.rmi;
    exports com.example.winterrentalstore.server;
}