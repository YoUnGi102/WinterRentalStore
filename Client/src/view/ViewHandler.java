package view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.ViewModelFactory;

public class ViewHandler {
    public static final String EMPLOYEE_VIEW = "manage_employee_view.fxml";
    public static final String LOGIN_VIEW = "login-view.fxml";
    public static final String ADD_ITEM_VIEW = "add-item-view.fxml";
    public static final String MANAGE_ITEM_VIEW = "manage-item-view.fxml";
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
        openView(MANAGE_ITEM_VIEW);
    }

    public void openView(String viewId) {

        Region root = null;

        switch (viewId) {
            case LOGIN_VIEW:
                root = viewFactory.loadLoginView();
                break;
            case EMPLOYEE_VIEW:
                root = viewFactory.loadEmployeeView();
                break;
            case MANAGE_ITEM_VIEW:
                root = viewFactory.loadManageItemView();
                break;
            case ADD_ITEM_VIEW:
                root = viewFactory.loadAddItemView();
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
