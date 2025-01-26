package com.example.todoManagement.TodoManagement.project.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
public class PasswordEncoderutils {

    public static void main(String[] args)
    {
        PasswordEncoder pswd = new BCryptPasswordEncoder();

        System.out.println(pswd.encode("varun"));
    }

}
