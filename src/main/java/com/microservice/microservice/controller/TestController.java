package com.microservice.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.microservice.model.UserInfoOutput;
import com.microservice.microservice.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public UserInfoOutput testApi() {
        return userService.getUserById("144");
    }
}   
