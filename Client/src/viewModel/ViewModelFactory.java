package viewModel;

import mediator.RemoteModel;

public class ViewModelFactory {
    private RemoteModel model;
    private LogInViewModel logInViewModel;
    private ManageItemViewModel manageItemViewModel;
    private ManageEmployeeViewModel manageEmployeeViewModel;

    private AddItemViewModel addItemViewModel;
    public ViewModelFactory(RemoteModel model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
        this.manageItemViewModel = new ManageItemViewModel(model);
        this.manageEmployeeViewModel = new ManageEmployeeViewModel(model);
        this.addItemViewModel = new AddItemViewModel(model);
    }

    public AddItemViewModel getAddItemViewModel() {return addItemViewModel;}
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
