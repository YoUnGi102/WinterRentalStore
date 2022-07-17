package com.example.winterrentalstore.viewModel;

import com.example.winterrentalstore.model.Model;

public class ViewModelFactory {
    private Model model;
    private LogInViewModel logInViewModel;
    private ManageItemViewModel manageItemViewModel;

    public ViewModelFactory(Model model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
        this.manageItemViewModel = new ManageItemViewModel(model);
    }

    public LogInViewModel getLoginViewModel() {
        return logInViewModel;
    }

    public ManageItemViewModel getManageItemViewModel() {
        return manageItemViewModel;
    }
}
