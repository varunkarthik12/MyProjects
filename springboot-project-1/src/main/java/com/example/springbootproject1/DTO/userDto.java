package com.example.springbootproject1.DTO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class userDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String company;

}

