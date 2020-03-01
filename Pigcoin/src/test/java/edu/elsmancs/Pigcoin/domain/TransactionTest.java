package edu.elsmancs.Pigcoin.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {

     @Test
     public void comprobarAsignacionKeyTest(){
         Transaction transaction = new Transaction();
         Wallet wallet = new Wallet();
         assertNotNull(wallet);
         assertNotNull(transaction);
         assertEquals(transaction.getPkeySender(), wallet.getAddress());
    }

}
