package com.example.todoManagement.TodoManagement.project.service.impl;

import com.example.todoManagement.TodoManagement.project.entity.User;
import com.example.todoManagement.TodoManagement.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.startup.UserDatabase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.List;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        List<User> users = userRep.findAll();

        User user = userRep.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).
                orElseThrow(()-> new UsernameNotFoundException("username not found"));

        Set<GrantedAuthority> authorities = user.getUser_roles().stream().
                map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(usernameOrEmail,user.getPassword(),authorities);
    }
}
