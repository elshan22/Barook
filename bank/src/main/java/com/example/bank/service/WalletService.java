package com.example.bank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exception.WalletNotFoundException;
import com.example.bank.model.Wallet;
import com.example.bank.repository.WalletRepository;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public BigDecimal getBalance(Long userId) {
        Optional<Wallet> wallet = walletRepository.findByUserId(userId);
        if (wallet.isPresent()) return wallet.get().getBalance();
        throw new WalletNotFoundException("wallet for user with id: " + userId + " doesn't exist!");
    }
}
