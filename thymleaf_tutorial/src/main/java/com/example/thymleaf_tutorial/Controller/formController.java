package com.example.thymleaf_tutorial.Controller;

import com.example.thymleaf_tutorial.Model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class formController {

    @GetMapping("/registration_form")
  public String registration_form(Model model)
  {
      UserForm userForm = new UserForm();
      model.addAttribute("userForm",userForm);

      List<String> profession_list = Arrays.asList("Developer","Tester","Architect");
      model.addAttribute("profession_list",profession_list);

      return "reg_form";
  }

    @PostMapping("/submit_form")
  public String reg_sucess(Model model , @ModelAttribute("userForm") UserForm userForm)
  {
      model.addAttribute("reg_sucessful_dtls",userForm);
      return "registration_sucess";
  }


}
