package client_seller;

import cart_and_product.SellerStorage;
import wallet.MainWallet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Seller implements Serializable, Person {
    private String username;
    private String password;
    public SellerStorage sellerStorage;
    public MainWallet mainWallet;

    public Seller(String username, String password) {
        this.username = username;
        this.password = password;
        sellerStorage = new SellerStorage(this);
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

    public SellerStorage getSellerStorage() {
        return sellerStorage;
    }

    public void setSellerStorage(SellerStorage sellerStorage) {
        this.sellerStorage = sellerStorage;
    }

    public void save() {
        File file = new File(".\\database\\seller.csv");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sellerStorageInformation() {
        this.sellerStorage.getProductMap().forEach((key, value) -> {
            System.out.println(value);
        });
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
            System.out.println("Change password sucess!");
        } else {
            System.out.println("The password is not correct please try again!");
        }
    }

    @Override
    public String toString() {
        return "Seller{" +
                "username='" + username + '\'' +
                ", sellerStorage=" + sellerStorage +
                '}';
    }
}
