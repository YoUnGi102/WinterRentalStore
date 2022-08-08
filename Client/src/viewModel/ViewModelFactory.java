package viewModel;

import mediator.RemoteModel;

public class ViewModelFactory {
    private RemoteModel model;
    private LogInViewModel logInViewModel;
    private ManageItemViewModel manageItemViewModel;
    private ManageEmployeeViewModel manageEmployeeViewModel;
    private MenuViewModel menuViewModel;
    private AddItemViewModel addItemViewModel;
    private FilterItemsViewModel filterItemsViewModel;

    private FilterCustomersViewModel filterCustomersViewModel;

    private AddCustomerViewModel addCustomerViewModel;
    private RentViewModel rentViewModel;
    public ViewModelFactory(RemoteModel model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
        this.manageItemViewModel = new ManageItemViewModel(model);
        this.manageEmployeeViewModel = new ManageEmployeeViewModel(model);
        this.addItemViewModel = new AddItemViewModel(model);
        this.menuViewModel = new MenuViewModel(model);
        this.rentViewModel = new RentViewModel(model);
        this.filterItemsViewModel = new FilterItemsViewModel(model);
        this.addCustomerViewModel = new AddCustomerViewModel(model);
        this.filterCustomersViewModel = new FilterCustomersViewModel(model);
        rentViewModel.setFilterItemsListener(filterItemsViewModel);
        filterItemsViewModel.setRentViewModelListener(rentViewModel);
        filterCustomersViewModel.setRentViewModelListener(rentViewModel);
    }
    public MenuViewModel getMenuViewModel(){return menuViewModel;}
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
    public FilterItemsViewModel getFilterItemsViewModel() {return filterItemsViewModel;}
    public RentViewModel getRentViewModel() {return rentViewModel;}

    public FilterCustomersViewModel getFilterCustomersViewModel(){
        return filterCustomersViewModel;
    }

    public AddCustomerViewModel getAddCustomerViewModel(){
        return addCustomerViewModel;
    }
}
