package entity.wallet_imp;

import entity.Wallet;

import java.util.UUID;

public class SellerWallet extends Wallet {
    private UUID sellerWalletID;
    private int money;

    public SellerWallet() {
        this.sellerWalletID = UUID.randomUUID();
        this.money = 1000000;

    }

    public SellerWallet(UUID sellerWalletID, int money) {
        this.sellerWalletID = sellerWalletID;
        this.money = money;
    }

    public UUID getSellerWalletID() {
        return sellerWalletID;
    }

    public void setSellerWalletID(UUID sellerWalletID) {
        this.sellerWalletID = sellerWalletID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "SellerWallet{" +
                "money=" + money +
                "} " + super.toString();
    }

    @Override
    public String csvFormat() {
        String csvFormat = "%s,%d";
        return String.format(csvFormat, sellerWalletID.toString(), money);
    }
}
