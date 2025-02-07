package com.example.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;

@NoArgsConstructor
@Getter
@Setter
public class TransactionDTO {

    private Long reference_id;

    public TransactionDTO(Long reference_id) {
        this.reference_id = reference_id;
    }
}
