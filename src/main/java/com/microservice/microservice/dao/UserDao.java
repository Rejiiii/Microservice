package com.microservice.microservice.dao;

import org.apache.ibatis.annotations.Mapper;

import com.microservice.microservice.model.UserOutput;

@Mapper
public interface UserDao {

    UserOutput getAllUser();
    UserOutput getByUsername(String username);
    

}
