package entity.wallet_imp;

import entity.user_imp.Client;
import entity.user_imp.Seller;

import java.time.LocalDateTime;
import java.util.UUID;

public class SellerWalletLog {
    private UUID sellerWalletLogID;
    private UUID sellerWalletID;
    private UUID clientWalletID;
    private LocalDateTime timeTransaction;
    private int moneyTransaction;
    private int moneyInWallet;

    public SellerWalletLog(Seller seller, Client client, int moneyTransaction, int moneyInWallet) {
        this.sellerWalletLogID = UUID.randomUUID();
        this.sellerWalletID = seller.getSellerWalletID();
        this.clientWalletID = client.getClientWalletID();
        this.timeTransaction = LocalDateTime.now();
        this.moneyTransaction = moneyTransaction;
        this.moneyInWallet = moneyInWallet;
    }

    public SellerWalletLog(UUID sellerWalletLogID, UUID sellerWalletID, UUID clientWalletID, LocalDateTime timeTransaction, int moneyTransation, int moneyInWallet) {
        this.sellerWalletLogID = sellerWalletLogID;
        this.sellerWalletID = sellerWalletID;
        this.clientWalletID = clientWalletID;
        this.timeTransaction = timeTransaction;
        this.moneyTransaction = moneyTransation;
        this.moneyInWallet = moneyInWallet;
    }

    public UUID getSellerWalletLogID() {
        return sellerWalletLogID;
    }

    public void setSellerWalletLogID(UUID sellerWalletLogID) {
        this.sellerWalletLogID = sellerWalletLogID;
    }

    public UUID getSellerWalletID() {
        return sellerWalletID;
    }

    public void setSellerWalletID(UUID sellerWalletID) {
        this.sellerWalletID = sellerWalletID;
    }

    public UUID getClientWalletID() {
        return clientWalletID;
    }

    public void setClientWalletID(UUID clientWalletID) {
        this.clientWalletID = clientWalletID;
    }

    public LocalDateTime getTimeTransaction() {
        return timeTransaction;
    }

    public void setTimeTransaction(LocalDateTime timeTransaction) {
        this.timeTransaction = timeTransaction;
    }

    public int getMoneyTransaction() {
        return moneyTransaction;
    }

    public void setMoneyTransaction(int moneyTransaction) {
        this.moneyTransaction = moneyTransaction;
    }

    public int getMoneyInWallet() {
        return moneyInWallet;
    }

    public void setMoneyInWallet(int moneyInWallet) {
        this.moneyInWallet = moneyInWallet;
    }

    @Override
    public String toString() {
        return "SellerWalletLog{" +
                "sellerWalletLogID=" + sellerWalletLogID +
                ", timeTransaction=" + timeTransaction +
                ", moneyTransation=" + moneyTransaction +
                ", moneyInWallet=" + moneyInWallet +
                '}';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%s,%d,%d";
        return String.format(csvFormat, sellerWalletLogID.toString(), sellerWalletID.toString(), clientWalletID.toString(), timeTransaction.toString(), moneyTransaction, moneyInWallet);
    }
}
