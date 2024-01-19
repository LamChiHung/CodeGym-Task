package com.customermanagementrestful.controller;

import com.customermanagementrestful.entity.Customer;
import com.customermanagementrestful.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView home(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home");
        Page <Customer> customers = customerService.getAll(pageable);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        Customer customer = new Customer();
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNewCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        customerService.save(customer);
        return "redirect:/home";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Customer customer) {
        customerService.delete(customer);
        return "redirect:/home";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView createForm(@PathVariable("id") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject(customer);
        return modelAndView;
    }

}
