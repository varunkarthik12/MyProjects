package com.example.thymleaf_tutorial.Controller;

import com.example.thymleaf_tutorial.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @GetMapping("/user")
    public String variableExpression(Model model)
    {
        User user = new User("varun","vk@gmail.com","student",
                "Male");
        model.addAttribute("user",user);
        return "users";
    }



}
