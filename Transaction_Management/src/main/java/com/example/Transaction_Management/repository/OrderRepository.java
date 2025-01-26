package com.example.Transaction_Management.repository;

import com.example.Transaction_Management.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
