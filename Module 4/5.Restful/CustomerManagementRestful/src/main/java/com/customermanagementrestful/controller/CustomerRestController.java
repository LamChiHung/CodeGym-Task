package com.customermanagementrestful.controller;

import com.customermanagementrestful.entity.Customer;
import com.customermanagementrestful.repository.ICustomerRepository;
import com.customermanagementrestful.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {
    private ICustomerService customerService;
    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerRestController(ICustomerService customerService, ICustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/customers", produces = {"application/json"})
    public List <Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer createNewCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

}
