package edu.elsmancs.Pigcoin.domain;

import org.junit.Test;
import static org.junit.Assert.*;


public class WalletTest {

    @Test
    public void generarWalletTest() {
        Wallet wallet = new Wallet();
        wallet.generateKeyPair();
        assertNotNull(wallet.getAddress().hashCode());
        assertNotNull(wallet.getSkey().hashCode());
        assertEquals(0,wallet.getBalance(), 0d);
    }
}
