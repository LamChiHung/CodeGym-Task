package com.example.module3_test_project.model.dao;

import com.example.module3_test_project.connection.JDBCConnection;
import com.example.module3_test_project.model.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static List <Employee> getAll() {
        List <Employee> employeeList = new ArrayList <>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "select * from employee";

            PreparedStatement preparedStatement = connection.prepareStatement(query);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setDepartment(resultSet.getString("department"));
                employeeList.add(employee);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static Employee getById(int id) {
        Employee employee = new Employee();
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "select * from employee where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setDepartment(resultSet.getString("department"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static void insert(Employee employee) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "INSERT INTO employee (name,email,address,phone_number,salary,department) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setString(6, employee.getDepartment());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Added user successfully.");
            } else {
                System.out.println("Failed to insert user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Employee employee) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "UPDATE employee SET name = ?, email = ?, address = ?, phone_number = ?, salary = ?, department = ? WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setString(6, employee.getDepartment());
            preparedStatement.setInt(7, employee.getId());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Update product succuessfully.");
            } else {
                System.out.println("Failed to update product.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "DELETE FROM `module3_test_project`.`employee` WHERE (`id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List <Employee> getByName(String name) {
        List <Employee> employeeList = new ArrayList <>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "select * from employee WHERE name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String nameQuerry = "%" + name + "%";
            preparedStatement.setString(1, nameQuerry);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setDepartment(resultSet.getString("department"));
                employeeList.add(employee);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
