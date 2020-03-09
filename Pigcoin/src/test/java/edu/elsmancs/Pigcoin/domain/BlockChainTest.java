package edu.elsmancs.Pigcoin.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlockChainTest {

    @Test
    public void generarBlockChainTest() {
        BlockChain blockChain = new BlockChain();
        Transaction transaction = new Transaction();
        blockChain.addOrigin(transaction);
        assertNotNull(transaction);
        assertNotNull(blockChain);
        assertEquals(blockChain.getBlockChain().get(0), transaction);
    }


    @Test
    public void comprobarAddOriginTest() {
        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction();
        trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "bacon eggs");
        bChain.addOrigin(trx);
        assertEquals(20, bChain.getBlockChain().get(0).getPigcoins(), 0);
    }

}
