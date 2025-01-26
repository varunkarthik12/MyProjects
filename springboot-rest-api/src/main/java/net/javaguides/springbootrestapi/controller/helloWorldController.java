package net.javaguides.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloWorldController {

    //GET Request
    //http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello World!";
    }
}
