package com.microservice.microservice.service;

import com.microservice.microservice.model.UserOutput;

public interface UserService {
    
    UserOutput getByUsername(String username);
}
