package com.example.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.example.bank.exception.WalletAlreadyExistsException;
import com.example.bank.model.Wallet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.repository.WalletRepository;
import com.example.bank.service.MockService;

@SpringBootTest
@Transactional
public class MockTest {

    @Autowired
    private MockService mockService;

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void testCreateWallet_Success() {
        Long walletId = mockService.addWallet(1L);
        assertNotNull(walletId);
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        assertTrue(wallet.isPresent());
        assertEquals(wallet.get().getUserId(), 1L);
    }

    @Test
    public void testCreateWallet_AlreadyExists_ThrowsException() {
        mockService.addWallet(1L);
        assertThrows(WalletAlreadyExistsException.class, () -> mockService.addWallet(1L));
    }
}
