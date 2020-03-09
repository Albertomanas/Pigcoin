package edu.elsmancs.Pigcoin.domain;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockChain {

    private final List<Transaction> blockChain = new ArrayList<>();
    private byte[] signedTransaction = null;
    private final Map<String, Double> consumedCoins = new HashMap<>();

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
         *
         * FALTA REFACTORIZAR CREANDO loadInputTransaction y loadOutputTransaction a lista y con
         *      uso de stream, filter, collect en una estructura de datos de List.
         *      No es conveniente que wallet conozca la encapsulación de BlockChain.
         */
        double pigcoinsEntrada = 0d;
        double pigcoinsSalida = 0d;
        for (Transaction transaction : getBlockChain()) {
            if (address.equals(transaction.getpKeyRecipient())) {
                pigcoinsEntrada += transaction.getPigcoins();
            }
            if (address.equals(transaction.getPkeySender())) {
                pigcoinsSalida += transaction.getPigcoins();
            }
        }
        double[] pigcoins = {pigcoinsEntrada, pigcoinsSalida};
        return pigcoins;
    }

    /** Autentificación de la transacción
     *  1. processTransactions tiene que cumplir:
     *         isSignatureValid()
     *         isConsumedCoinValid()
     *         si se cumple, createTransaction()
     *
     *         Este requisito es parecido a EnZilium
     */


    public boolean isSignatureValid(PublicKey pKey_sender, String message, byte[] signedTransaction) {
        return GenSig.verify(pKey_sender, message, signedTransaction);
    }

    public Map<String, Double> getConsumedCoins() {
        return this.consumedCoins;
    }

    /**
     * Verifica que los pigcoins que se intentan enviar en la transacción no se han gastado antes
     *  así que proviene de una transacción que aún no sé ha utilizado.
     * @param consumedCoins
     * @return
     */

    public boolean isConsumedCoinValid(Map<String, Double> consumedCoins) {
        for (String hashKey : consumedCoins.keySet()) {
            for (Transaction transaction : blockChain) {
                if (hashKey.equals(transaction.getPrev_hash())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  Añade al BlockChain una transacción cuando es todo correcto.
     *  Método resuelto con la ayuda del código de dFleta.
     * @param pKey_sender
     * @param pKey_recipient
     * @param consumedCoins
     * @param message
     * @param signedTransaction
     */
    public void createTransactions(PublicKey pKey_sender, PublicKey pKey_recipient, Map<String, Double> consumedCoins,
                                   String message, byte[] signedTransaction) {

        PublicKey address_recipient = pKey_recipient;
        Integer lastBlock = 0;

        for (String prev_hash : consumedCoins.keySet()) {
            if (prev_hash.startsWith("CA_")) {
                pKey_recipient = pKey_sender;

                /**
                 * startsWith si empieza por la String "CA_"
                 */

                lastBlock = blockChain.size() + 1;
                Transaction transaction = new Transaction("hash_" + lastBlock.toString(), prev_hash, pKey_sender,
                        pKey_recipient, consumedCoins.get(prev_hash), message);
                getBlockChain().add(transaction);

                pKey_recipient = address_recipient;
            }
        }
    }

    /**
     * Process Transaction tiene que cumplir:
     *  isSignatureValid(public_Key, message, signedTransaction)
     *  isConsumedCoinValid(consumedCoins);
     *  createTransaction(pKey_sender, pKey_recipient, consumedCoins,message, signedTransaction);
     */

    public void processTransaction(PublicKey pKey_sender, PublicKey pKey_recipient, Map<String, Double> consumedCoins,
                                   String message, byte[] signedTransaction) {
        if (isSignatureValid(pKey_sender, message, signedTransaction) && isConsumedCoinValid(consumedCoins)) {
            createTransactions(pKey_sender, pKey_recipient, consumedCoins, message, signedTransaction);
        }
    }

}

