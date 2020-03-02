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


    public Wallet() {
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public PublicKey getAddress() {
        return this.address;
    }

    public PrivateKey getSkey() {
        return this.sKey;
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

    public double getBalance() {
        return this.balance;
    }


    /**Para poder hacer el método loadCoins es necesario:
     * 1. loadWallet(PublicKey address) CARGA LOS PIGCOINS DE SENDER Y RECEIVER
     *          ES UN MÉTODO DE BlockChain
     * 2. setTotalInput y setTotalOutput
     */

    public void setTotalInput(double total_input) {
        this.total_input += total_input;
    }

    public double getTotalInput() {
        return this.total_input;
    }

    public void setTotalOutput(double total_output) {
        this.total_output += total_output;
    }

    public double getTotalOutput() {
        return this.total_output;
    }

}
