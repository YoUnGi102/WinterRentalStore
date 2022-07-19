package viewModel;

import mediator.RemoteModel;

public class ViewModelFactory {
    private RemoteModel model;
    private LogInViewModel logInViewModel;

    public ViewModelFactory(RemoteModel model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
    }

    public LogInViewModel getLoginViewModel() {
        return logInViewModel;
    }
}
