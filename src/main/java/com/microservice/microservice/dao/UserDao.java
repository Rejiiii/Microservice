package com.microservice.microservice.dao;

import org.apache.ibatis.annotations.Mapper;

import com.microservice.microservice.model.User;

@Mapper
public interface UserDao {
    
    User getByUsername(String username);

}
