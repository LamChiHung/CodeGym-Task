package com.customermanagementrestful.service;

import com.customermanagementrestful.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page <Customer> getAll(Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    Customer findByName(String name);

    boolean isCustomerExist(String name);
}
