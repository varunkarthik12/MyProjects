package com.project.emailAssistant.EmailAssistant.Controller;

import com.project.emailAssistant.EmailAssistant.Service.EmailGeneratorService;
import com.project.emailAssistant.EmailAssistant.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    @Autowired
    EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest)
    {

        String emailResponse = emailGeneratorService.generateEmail(emailRequest);
        return new ResponseEntity<>(emailResponse, HttpStatus.OK);
    }


}
