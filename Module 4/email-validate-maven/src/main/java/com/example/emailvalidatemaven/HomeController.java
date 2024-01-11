package com.example.emailvalidatemaven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public HomeController() {
        this.pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @PostMapping("/validate")
    public ModelAndView email(@RequestParam("email") String email) {
        boolean isValid = validate(email);
        ModelAndView modelAndView = new ModelAndView();
        if (isValid) {
            modelAndView.setViewName("sucess");
            modelAndView.addObject("email", email);
            return modelAndView;
        } else {
            modelAndView.setViewName("home");
            modelAndView.addObject("message", "Email is invalid");
            return modelAndView;
        }
    }

    public boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
