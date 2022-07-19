package dk.via.client.viewModel;

import dk.via.client.model.Model;
import dk.via.client.viewModel.LogInViewModel;

public class ViewModelFactory {
    private Model model;
    private LogInViewModel logInViewModel;

    public ViewModelFactory(Model model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
    }

    public LogInViewModel getLoginViewModel() {
        return logInViewModel;
    }
}
