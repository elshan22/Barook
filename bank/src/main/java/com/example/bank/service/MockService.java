package com.example.bank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exception.WalletAlreadyExistsException;
import com.example.bank.model.Wallet;
import com.example.bank.repository.WalletRepository;

@Service
public class MockService {

    @Autowired
    private WalletRepository walletRepository;

    public Long addWallet(Long userId) {
        Optional<Wallet> wallet = walletRepository.findByUserId(userId);
        if (wallet.isPresent()) throw new WalletAlreadyExistsException("wallet for user with id " + userId + " already exists!");
        Wallet newWallet = new Wallet(userId);
        walletRepository.save(newWallet);
        return newWallet.getId();
    }

    public Long addWallet(Long userId, BigDecimal amount) {
        Optional<Wallet> wallet = walletRepository.findByUserId(userId);
        if (wallet.isPresent()) throw new WalletAlreadyExistsException("wallet for user with id " + userId + " already exists!");
        Wallet newWallet = new Wallet(userId, amount);
        walletRepository.save(newWallet);
        return newWallet.getId();
    }
}
