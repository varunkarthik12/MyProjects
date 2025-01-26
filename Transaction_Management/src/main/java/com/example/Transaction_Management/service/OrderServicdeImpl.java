package com.example.Transaction_Management.service;

import com.example.Transaction_Management.Entity.Order;
import com.example.Transaction_Management.Entity.payments;
import com.example.Transaction_Management.Exception.PaymentException;
import com.example.Transaction_Management.dto.OrderRequestDto;
import com.example.Transaction_Management.dto.OrderResponseDto;
import com.example.Transaction_Management.repository.OrderRepository;
import com.example.Transaction_Management.repository.paymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServicdeImpl implements OrderService{


    private OrderRepository orderRep;

    private paymentRepository paymentRep;

    @Override
    @Transactional
    public OrderResponseDto placeOrder(OrderRequestDto orderReq) {

        Order order = orderReq.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        orderRep.save(order);


        payments payments = orderReq.getPayments();

        if(!payments.getType().equalsIgnoreCase("debit"))
        {
            throw new PaymentException("payment for "+payments.getType()+" is not allowed for this transaction");
        }

        payments.setOrderId(order.getId());

       paymentRep.save(payments);

       return new OrderResponseDto(order.getOrderTrackingNumber(),order.getStatus(),"SUCCESS");




    }
}
