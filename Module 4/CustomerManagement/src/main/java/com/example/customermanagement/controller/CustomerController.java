package com.example.customermanagement.controller;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/list")
    public ModelAndView showList() {
        List <Customer> customers = customerService.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
