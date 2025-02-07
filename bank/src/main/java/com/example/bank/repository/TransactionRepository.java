package com.example.bank.repository;

import java.math.BigDecimal;

import com.example.bank.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.timestamp >= :since")
    BigDecimal sumAmountSince(@Param("since") LocalDateTime since);
}
