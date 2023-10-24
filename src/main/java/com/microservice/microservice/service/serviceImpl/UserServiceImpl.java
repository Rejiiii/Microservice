package com.microservice.microservice.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microservice.dao.UserDao;
import com.microservice.microservice.model.AuthResponse;
import com.microservice.microservice.model.UserOutput;
import com.microservice.microservice.service.AuthService;

@Service
public class UserServiceImpl implements AuthService{
    
  @Autowired
    private UserDao userDao;

    @Override
    public AuthResponse authUser(String username, String password) {
        UserOutput user = userDao.getByUsername(username);
        AuthResponse response = new AuthResponse();

        if (user != null && password.equals(user.getPassword())){
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
            response.setErrorMessage("Incorrect password.");
        }
        return response;
    }

    @Override
    public Map<String, String> logout(String emp_id){
        Map<String, String> response = new HashMap<>();
        response.put("status", "logout success");

        return response;
    }


}