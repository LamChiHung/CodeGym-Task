package com.example.customermanagement.repository;

import com.example.customermanagement.connection.JDBCConnection;
import com.example.customermanagement.entity.Customer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo {
    @Override
    public List <Customer> getAllCustomer() {
        List <Customer> customers = new ArrayList <>();
        Connection connection = JDBCConnection.getConnection();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setEmail(resultSet.getString("email"));
                customer.setName(resultSet.getString("name"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
