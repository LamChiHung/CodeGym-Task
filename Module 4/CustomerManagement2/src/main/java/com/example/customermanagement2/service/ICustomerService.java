package com.example.customermanagement2.service;

import com.example.customermanagement2.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List <Customer> getAll();

    Customer getById(int id);

    boolean update(Customer customer);

}
