package entity.storage;

import database.DataBase;
import entity.product.Product;

import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class StorageItem {
    private UUID itemID;
    private UUID storageID;
    private UUID productID;
    private int quantity;
    private int originUnitPrice;
    private int currentUnitPrice;
    private int promote;

    public StorageItem(String name, int quantity, int originUnitPrice, int promote) {
        this.itemID = UUID.randomUUID();
        this.storageID = DataBase.currentSeller.getStorageID();
        AtomicBoolean isProductExist = new AtomicBoolean(false);
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(name)) {
                this.productID = value.getProductID();
                isProductExist.set(true);
            }
        });
        if (! isProductExist.get()) {
            System.out.println("The product is not exit in HK_Ecommercial, please register this product!");
            System.out.println("Input product name:");
            Scanner sc = new Scanner(System.in);
            String productName = sc.nextLine();
            System.out.println("Input product type:");
            String productType = sc.nextLine();
            Product product = new Product(productName, productType);
            DataBase.producttMap.put(product.getProductID(), product);
            this.productID = product.getProductID();
        }
        this.quantity = quantity;
        this.originUnitPrice = originUnitPrice;
        this.promote = promote;
        this.currentUnitPrice = (this.originUnitPrice * (100 - this.promote) / 100);
    }

    public StorageItem(UUID itemID, UUID storageID, UUID productID, int quantity, int originUnitPrice, int currentUnitPrice, int promote) {
        this.itemID = itemID;
        this.storageID = storageID;
        this.productID = productID;
        this.quantity = quantity;
        this.originUnitPrice = originUnitPrice;
        this.currentUnitPrice = currentUnitPrice;
        this.promote = promote;
    }

    public UUID getItemID() {
        return itemID;
    }

    public void setItemID(UUID itemID) {
        this.itemID = itemID;
    }

    public UUID getStorageID() {
        return storageID;
    }

    public void setStorageID(UUID storageID) {
        this.storageID = storageID;
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
    }

    public int getOriginUnitPrice() {
        return originUnitPrice;
    }

    public void setOriginUnitPrice(int originUnitPrice) {
        this.originUnitPrice = originUnitPrice;
        setCurrentUnitPrice();
    }

    public int getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice() {
        this.currentUnitPrice = (this.getOriginUnitPrice() * (100 - this.promote) / 100);
    }

    public int getPromote() {
        return promote;
    }

    public void setPromote(int promote) {
        this.promote = promote;
        setCurrentUnitPrice();
    }

    @Override
    public String toString() {
        return "quantity=" + quantity +
                ", originUnitPrice=" + originUnitPrice +
                ", currentUnitPrice=" + currentUnitPrice +
                ", promote=" + promote + "%";
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s,%d,%d,%d,%d";
        return String.format(csvFormat, itemID.toString(), storageID.toString(), productID.toString(), quantity, originUnitPrice, currentUnitPrice, promote);
    }
}
