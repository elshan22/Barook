package com.example.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MockDTO {
    
    private Long walletId;

    public MockDTO(Long walletId) {
        this.walletId = walletId;
    }
}
