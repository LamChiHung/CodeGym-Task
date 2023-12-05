package model.models.imp;

import model.models.User;
import model.models.Wallet;

import java.io.Serializable;

public class Client implements User, Serializable {
    private String username;
    private String password;
    private Cart cart;
    private Wallet wallet;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new Cart();
        this.wallet = new MainWallet();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "username= " + username +
                '}';
    }
}
