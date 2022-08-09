package viewModel;

import model.Model;

public class ViewModelFactory {
    private Model model;
    private LogInViewModel logInViewModel;
    private ManageItemViewModel manageItemViewModel;
    private AddEmployeeViewModel addEmployeeViewModel;
    private MenuViewModel menuViewModel;
    private AddItemViewModel addItemViewModel;
    private FilterItemsViewModel filterItemsViewModel;
    private FilterCustomersViewModel filterCustomersViewModel;
    private AddCustomerViewModel addCustomerViewModel;
    private RentViewModel rentViewModel;
    public ViewModelFactory(Model model) {
        this.model = model;
        this.logInViewModel = new LogInViewModel(model);
        this.manageItemViewModel = new ManageItemViewModel(model);
        this.addEmployeeViewModel = new AddEmployeeViewModel(model);
        this.addItemViewModel = new AddItemViewModel(model);
        this.menuViewModel = new MenuViewModel(model);
        this.rentViewModel = new RentViewModel(model);
        this.filterItemsViewModel = new FilterItemsViewModel(model);
        this.addCustomerViewModel = new AddCustomerViewModel(model);
        this.filterCustomersViewModel = new FilterCustomersViewModel(model);
        rentViewModel.setFilterItemsListener(filterItemsViewModel);
        filterItemsViewModel.setRentViewModelListener(rentViewModel);
    }
    public MenuViewModel getMenuViewModel(){return menuViewModel;}
    public AddItemViewModel getAddItemViewModel() {return addItemViewModel;}
    public LogInViewModel getLoginViewModel() {
        return logInViewModel;
    }
    public ManageItemViewModel getManageItemViewModel() {
        return manageItemViewModel;
    }
    public AddEmployeeViewModel getAddEmployeeViewModel() {
        return addEmployeeViewModel;
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
