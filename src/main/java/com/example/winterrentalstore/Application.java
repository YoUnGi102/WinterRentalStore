package com.example.winterrentalstore;

import com.example.winterrentalstore.model.Model;
import com.example.winterrentalstore.model.ModelManager;
import com.example.winterrentalstore.view.ViewHandler;
import com.example.winterrentalstore.viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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