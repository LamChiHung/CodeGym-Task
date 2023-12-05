package model.models.imp;

import model.models.User;

import java.io.Serializable;

public class Seller implements User, Serializable {
    private String username;
    private String password;
    private Storage storage;

    public Seller(String username, String password) {
        this.username = username;
        this.password = password;
        this.storage = new Storage();
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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "username= " + username +
                '}';
    }
}
