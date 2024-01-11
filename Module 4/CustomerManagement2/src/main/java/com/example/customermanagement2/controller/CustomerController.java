package com.example.customermanagement2.controller;

import com.example.customermanagement2.entity.Customer;
import com.example.customermanagement2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("")
    public ModelAndView showList() {
        List <Customer> customers = customerService.getAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping("/customer-information/{id}")
    public ModelAndView showInfo(@PathVariable("id") Integer id) {
        Customer customer = customerService.getById(id);
        ModelAndView modelAndView = new ModelAndView("customer-information");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping("/update")
    public ModelAndView update(@RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String address
                               ){
        Customer customer = new Customer(id,name,email,address);
        customerService.update(customer);
        ModelAndView modelAndView = new ModelAndView("home");
        List<Customer> customers = customerService.getAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
