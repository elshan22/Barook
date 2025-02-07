package com.example.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import com.example.bank.exception.WalletNotFoundException;
import com.example.bank.service.WalletService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.service.MockService;
import com.example.bank.service.TransactionService;

@SpringBootTest
@Transactional
public class WalletTest {

    @Autowired
    private MockService mockService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private WalletService walletService;

    @Test
    public void testGetBalance_Success() {
        mockService.addWallet(1000L);
        transactionService.addMoney(1000L, new BigDecimal(150));
        BigDecimal balance = walletService.getBalance(1000L);
        assertEquals(new BigDecimal(150), balance);
    }

    @Test
    public void testGetBalance_WalletNotFound_ThrowsException() {
        assertThrows(WalletNotFoundException.class, () -> walletService.getBalance(1000L));
    }
}
