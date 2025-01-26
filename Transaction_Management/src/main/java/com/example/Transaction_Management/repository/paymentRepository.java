package com.example.Transaction_Management.repository;

import com.example.Transaction_Management.Entity.payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentRepository extends JpaRepository<payments,Long> {
}
