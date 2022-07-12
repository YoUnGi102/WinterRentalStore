package viewModel;

import model.Model;

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
