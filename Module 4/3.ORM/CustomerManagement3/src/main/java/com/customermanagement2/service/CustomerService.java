package com.customermanagement2.service;

import com.customermanagement2.entity.Customer;
import com.customermanagement2.repository.ICustomerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerSpringDataRepository customerSpringDataRepository;

    @Autowired
    public CustomerService(ICustomerSpringDataRepository customerSpringDataRepository) {
        this.customerSpringDataRepository = customerSpringDataRepository;
    }

    @Override
    public Page <Customer> getAll(Pageable pageable) {
        return customerSpringDataRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) {
        if (customerSpringDataRepository.findById(id).isPresent()) {
            return customerSpringDataRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        customerSpringDataRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerSpringDataRepository.deleteById(id);
    }

}
