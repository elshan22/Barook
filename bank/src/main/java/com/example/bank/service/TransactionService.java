package com.example.bank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exception.WalletNotFoundException;
import com.example.bank.model.Transaction;
import com.example.bank.model.Wallet;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.repository.WalletRepository;

@Service
public class TransactionService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Long addAmount(Long userId, BigDecimal amount) {
        Optional<Wallet> wallet = walletRepository.findByUserId(userId);
        if (wallet.isPresent()) {
            wallet.get().setBalance(wallet.get().getBalance().add(amount));
            walletRepository.save(wallet.get());
            Transaction transaction = new Transaction(userId, amount);
            transactionRepository.save(transaction);
            return transaction.getId();
        }
        throw new WalletNotFoundException("wallet for user with id: " + userId + " doesn't exist!");
    }
}
