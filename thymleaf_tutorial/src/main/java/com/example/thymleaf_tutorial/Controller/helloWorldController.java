package com.example.thymleaf_tutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloWorldController {

    //Handler method to handle hello world request

    @GetMapping("/hello_World")
    public String hello_world(Model model){

        model.addAttribute("message","Hello World!");
        return "helloWorld";
    }
}
