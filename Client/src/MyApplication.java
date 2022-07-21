import javafx.stage.Stage;
import mediator.RemoteModel;
import model.Employee;
import view.ViewHandler;
import viewModel.ViewModelFactory;

import java.io.IOException;
import java.rmi.NotBoundException;

public class MyApplication extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        RemoteModel server = null;
        try {
            server = (RemoteModel) java.rmi.Naming.lookup("rmi://localhost:1099/RMIServer");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
        ViewModelFactory viewModelFactory = new ViewModelFactory(server);
        Employee testEmployee = new Employee("jim", "Jim", "Slim", "jim@john.com", "google", "Employee");
        viewModelFactory.getManageEmployeeViewModel().setEmployee(testEmployee);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }
}