package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AllRecordsController {

    private final UserService userService;

    @Autowired
    public AllRecordsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/allRecords", method = RequestMethod.GET)
    public String allRecords(Model model){
        Iterable<User> records = userService.findAll();
        model.addAttribute("records", records);
        return "allRecords";
    }
}
