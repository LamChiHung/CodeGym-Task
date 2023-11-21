package wallet;

import cart_and_product.Product;
import client_seller.Client;
import client_seller.Person;
import client_seller.Seller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MainWallet implements Serializable {
    public int money;
    public List <Wallet> walletList;
    public Person person;

    public MainWallet(Person person) {
        walletList = new ArrayList <>();
        this.person = person;
        walletList.add(new BankWallet(this));
        walletList.add(new MomoWallet(this));
    }

    public int add(int walletIndex, int money) {
        walletList.get(walletIndex).payToMainWallet(money);
        displayMoney();
        return this.money;
    }

    public void displayMoney() {
        System.out.println("Main Wallet money: " + this.money);
        System.out.print("Bank Wallet money: ");
        this.walletList.get(0).displayMoney();
        System.out.print("Momo Wallet money: ");
        this.walletList.get(1).displayMoney();
    }

    public int payBill(Map <String, Seller> sellerMap) {
        if (person instanceof Client client1) {
            Map <String, Product> productMap = client1.cart.productMap;
            AtomicInteger sumOfProductCost = new AtomicInteger();
            productMap.forEach((key, value) -> {
                int costOfProduct = (value.getNumbers() * value.getUnitPrice() * (1 - (value.getPromote() / 100)));
                sumOfProductCost.addAndGet(costOfProduct);
            });
            if (sumOfProductCost.get() <= money) {
                productMap.forEach((key, value) -> {
                    int costOfProduct = value.getNumbers() * value.getUnitPrice() * (1 - (value.getPromote() / 100));
                    sellerMap.get(value.getStore()).mainWallet.money += costOfProduct;
                    money -= costOfProduct;
                });
                System.out.println("Bill is payed successfully!");
                client1.cart.productMap.clear();
            } else {
                System.out.println("Not enough money in Main Wallet");
            }
            displayMoney();
        }
        return money;
    }
}
