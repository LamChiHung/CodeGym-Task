package com.imgofday.controller;


import com.imgofday.entity.Comment;
import com.imgofday.entity.TimeRange;
import com.imgofday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {
    private ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = {"", "/home"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        List <Comment> comments = commentService.getAll();
        comments = commentService.sortByDate(comments);
        Comment comment = new Comment();
        TimeRange timeRange = new TimeRange();
        modelAndView.addObject("timeRange", timeRange);
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment", comment);
        return modelAndView;
    }

    @PostMapping("/create")
    public String creatNewComment(@ModelAttribute("comment") Comment comment) {
        comment.setDateTime(LocalDateTime.now());
        commentService.save(comment);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable("id") int id) {
        commentService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("from") String from, @RequestParam("to") String to) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        String[] fromArray = from.split("-");
        String[] toArray = to.split("-");
        ArrayList <Integer> fromNumberArray = new ArrayList <>();
        ArrayList <Integer> toNumberArray = new ArrayList <>();
        for (int i = 0; i < fromArray.length; i++) {
            fromNumberArray.add(Integer.parseInt(fromArray[i]));
            toNumberArray.add(Integer.parseInt(toArray[i]));
        }
        LocalDateTime fromTime = LocalDateTime.of(fromNumberArray.get(0), fromNumberArray.get(1), fromNumberArray.get(2), 0, 0);
        LocalDateTime toTime = LocalDateTime.of(toNumberArray.get(0), toNumberArray.get(1), toNumberArray.get(2), 0, 0);
        List <Comment> comments = commentService.getByDateTime(LocalDateTime.of(fromDate, LocalTime.MIDNIGHT), LocalDateTime.of(toDate.plusDays(1), LocalTime.MIDNIGHT));
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("comments", comments);
        Comment comment = new Comment();
        modelAndView.addObject("comment", comment);
        return modelAndView;
    }
}
