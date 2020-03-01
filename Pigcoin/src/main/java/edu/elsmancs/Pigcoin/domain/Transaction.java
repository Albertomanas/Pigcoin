package edu.elsmancs.Pigcoin.domain;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Transaction {

    private String hash = null;
    private String prev_hash = null;
    private PublicKey pKey_sender;
    /**dirección pública de la wallet desde la que se envían los pigcoins.
     * Para el desarrollador, es la publickey de wallet
     */
    private PublicKey pKey_recipinet;
    /**dirección pública de la wallet desde la que se envían los pigcoins(monedero que lso recibe).
     * Para el desarrollador, es la publickey de wallet
     */
    private double pigcoins = 0d;
    private String message = null;

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender,
                       PublicKey pKey_recipinet, double pigcoins, String message) {

            this.hash = hash;
            this.prev_hash = prev_hash;
            this.pKey_sender = pKey_sender;
            this.pKey_recipinet = pKey_recipinet;
            this.pigcoins = pigcoins;
            this.message = message;
    }

    public Transaction(){
    }

    @Override
    public String toString() {
        return "\n hash = " + this.hash + "\n prev_hash = " + this.prev_hash +
                "\n pKey_sender = " + this.pKey_sender.hashCode() + "\n pKey_recipient = " +
                this.pKey_recipinet.hashCode() + "\n pigcoins = " + this.pigcoins +
                "\n message = " + this.message;
    }
}

