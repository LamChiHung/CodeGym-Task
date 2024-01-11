package com.example.localdatetime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
@RequestMapping("")
public class WorldClock {
    @RequestMapping("/world-clock")
    public ModelAndView viewTime(@RequestParam("city") String city) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(city));
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("date", localDateTime);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
