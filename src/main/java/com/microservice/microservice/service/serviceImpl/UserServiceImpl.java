package com.microservice.microservice.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microservice.dao.UserDao;
import com.microservice.microservice.model.User;
import com.microservice.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
  @Autowired
    private UserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public boolean authenticateUser(String username, String password) {
        User user = getByUsername(username);
        if (user != null) {
            // Compare the provided password with the stored password (without BCrypt)
            return password.equals(user.getPassword());
        }
        return false;
    }
}