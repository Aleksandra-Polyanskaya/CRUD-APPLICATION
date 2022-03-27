package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {

    private UserService userService;

    @Autowired
    public EditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/editRecord/{id}")
    public String editRecordForm(@PathVariable("id") String id, Model model){
        model.addAttribute("records",userService.findById(id));
        return "editRecord";
    }

    @PostMapping("/editRecord/{id}")
    public String editRecord(@ModelAttribute(name = "records") User user,
            @PathVariable ("id")String id,Model model ){
        user.setId(id);
        userService.saveRecord(user);
        return "redirect:/allRecords/";
    }
}
