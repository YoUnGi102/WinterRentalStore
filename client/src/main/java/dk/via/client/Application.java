package dk.via.client;

import dk.via.client.model.Model;
import dk.via.client.model.ModelManager;
import dk.via.client.view.ViewHandler;
import dk.via.client.viewModel.ViewModelFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model modelManager = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelManager);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}