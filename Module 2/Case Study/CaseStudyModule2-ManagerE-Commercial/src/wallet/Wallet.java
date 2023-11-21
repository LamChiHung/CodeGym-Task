package wallet;

import java.io.Serializable;

public interface Wallet extends Serializable {
    int add(int money);

    int payToMainWallet(int money);

    void displayMoney();
}
