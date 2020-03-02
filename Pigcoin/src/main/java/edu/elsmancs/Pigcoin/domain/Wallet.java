package edu.elsmancs.Pigcoin.domain;


import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

public class Wallet {

    private PublicKey address;
    private PrivateKey sKey;
    private double total_input = 0d;
    private double total_output = 0d;
    private double balance = 0d;
    private List<Transaction> inputTransactions = null;
    private List<Transaction> outputTransactions = null;


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
     *
     * 3. Actualizar el balance ABSTRACCIÓN!
     *          setBalance que sea la resta total_input y total_output
     *          nota: parecido al updateQuality de Gildedrose
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void update_balance() {
        setBalance(getTotalInput()-getTotalOutput());
    }

    public void loadCoins(BlockChain bChain) {
        double[] pigcoinsCargados = {0d, 0d}; //Misma estructura {x, y} de loadWallet

        pigcoinsCargados = bChain.loadWallet(getAddress());
        setTotalInput(pigcoinsCargados[0]);  //Posición [0] corresponde a los de input
        setTotalOutput(pigcoinsCargados[1]); // Posición [1] corresponde a los output

        update_balance();
    }

    /**
     * Setters inputTransactions y outputTransactions que
     * llamarán a los métodos de BlockChain inputTransactions y outputTransactions
     *
     */
    public void setInputTransactions(List<Transaction> inputTransactions) {
        this.inputTransactions = inputTransactions;
    }

    public void setOutputTransactions(List<Transaction> outputTransactions) {
        this.outputTransactions = outputTransactions;
    }


}
