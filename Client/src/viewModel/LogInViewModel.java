package viewModel;

import model.Model;

public class LogInViewModel {
    private Model model;

    public LogInViewModel(Model model){
        this.model=model;
    }
    public void logIn(String username, String password) {
    model.logIn(username, password);
    }
}
