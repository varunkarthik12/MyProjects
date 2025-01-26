package com.example.springbootproject1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails>exceptionHandler(ResourceNotFoundException excep, WebRequest wr)
    {
        ErrorDetails er = new ErrorDetails(
                LocalDateTime.now(),
                excep.getMessage(),
                wr.getDescription(false),
                "USER_NOT_FOUND"
        );

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<ErrorDetails>email_exceptionHandler1(EmailAlreadyExists emailExcep , WebRequest wr)
    {
        ErrorDetails er = new ErrorDetails(
                LocalDateTime.now(),
                emailExcep.getMessage(),
                wr.getDescription(false),
                "Email_Already_Exists"
        );

        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }

}

