package com.example.sandwichcondiments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping("/result")
    public ModelAndView result(@RequestParam(defaultValue = "none") String condiment1,
                               @RequestParam(defaultValue = "none") String condiment2,
                               @RequestParam(defaultValue = "none") String condiment3,
                               @RequestParam(defaultValue = "none") String condiment4
    ) {
        List <String> condiments = new ArrayList <>();
        if (! condiment1.equals("none")) {
            condiments.add(condiment1);
        }
        if (! condiment2.equals("none")) {
            condiments.add(condiment2);
        }
        if (! condiment3.equals("none")) {
            condiments.add(condiment3);
        }
        if (! condiment4.equals("none")) {
            condiments.add(condiment4);
        }
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }
}
