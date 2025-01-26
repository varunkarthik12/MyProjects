package com.example.todoManagement.TodoManagement.project.controller;

import com.example.todoManagement.TodoManagement.project.dto.AuthenticationRequestDto;
import com.example.todoManagement.TodoManagement.project.dto.AuthenticationResponseDto;
import com.example.todoManagement.TodoManagement.project.service.TodoService;
import com.example.todoManagement.TodoManagement.project.service.impl.CustomUserDetailsService;
import com.example.todoManagement.TodoManagement.project.utils.Jwtutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private Jwtutils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> createJwtToken(@RequestBody AuthenticationRequestDto  authenticationRequestDto) throws Exception
    {
        try{
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUserName(),authenticationRequestDto.getPassword()));
        }
        catch (BadCredentialsException e)
        {
             throw new Exception("Incorrect username or Password",e);
        }

        UserDetails userDetails = service.loadUserByUsername(authenticationRequestDto.getUserName());

        String jwt = jwtUtils.generateToken(userDetails);

        return new ResponseEntity<>(new AuthenticationResponseDto(jwt), HttpStatus.OK);
    }

}
