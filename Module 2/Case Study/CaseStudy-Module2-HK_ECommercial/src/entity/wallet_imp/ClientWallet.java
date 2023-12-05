package entity.wallet_imp;

import entity.Wallet;

import java.util.UUID;

public class ClientWallet extends Wallet {

    private UUID clientWalletID;
    private int money;

    public ClientWallet() {
        this.clientWalletID = UUID.randomUUID();
        this.money = 1000000;
    }

    public ClientWallet(UUID clientWalletID, int money) {
        this.clientWalletID = clientWalletID;
        this.money = money;
    }

    public UUID getClientWalletID() {
        return clientWalletID;
    }

    public void setClientWalletID(UUID clientWalletID) {
        this.clientWalletID = clientWalletID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String csvFormat() {
        String csvFormat = "%s,%d";
        return String.format(csvFormat, clientWalletID.toString(), money);
    }
}
