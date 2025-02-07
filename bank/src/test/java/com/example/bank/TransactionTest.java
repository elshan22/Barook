package com.example.bank;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.example.bank.model.Wallet;
import com.example.bank.repository.WalletRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.exception.InsufficientBalanceException;
import com.example.bank.service.MockService;
import com.example.bank.service.TransactionService;

@SpringBootTest
@Transactional
public class TransactionTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MockService mockService;

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void testAddMoney_Success() {
        mockService.addWallet(1000L);
        transactionService.addMoney(1000L, new BigDecimal(100));
        Optional<Wallet> updatedWallet = walletRepository.findByUserId(1000L);
        assertTrue(updatedWallet.isPresent());
        assertEquals(new BigDecimal(100), updatedWallet.get().getBalance());
    }

    @Test
    public void testAddMoney_NegativeAmount_ThrowsException() {
        mockService.addWallet(1000L);
        assertThrows(InsufficientBalanceException.class, () -> transactionService.addMoney(1000L, new BigDecimal(-500)));
    }
}
