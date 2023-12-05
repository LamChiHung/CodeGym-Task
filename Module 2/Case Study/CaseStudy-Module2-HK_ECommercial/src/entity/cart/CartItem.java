package entity.cart;

import database.DataBase;

import java.util.UUID;

public class CartItem {
    private UUID itemID;
    private UUID sellerID;
    private UUID cartID;
    private UUID productID;
    private int quantity;
    private int originUnitPrice;
    private int currentUnitPrice;
    private int promote;
    private int totalPrice;

    public CartItem(UUID itemID, UUID sellerID, UUID cartID, UUID productID, int quantity, int originUnitPrice, int currentUnitPrice, int promote) {
        this.itemID = itemID;
        this.sellerID = sellerID;
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
        this.originUnitPrice = originUnitPrice;
        this.currentUnitPrice = currentUnitPrice;
        this.promote = promote;
        this.totalPrice = currentUnitPrice * quantity;
    }

    public UUID getItemID() {
        return itemID;
    }

    public void setItemID(UUID itemID) {
        this.itemID = itemID;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    public UUID getCartID() {
        return cartID;
    }

    public void setCartID(UUID cartID) {
        this.cartID = cartID;
    }

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        totalPrice = currentUnitPrice * quantity;
    }

    public int getOriginUnitPrice() {
        return originUnitPrice;
    }

    public void setOriginUnitPrice(int originUnitPrice) {
        this.originUnitPrice = originUnitPrice;
    }

    public int getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(int currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public int getPromote() {
        return promote;
    }

    public void setPromote(int promote) {
        this.promote = promote;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return DataBase.producttMap.get(productID).toString() +
                ", store: " + DataBase.sellerMap.get(sellerID).getSellerName() +
                ", quantity=" + quantity +
                ", originUnitPrice=" + originUnitPrice +
                ", currentUnitPrice=" + currentUnitPrice +
                ", promote=" + promote +
                ", totalPrice=" + totalPrice;
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%s,%d,%d,%d,%d";
        return String.format(csvFormat, itemID.toString(), sellerID.toString(), cartID.toString(), productID.toString(), quantity, originUnitPrice, currentUnitPrice, promote);
    }
}
