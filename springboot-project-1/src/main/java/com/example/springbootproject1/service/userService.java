package com.example.springbootproject1.service;

import com.example.springbootproject1.DTO.userDto;
import com.example.springbootproject1.entity.User;

import java.util.List;

public interface userService {
    userDto createUser (userDto u1);

    userDto GetUser (String s1);

    userDto UpdateUser_lastName (Long id,String s1);

    userDto UpdateCompany (String s1);

    userDto delete_user(String s1);

    List<userDto> Get_IT_User(String company);

}
