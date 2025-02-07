package com.example.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;

@NoArgsConstructor
@Getter
@Setter
public class TransactionDTO {

    private Long referenceId;

    public TransactionDTO(Long referenceId) {
        this.referenceId = referenceId;
    }
}
