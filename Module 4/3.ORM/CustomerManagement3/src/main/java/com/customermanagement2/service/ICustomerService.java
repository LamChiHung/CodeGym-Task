package com.customermanagement2.service;

import com.customermanagement2.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page <Customer> getAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void deleteById(int id);
}
