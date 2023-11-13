package com.microservice.microservice.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.microservice.dao.UserDao;
import com.microservice.microservice.model.AuthResponse;
import com.microservice.microservice.model.UserOutput;
import com.microservice.microservice.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AuthResponse authUser(String username, String password) {
        AuthResponse response = new AuthResponse();

        if (username.isEmpty() || password.isEmpty()) {
            response.setSuccess(false);
            response.setErrorMessage("Missing input.");
        } else {
            UserOutput user = userDao.getByUsername(username);

            if (user != null) {
                String hashedPassword = user.getPassword();
                if (bCryptPasswordEncoder.matches(password, hashedPassword)) {
                    response.setSuccess(true);
                } else {
                    response.setSuccess(false);
                    response.setErrorMessage("Incorrect password.");
                }
            } else {
                response.setSuccess(false);
                response.setErrorMessage("Username not found.");
            }
        }
        return response;
    }

    @Override
    public Map<String, String> logout(String emp_id) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "logout success");

        return response;
    }

}