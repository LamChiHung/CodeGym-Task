package com.customermanagerment.service;


import com.customermanagerment.entity.Customer;
import com.customermanagerment.repository.ICustomerSpringDataRepository;
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
        return customerSpringDataRepository.findById(id).orElse(null);
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
