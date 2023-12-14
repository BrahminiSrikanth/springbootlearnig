package com.springboottransaction.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboottransaction.management.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
