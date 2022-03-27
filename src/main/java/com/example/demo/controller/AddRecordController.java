package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddRecordController {

    private final UserService userService;

    @Autowired
    public AddRecordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addRecord")
    public String addRecordForm(Model model) {
        model.addAttribute("record", new User());
        return "addRecord";
    }

    @PostMapping("/addRecord")
    public String saveRecord(@ModelAttribute(name="user") User user){
        userService.saveRecord(user);
        return "redirect:/";
    }
}
