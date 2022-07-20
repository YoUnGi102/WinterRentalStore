package model;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Employee> getEmployeesByType(String staffType) {
        ArrayList<Employee> employeesByStaffType = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getStaffType().equals(staffType)) {
                employeesByStaffType.add(employee);
            }
        }
        return employeesByStaffType;
    }

    public Employee getEmployeeByUsername(String username) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
