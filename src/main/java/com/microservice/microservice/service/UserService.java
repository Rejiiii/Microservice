package com.microservice.microservice.service;

import com.microservice.microservice.model.User;

public interface UserService {
    
    User getByUsername(String username);
}
