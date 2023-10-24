package com.microservice.microservice.service;

import java.util.Map;

import com.microservice.microservice.model.AuthResponse;

public interface AuthService {

    public AuthResponse authUser(String username, String password);
    
    public Map<String, String> logout(String emp_id);
}
