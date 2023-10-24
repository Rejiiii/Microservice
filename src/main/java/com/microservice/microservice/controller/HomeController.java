package com.microservice.microservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/loginProj")
    public String loginProj(){
        return "loginProj";
    }

    @GetMapping("/logout")
    public Map<String, String> logout() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "logout success");
        return response;
    }
    
}
