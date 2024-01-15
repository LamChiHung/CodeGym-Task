package com.customermanagement2.repository;

import com.customermanagement2.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List <Customer> getAll();

    Customer findById(int id);

    void save(Customer customer);

    void deleteById(int id);
}
