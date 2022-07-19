module dk.via.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.rmi;
    requires dk.via.server;

    opens dk.via.client to javafx.fxml;
    exports dk.via.client;
    exports dk.via.client.view;
    opens dk.via.client.view to javafx.fxml;
    exports dk.via.client.model;
    opens dk.via.client.model to javafx.fxml;
    exports dk.via.client.viewModel;
    opens dk.via.client.viewModel to javafx.fxml;
}