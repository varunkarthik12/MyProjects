package com.example.springBootbankingproject.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Data
public class AccountDto {

    private Long id;

    private String accountHolder;

    private double balance;
}
