package com.example.bank.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
public class WalletDTO {

    private BigDecimal balance;

    public WalletDTO(BigDecimal balance) {
        this.balance = balance;
    }
}
