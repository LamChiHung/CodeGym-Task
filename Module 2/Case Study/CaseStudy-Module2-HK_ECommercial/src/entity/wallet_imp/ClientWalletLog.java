package entity.wallet_imp;

import entity.user_imp.Client;
import entity.user_imp.Seller;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientWalletLog {
    private UUID clientWalletLogID;
    private UUID clientWalletID;
    private UUID sellerWalletID;
    private LocalDateTime timeTransaction;
    private int moneyTransaction;
    private int moneyInWallet;

    public ClientWalletLog(Seller seller, Client client, int moneyTransation, int moneyInWallet) {
        this.clientWalletLogID = UUID.randomUUID();
        this.sellerWalletID = seller.getSellerWalletID();
        this.clientWalletID = client.getClientWalletID();
        this.timeTransaction = LocalDateTime.now();
        this.moneyTransaction = moneyTransation;
        this.moneyInWallet = moneyInWallet;
    }

    public ClientWalletLog(Client client, int moneyTransation, int moneyInWallet) {
        this.clientWalletLogID = UUID.randomUUID();
        this.sellerWalletID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        this.clientWalletID = client.getClientWalletID();
        this.timeTransaction = LocalDateTime.now();
        this.moneyTransaction = moneyTransation;
        this.moneyInWallet = moneyInWallet;
    }

    public ClientWalletLog(UUID clientWalletLogID, UUID sellerWalletID, UUID clientWalletID, LocalDateTime timeTransaction, int moneyTransation, int moneyInWallet) {
        this.clientWalletLogID = clientWalletLogID;
        this.sellerWalletID = sellerWalletID;
        this.clientWalletID = clientWalletID;
        this.timeTransaction = timeTransaction;
        this.moneyTransaction = moneyTransation;
        this.moneyInWallet = moneyInWallet;
    }

    public UUID getClientWalletLogID() {
        return clientWalletLogID;
    }

    public void setClientWalletLogID(UUID clientWalletLogID) {
        this.clientWalletLogID = clientWalletLogID;
    }

    public UUID getClientWalletID() {
        return clientWalletID;
    }

    public void setClientWalletID(UUID clientWalletID) {
        this.clientWalletID = clientWalletID;
    }

    public UUID getSellerWalletID() {
        return sellerWalletID;
    }

    public void setSellerWalletID(UUID sellerWalletID) {
        this.sellerWalletID = sellerWalletID;
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
        return "ClientWalletLog{" +
                "clientWalletLogID=" + clientWalletLogID +
                ", timeTransaction=" + timeTransaction +
                ", moneyTransaction=" + moneyTransaction +
                ", moneyInWallet=" + moneyInWallet +
                '}';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%s,%d,%d";
        return String.format(csvFormat, clientWalletLogID.toString(), sellerWalletID.toString(), clientWalletID.toString(), timeTransaction.toString(), moneyTransaction, moneyInWallet);
    }
}
