package edu.elsmancs.Pigcoin.domain;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private final List<Transaction> blockChain = new ArrayList<>();

    public BlockChain(){
    }

    public List<Transaction> getBlockChain() {
        return this.blockChain;
    }

    public void addOrigin(Transaction transaction) {
        this.getBlockChain().add(transaction);

        /** Añadir a blockChain una transacción
         *
         */
    }

    public void summarize(int position){
        System.out.println(blockChain.get(position).toString());
    }

    public void summarize() {
        this.blockChain.forEach((transaction -> {
            System.out.println(transaction.toString());
        }));
    }

    public double[] loadWallet(PublicKey address) {
        /**Carga en el wallet los pigcoins enviados y recibidos en esa dirección
         *
         * Genero dos variables, una de entrada y otra de salida.
         * Para la cargar dicha transacción si la PublicKey address apunta a recipient
         *          entonces los pigcoins de in se añaden a la cantidad de pigcoins de este.
         *
         * En caso de que apunte a sender, se suma a este.
         */
        double pigcoinsEntrada = 0d;
        double pigcoinsSalida = 0d;
        for (Transaction transaction : getBlockChain()) {
            if (address.equals(transaction.getpKeyRecipinet())) {
                pigcoinsEntrada += transaction.getPigcoins();
            }
            if (address.equals(transaction.getPkeySender())) {
                pigcoinsSalida += transaction.getPigcoins();
            }
        }
        double[] pigcoins = {pigcoinsEntrada, pigcoinsSalida};
        return pigcoins;

    }

}

