package com.learning.questionsApp.controllers;

import com.learning.questionsApp.entity.User;
import com.learning.questionsApp.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    MyUserDetailsService userService;
    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);


    }

    @GetMapping("/allUsers")
    public String getAllUsers() {
        return "allUsers";
    }

}
