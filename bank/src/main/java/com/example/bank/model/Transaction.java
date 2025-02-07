package com.example.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Long userId;

    @Column(nullable=false)
    private BigDecimal amount;

    private LocalDateTime timestamp;

    public Transaction(Long userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
}
