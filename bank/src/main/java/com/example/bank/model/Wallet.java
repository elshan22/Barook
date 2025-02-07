package com.example.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wallets")
@NoArgsConstructor
@Getter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false, unique=true)
    private Long userId;
    
    @Column(nullable=false)
    @Setter
    private BigDecimal balance = BigDecimal.ZERO;

    public Wallet(Long userId) {
        this.userId = userId;
        this.balance = BigDecimal.ZERO;
    }

    public Wallet(Long userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }
}
