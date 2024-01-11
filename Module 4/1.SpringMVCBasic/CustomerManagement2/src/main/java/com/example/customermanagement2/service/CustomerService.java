package com.example.customermanagement2.service;

import com.example.customermanagement2.entity.Customer;
import com.example.customermanagement2.entity.CustomerList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public List <Customer> getAll() {
        return CustomerList.customers;
    }

    @Override
    public Customer getById(int id) {
        Customer result = null;
        for (Customer customer : CustomerList.customers) {
            if (customer.getId() == id) {
                result = customer;
            }
        }
        return result;
    }

    @Override
    public boolean update(Customer customer) {
        boolean isSucess = false;
        for (Customer customer1 : CustomerList.customers) {
            if (customer1.getId() == customer.getId()) {
                customer1 = customer;
                isSucess = true;
            }
        }
        return isSucess;
    }
}
