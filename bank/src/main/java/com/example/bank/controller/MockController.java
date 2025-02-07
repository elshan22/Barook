package com.example.bank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bank.dto.MockDTO;
import com.example.bank.service.MockService;

@RestController
@RequestMapping("/wallets")
public class MockController {

    @Autowired
    private MockService mockService;

    @PostMapping("")
    public MockDTO addWallet(@RequestParam Long userId) {
        Long walletId = mockService.addWallet(userId);
        return new MockDTO(walletId);
    }
}
