package wallet;

import java.io.Serializable;

public class MomoWallet implements Wallet, Serializable {
    public int money;
    MainWallet mainWallet;

    public MomoWallet(MainWallet mainWallet) {
        this.mainWallet = mainWallet;
        this.money = 1000000;
    }

    @Override
    public int add(int money) {
        if (money > 0) {
            this.money += money;
        }
        return this.money;
    }

    @Override
    public int payToMainWallet(int money) {
        if (money > 0) {
            this.mainWallet.money += money;
            this.money -= money;
        }
        return this.money;
    }

    public void displayMoney() {
        System.out.println("Money in Momo Wallet: " + this.money);
    }
}
