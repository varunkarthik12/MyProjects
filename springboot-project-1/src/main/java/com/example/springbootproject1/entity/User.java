package com.example.springbootproject1.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id's")
    @SequenceGenerator(name = "id_gen",sequenceName = "id's",allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String company;
}
