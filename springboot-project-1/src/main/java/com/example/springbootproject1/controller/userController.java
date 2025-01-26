package com.example.springbootproject1.controller;

import com.example.springbootproject1.DTO.userDto;
import com.example.springbootproject1.entity.User;
import com.example.springbootproject1.service.userService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class userController {

    @Autowired
    private userService u_serv;

    @Autowired
    private ModelMapper model_map;

    //build rest  API
    @PostMapping
    public ResponseEntity<userDto> createUser (@RequestBody userDto u1)
    {

        userDto savedUser = u_serv.createUser(u1);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<List<userDto>> createUserList (@RequestBody List<userDto> ud_list)
    {
        List createdUsers = new ArrayList();
        for(userDto u:ud_list)
        {
            userDto created = u_serv.createUser(u);
            createdUsers.add(created);

        }
        return new ResponseEntity<>(createdUsers,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<userDto> getUser (@RequestBody userDto u1)
    {
        String s1 = u1.getFirstName();
        userDto retrieved_user = u_serv.GetUser(s1);
        System.out.println(retrieved_user.toString());
        return new ResponseEntity<>(retrieved_user,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<userDto> updateUser(@RequestBody userDto u1) {
        String s1 = u1.getLastName();
        Long id = u1.getId();
        userDto updatedData = u_serv.UpdateUser_lastName(id, s1);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<userDto> delete_user (@RequestBody userDto u1)
    {
        String s1 = u1.getFirstName();
        userDto DeletedUser = u_serv.delete_user(s1);
        return new ResponseEntity<>(DeletedUser,HttpStatus.OK);
    }


    @PutMapping("/company")
    public ResponseEntity<userDto> update_company(@RequestBody userDto u1)
    {
        String s1 = u1.getFirstName();
        userDto updated_user = u_serv.UpdateCompany(s1);
        return new ResponseEntity<>(updated_user,HttpStatus.OK);
    }

    @GetMapping("/IT")
    public ResponseEntity<List<userDto>>Get_IT(@RequestBody userDto u1)
    {
        String s1 = u1.getCompany();
        List<userDto> l1 = u_serv.Get_IT_User(s1);
        return new ResponseEntity<>(l1,HttpStatus.OK);
    }


}
