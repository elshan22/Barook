package com.example.bank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bank.dto.MockDTO;
import com.example.bank.dto.TransactionDTO;
import com.example.bank.dto.WalletDTO;
import com.example.bank.service.MockService;
import com.example.bank.service.TransactionService;
import com.example.bank.service.WalletService;

@RestController
@RequestMapping("")
public class BankController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private MockService mockService;

    @PostMapping("/wallets")
    public MockDTO addWallet(@RequestParam Long userId) {
        Long walletId = mockService.addWallet(userId);
        return new MockDTO(walletId);
    }

    @GetMapping("/balance/{userId}")
    public WalletDTO getBalance(@PathVariable Long userId) {
        BigDecimal balance = walletService.getBalance(userId);
        return new WalletDTO(balance);
    }

    @PostMapping("/add/{userId}")
    public TransactionDTO addAmount(@PathVariable Long userId, @RequestParam double amount) {
        BigDecimal bigAmount = BigDecimal.valueOf(amount);
        Long reference_id = transactionService.addMoney(userId, bigAmount);
        return new TransactionDTO(reference_id);
    }
}
