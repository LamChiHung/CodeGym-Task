package com.example.databindingandform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class EmployeeController {
    @RequestMapping("")
    public ModelAndView showForm() {
        Employee employee = new Employee();
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping("/addEmployee")
    public ModelAndView info(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("/employee/info");
        modelAndView.addObject("employee");
        return modelAndView;
    }
}
