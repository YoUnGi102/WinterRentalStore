package view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.ViewModelFactory;

public class ViewHandler {

    public static final String LOGIN_VIEW = "login-view.fxml";
    public static final String EMPLOYEE_VIEW = "manage_employee_view.fxml";
    private final ViewFactory viewFactory;
    private final Scene scene;

    private ViewModelFactory viewModelFactory;
    private Stage stage;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.scene = new Scene(new Region());
    }

    public void start(Stage stage) {
        this.stage = stage;
        openView(LOGIN_VIEW);
    }

    public void openView(String viewId) {

        Region root = viewFactory.loadLoginView(); // only opens the login view for now

        switch (viewId) {
            case LOGIN_VIEW: {
                root = viewFactory.loadLoginView();
                break;
            }
            case EMPLOYEE_VIEW:
                root = viewFactory.loadEmployeeView();
                break;
            default:
                throw new IllegalArgumentException("View with this ID does not exist");
        }

        scene.setRoot(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public void closeView() {
        stage.close();
    }

}
