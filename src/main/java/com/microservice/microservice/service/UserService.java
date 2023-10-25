package com.microservice.microservice.service;

import com.microservice.microservice.model.UserInfoOutput;

public interface UserService {
    
    public UserInfoOutput getUserById(String id);
}
