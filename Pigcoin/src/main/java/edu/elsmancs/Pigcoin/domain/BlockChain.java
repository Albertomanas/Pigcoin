package edu.elsmancs.Pigcoin.domain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private final List<Transaction> blockChain = new ArrayList<>();

    public BlockChain(){
    }

    public void addOrigin(Transaction transaction) {
        this.blockChain.add(transaction);
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
