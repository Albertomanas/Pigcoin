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

    /**
    @Test
    public void comprobarAddOriginTest() {
        transferencia.addOrigin(Paco.getPkeySender());
    }

   */
}
