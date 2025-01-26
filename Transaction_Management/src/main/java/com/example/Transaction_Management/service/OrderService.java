package com.example.Transaction_Management.service;

import com.example.Transaction_Management.dto.OrderRequestDto;
import com.example.Transaction_Management.dto.OrderResponseDto;

public interface OrderService {

    OrderResponseDto placeOrder(OrderRequestDto orderReq);

}
