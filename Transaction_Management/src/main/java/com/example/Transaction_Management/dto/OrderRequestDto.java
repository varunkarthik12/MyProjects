package com.example.Transaction_Management.dto;

import com.example.Transaction_Management.Entity.Order;
import com.example.Transaction_Management.Entity.payments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private Order order;
    private payments payments;
}
