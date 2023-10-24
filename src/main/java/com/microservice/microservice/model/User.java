package com.microservice.microservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User{
    
    private String emp_id;

    @NotBlank(message = "Username should not be empty.")
    @Size(max = 20, message = "The Username is invalid, it should be up to 20 characters long.")
    private String username;

    @NotBlank(message = "Password should not be empty.")
    @Size(max = 255, message = "The Password is invalid, it should be up to 255 characters long.")
    private String password;

    private int positionId;

    private int deptId;

    private int sectionId;

    private int roleId;

    private String statusCode;

}