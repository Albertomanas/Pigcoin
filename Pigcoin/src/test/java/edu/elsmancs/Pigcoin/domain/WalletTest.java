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
        assertEquals(0, wallet.getBalance(), 0d);
    }

    @Test
    public void ComprobarTransaccionPigcoinsTest() {
        /**
         * A partir de los ejemplos del main
         */

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        double delta = 0d;

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction();
        trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "a flying pig!");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10, "spam spam spam");
        bChain.addOrigin(trx);

        wallet_1.loadCoins(bChain);
        assertEquals(20, wallet_1.getTotalInput(), delta);
        assertEquals(0, wallet_1.getTotalOutput(), delta);
        assertEquals(20, wallet_1.getBalance(), delta);

        wallet_2.loadCoins(bChain);
        assertEquals(10, wallet_2.getTotalInput(), delta);
        assertEquals(0, wallet_2.getTotalOutput(), delta);
        assertEquals(10, wallet_2.getBalance(), delta);
    }
}
