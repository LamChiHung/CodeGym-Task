package entity.cart;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cart {
    private UUID cartID;
    private UUID clientID;
    private LocalDateTime timeCreate;
    private int totalCost;

    public Cart() {
        this.cartID = UUID.randomUUID();
        this.timeCreate = LocalDateTime.now();
        this.totalCost = 0;
    }

    public Cart(UUID cartID, UUID clientID, LocalDateTime timeCreate, int totalCost) {
        this.cartID = cartID;
        this.clientID = clientID;
        this.timeCreate = timeCreate;
        this.totalCost = totalCost;
    }

    public UUID getCartID() {
        return cartID;
    }

    public void setCartID(UUID cartID) {
        this.cartID = cartID;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
    }

    public LocalDateTime getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(LocalDateTime timeCreate) {
        this.timeCreate = timeCreate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", clientID=" + clientID +
                ", timeCreate=" + timeCreate +
                ", totalCost=" + totalCost +
                '}';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%d";
        return String.format(csvFormat, cartID.toString(), clientID.toString(), timeCreate.toString(), totalCost);
    }
}
