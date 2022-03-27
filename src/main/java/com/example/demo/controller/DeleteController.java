package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {

    private UserService userService;

    @Autowired
    public DeleteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/deleteRecord/{id}")
    public String deleteRecord(@PathVariable("id") String id){
        userService.deleteRecord(id);
        return "redirect:/allRecords/";
    }
}
