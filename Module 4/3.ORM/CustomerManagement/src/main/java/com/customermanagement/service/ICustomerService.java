package com.customermanagement.service;

import com.customermanagement.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List <Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}
