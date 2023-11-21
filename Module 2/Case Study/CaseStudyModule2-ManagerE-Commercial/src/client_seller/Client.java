package client_seller;

import cart_and_product.Cart;
import wallet.MainWallet;

import java.io.Serializable;

public class Client implements Serializable, Person {
    private String username;
    private String password;
    public Cart cart;
    public MainWallet mainWallet;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new Cart();
        this.mainWallet = new MainWallet(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
