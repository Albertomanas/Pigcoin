package edu.elsmancs.Pigcoin.domain;


import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    private PublicKey address;
    private PrivateKey sKey;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;


    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public PublicKey getAddress() {
        return this.address;
    }

    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());
    }

    @Override
    public String toString() {
        return "\n Wallet = " + getAddress().hashCode() + "\n Total input = " +
                this.total_input + "\n Total output = " + this.total_output +
                "\n Balance = " + this.balance;
    }
}
