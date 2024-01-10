package com.example.customermanagement.service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo;

    @Autowired
    public CustomerService(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List <Customer> getAllCustomer() {
        return customerRepo.getAllCustomer();
    }
}
