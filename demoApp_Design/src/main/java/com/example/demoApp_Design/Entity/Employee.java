package com.example.demoApp_Design.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "emp_dtls")
public class Employee {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    private String name;

}
