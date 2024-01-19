package com.customermanagerment.controller;


import com.customermanagerment.entity.Customer;
import com.customermanagerment.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"", "/home"})
    public ModelAndView home(@PageableDefault(value = 5) Pageable pageable) {
        Page <Customer> customers = customerService.getAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        customerService.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public ModelAndView createFormPage() {
        ModelAndView modelAndView = new ModelAndView("/form");
        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        customerService.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFormPage(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        customerService.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        List <Customer> customers = new ArrayList <>();
        customers.add(customer);
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
