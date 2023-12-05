package entity.bill_imp;

import database.DataBase;

import java.util.UUID;

public class Bill {
    UUID billID;
    private UUID sellerID;
    private UUID clientID;
    private String information;
    private int moneyTransaction;

    public Bill(UUID billID, UUID sellerID, UUID clientID, String information, int moneyTransaction) {
        this.billID = billID;
        this.sellerID = sellerID;
        this.clientID = clientID;
        this.information = information;
        this.moneyTransaction = moneyTransaction;
    }

    public Bill(String information, int moneyTransaction) {
        this.billID = UUID.randomUUID();
        this.sellerID = DataBase.currentSeller.getSellerID();
        this.clientID = DataBase.currentClient.getClientID();
        this.information = information;
        this.moneyTransaction = moneyTransaction;
    }

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getMoneyTransaction() {
        return moneyTransaction;
    }

    public void setMoneyTransaction(int moneyTransaction) {
        this.moneyTransaction = moneyTransaction;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", seller=" + DataBase.sellerMap.get(sellerID).getSellerName() +
                ", client=" + DataBase.clientMap.get(clientID).getUsername() +
                ", information='" + information + '\'' +
                ", moneyTransaction=" + moneyTransaction +
                '}';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%s,%d";
        return String.format(csvFormat, billID.toString(), sellerID.toString(), clientID.toString(), information, moneyTransaction);
    }
}
