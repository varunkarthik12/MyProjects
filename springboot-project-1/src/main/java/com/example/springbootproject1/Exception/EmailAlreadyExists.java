package com.example.springbootproject1.Exception;

public class EmailAlreadyExists  extends RuntimeException{

    public EmailAlreadyExists(String message)
    {
        super(message);
    }
}
