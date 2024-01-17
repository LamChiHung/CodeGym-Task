package com.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class GreetingController {
    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }
}
