package entity.user_imp;

import entity.User;

import java.util.UUID;

public class Client extends User {
    private UUID clientID;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean status;
    private UUID cartID;
    private UUID clientWalletID;

    public Client(UUID clientID, String username, String password, String phoneNumber, String email, boolean status, UUID cartID, UUID walletID) {
        this.clientID = clientID;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;

        this.cartID = cartID;
        this.clientWalletID = walletID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getCartID() {
        return cartID;
    }

    public void setCartID(UUID cartID) {
        this.cartID = cartID;
    }

    public UUID getClientWalletID() {
        return clientWalletID;
    }

    public void setClientWalletID(UUID clientWalletID) {
        this.clientWalletID = clientWalletID;
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%s,%s,%s,%s,%s";
        return String.format(csvFormat, clientID.toString(), username, password, phoneNumber, email, status, cartID.toString(), clientWalletID.toString());
    }
}
