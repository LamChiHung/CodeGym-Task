package com.example.module3_test_project.model.service;

import com.example.module3_test_project.model.dao.EmployeeDAO;
import com.example.module3_test_project.model.entity.Employee;

import java.util.List;

public class EmployeeService {
    private static EmployeeService employeeService;

    private EmployeeService() {

    }

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public void addNewEmployee(String name, String email, String address, String phoneNumber, int salary, String department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setSalary(salary);
        employee.setDepartment(department);
        EmployeeDAO.insert(employee);
    }

    public void editEmployee(int id, String name, String email, String address, String phoneNumber, int salary, String department) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setSalary(salary);
        employee.setDepartment(department);
        EmployeeDAO.update(employee);
    }

    public void deleteEmployee(int id) {
        EmployeeDAO.deleteById(id);
    }

    public List <Employee> searchByName(String name) {
        return EmployeeDAO.getByName(name);
    }
}
