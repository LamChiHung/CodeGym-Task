package com.example.customermanagement.controller;

import com.example.customermanagement.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    private IConvertService convertService;

    @Autowired
    public ConvertController(IConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping()
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/submit")
    public ModelAndView convert(@RequestParam String usd) {
        int usdInt = Integer.parseInt(usd);
        int vnd = convertService.Convert(usdInt);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }
}
