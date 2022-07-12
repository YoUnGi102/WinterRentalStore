module com.example.winterrentalstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.winterrentalstore to javafx.fxml;
    exports com.example.winterrentalstore;
}