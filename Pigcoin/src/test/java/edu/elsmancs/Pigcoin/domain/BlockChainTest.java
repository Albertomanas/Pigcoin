package edu.elsmancs.Pigcoin.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlockChainTest {

    private Wallet origin = null;
    private Wallet wallet_1 = null;
    private Transaction trx = null;
    private BlockChain bChain = null;

    @Before
    public void setupTest() {
        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction();
    }

    @Test
    public void generarBlockChainTest() {
        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction();
        bChain.addOrigin(trx);
        assertNotNull(trx);
        assertNotNull(bChain);
        assertEquals(bChain.getBlockChain().get(0), trx);
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
