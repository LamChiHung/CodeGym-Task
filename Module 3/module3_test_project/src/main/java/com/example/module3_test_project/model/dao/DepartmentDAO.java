package com.example.module3_test_project.model.dao;

import com.example.module3_test_project.connection.JDBCConnection;
import com.example.module3_test_project.model.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public static List <Department> getAll() {
        List <Department> departmentList = new ArrayList <>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "select * from department";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setName(resultSet.getString("departmentName"));
                departmentList.add(department);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
    }
}
