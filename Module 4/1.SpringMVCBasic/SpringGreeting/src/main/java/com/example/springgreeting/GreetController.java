package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greeting")
public class GreetController {
    @GetMapping("/naming")
    public ModelAndView greeting(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
