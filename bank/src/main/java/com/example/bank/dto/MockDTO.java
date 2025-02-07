package com.example.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MockDTO {
    
    private Long wallet_id;

    public MockDTO(Long wallet_id) {
        this.wallet_id = wallet_id;
    }
}
