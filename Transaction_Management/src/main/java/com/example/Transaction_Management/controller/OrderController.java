package com.example.Transaction_Management.controller;

import com.example.Transaction_Management.dto.OrderRequestDto;
import com.example.Transaction_Management.dto.OrderResponseDto;
import com.example.Transaction_Management.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderServ;

    @PostMapping
    public ResponseEntity<OrderResponseDto> placeOrderRestApi(@RequestBody OrderRequestDto orderRequestDto)
    {
        OrderResponseDto orderRes = orderServ.placeOrder(orderRequestDto);

        return new ResponseEntity<>(orderRes,HttpStatus.CREATED);
    }


}
