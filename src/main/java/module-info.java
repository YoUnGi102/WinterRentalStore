module com.example.winterrentalstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.winterrentalstore to javafx.fxml;
    exports com.example.winterrentalstore;
}