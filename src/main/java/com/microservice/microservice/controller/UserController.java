package com.microservice.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.microservice.model.User;
import com.microservice.microservice.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/loginUser")
    public String loginUser() {
        return "loginUser"; 
    }

    @GetMapping("/error")
    public String handleError() {
        return "error"; 
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam String username, @RequestParam String password) {
        User existingUser = userService.getByUsername(username);

        if (existingUser != null && password.equals(existingUser.getPassword())) {
            // Successful login, redirect to the index page
            return "redirect:/index";
        } else {
            // Authentication failed, redirect back to the login page with an error parameter
            return "redirect:/login?error";
        }
    }
}