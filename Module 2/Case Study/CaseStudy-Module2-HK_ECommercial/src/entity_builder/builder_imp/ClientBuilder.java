package entity_builder.builder_imp;

import database.DataBase;
import entity.cart.Cart;
import entity.user_imp.Client;
import entity.wallet_imp.ClientWallet;

import java.util.UUID;

public class ClientBuilder {
    private UUID clientID;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean status;
    private UUID cartID;
    private UUID clientWalletID;

    private static ClientBuilder clientBuilder;

    private ClientBuilder() {

    }

    public static ClientBuilder getClientBuilder() {
        if (clientBuilder == null) {
            clientBuilder = new ClientBuilder();
            return clientBuilder;
        } else return clientBuilder;
    }

    public void setStatus() {
        this.status = true;
    }

    public void setClientID() {
        this.clientID = UUID.randomUUID();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCartID() {
        Cart cart = new Cart();
        this.cartID = cart.getCartID();
        DataBase.cartMap.put(cart.getCartID(), cart);
    }

    public void setClientWalletID() {
        ClientWallet clientWallet = new ClientWallet();
        this.clientWalletID = clientWallet.getClientWalletID();
        DataBase.clientWalletMap.put(clientWalletID, clientWallet);
    }

    public void setOrigin() {
        setClientID();
        setClientWalletID();
        setCartID();
        setStatus();
    }


    public Client buid() {
        Client client = new Client(clientID, username, password, phoneNumber, email, status, cartID, clientWalletID);
        DataBase.clientMap.put(clientID, client);
        DataBase.cartMap.get(cartID).setClientID(clientID);
        return client;
    }
}
