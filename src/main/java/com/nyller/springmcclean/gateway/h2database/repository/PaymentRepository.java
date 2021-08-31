package com.nyller.springmcclean.gateway.h2database.repository;

import com.nyller.springmcclean.gateway.h2database.model.PaymentDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDatabase, Integer> {
}