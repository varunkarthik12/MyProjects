package com.example.springbootproject1.service.impl;
import com.example.springbootproject1.DTO.userDto;
import com.example.springbootproject1.Exception.EmailAlreadyExists;
import com.example.springbootproject1.Exception.ResourceNotFoundException;
import com.example.springbootproject1.repository.userRepository;
import com.example.springbootproject1.entity.User;
import com.example.springbootproject1.service.userService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRep;

    @Autowired
    private ModelMapper model_map;
    @Override
    public userDto createUser(userDto u1) {
        boolean emailPresent = userRep.findByEmail(u1.getEmail()).isPresent();
        if(emailPresent)
        {
            throw  new EmailAlreadyExists("Email already exists");
        }
        User u11 = model_map.map(u1,User.class);
        User saved = userRep.save(u11);
        userDto res = model_map.map(saved,userDto.class);
        return res;

    }

    @Override
    public userDto GetUser(String name)
    {

        User res =  userRep.findByFirstName(name).orElseThrow(()-> new ResourceNotFoundException("User","name",name));
        userDto got_userdto = model_map.map(res,userDto.class);
        return got_userdto;
    }

    @Override
    public userDto UpdateUser_lastName(Long id, String s1) {
        User u1 = userRep.findById(id).get();
        u1.setLastName(s1);
        User saved = userRep.save(u1);
        userDto res = model_map.map(saved,userDto.class);
        return res;
    }

    @Override
    public userDto delete_user(String s1) {
        User u1 = userRep.findByFirstName(s1).get();
        userRep.delete(u1);
        userDto u11 = model_map.map(u1, userDto.class);
        return u11;
    }

    @Override
    public userDto UpdateCompany(String s1) {
        String nc ="IT";
        String c = "Core";

        User u1 = userRep.findByFirstName(s1).get();
        if(s1.equalsIgnoreCase("Ranga"))
            u1.setCompany(c);
        else
            u1.setCompany(nc);

        userDto res = model_map.map(userRep.save(u1),userDto.class);
        return res ;
    }

    @Override
    public List<userDto> Get_IT_User(String company) {

        List<User> IT = userRep.findByCompanyContaining(company);
        System.out.println(IT.toString());

        return IT.stream().map(u1-> model_map.map(u1,userDto.class)).collect(Collectors.toList());
    }
}
