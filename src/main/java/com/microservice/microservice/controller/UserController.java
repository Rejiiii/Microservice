package com.microservice.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.microservice.model.AuthResponse;
import com.microservice.microservice.service.serviceImpl.UserServiceImpl;

@Controller
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String loginPage() {
        return "loginUser"; // Return the name of your Thymeleaf login page.
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        AuthResponse response = userService.authUser(username, password);

        if (response.isSuccess()) {
            // Successful login
            model.addAttribute("success", "Login successfully");
            return "redirect:/index"; // Use the forward slash to indicate an absolute path.
        } else {
            // Failed login
            model.addAttribute("error", response.getErrorMessage());
            return "login"; // Return the login page with an error message.
        }
    }
}