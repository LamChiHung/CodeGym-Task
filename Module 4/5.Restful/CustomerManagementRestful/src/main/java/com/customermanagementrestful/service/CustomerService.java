package com.customermanagementrestful.service;

import com.customermanagementrestful.entity.Customer;
import com.customermanagementrestful.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page <Customer> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public Customer findByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public boolean isCustomerExist(String name) {
        Customer existingCustomer = customerRepository.findCustomerByName(name);
        return existingCustomer != null;
    }

}
