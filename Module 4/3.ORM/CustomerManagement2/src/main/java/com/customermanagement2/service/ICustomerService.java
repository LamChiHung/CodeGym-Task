package com.customermanagement2.service;

import com.customermanagement2.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List <Customer> getAll();

    Customer findById(int id);

    void save(Customer customer);

    void deleteById(int id);
}
