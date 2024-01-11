package com.example.customermanagement.repository;

import com.example.customermanagement.entity.Customer;

import java.util.List;

public interface ICustomerRepo {
    List <Customer> getAllCustomer();
}
