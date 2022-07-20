package viewModel;

import mediator.RemoteModel;

public class ViewModelFactory {
    private RemoteModel model;
    private LogInViewModel logInViewModel;
    private ManageItemViewModel manageItemViewModel;
    private ManageEmployeeViewModel manageEmployeeViewModel;

    public ViewModelFactory(RemoteModel model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
        this.manageItemViewModel = new ManageItemViewModel(model);
        this.manageEmployeeViewModel = new ManageEmployeeViewModel(model);
    }

    public LogInViewModel getLoginViewModel() {
        return logInViewModel;
    }

    public ManageItemViewModel getManageItemViewModel() {
        return manageItemViewModel;
    }

    public ManageEmployeeViewModel getManageEmployeeViewModel() {
        return manageEmployeeViewModel;
    }
}