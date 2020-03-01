package edu.elsmancs.Pigcoin.domain;

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

}

