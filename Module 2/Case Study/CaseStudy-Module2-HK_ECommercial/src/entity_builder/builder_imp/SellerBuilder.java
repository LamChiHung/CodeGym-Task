package entity_builder.builder_imp;

import database.DataBase;
import entity.storage.Storage;
import entity.user_imp.Seller;
import entity.wallet_imp.SellerWallet;
import entity_builder.Builder;

import java.util.UUID;

public class SellerBuilder implements Builder {
    private UUID sellerID;
    private String sellerName;
    private String sellerPassword;
    private String sellerPhoneNumber;
    private String sellerEmail;
    private boolean status;
    private double sellerStar;
    private int sellerTotalNumbersOfSold;
    private UUID storageID;
    private UUID sellerWalletID;
    private static SellerBuilder sellerBuilder;

    private SellerBuilder() {

    }

    public static SellerBuilder getSellerBuilder() {
        if (sellerBuilder == null) {
            sellerBuilder = new SellerBuilder();
            return sellerBuilder;
        } else return sellerBuilder;
    }

    public Builder setSellerID() {
        this.sellerID = UUID.randomUUID();
        return this;
    }

    public Builder setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    public Builder setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
        return this;
    }

    public Builder setSellerPhoneNumber(String sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
        return this;
    }

    public Builder setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
        return this;
    }

    public Builder setStatus() {
        this.status = true;
        return this;
    }

    public Builder setSellerStar() {
        this.sellerStar = 0;
        return this;
    }

    public Builder setSellerTotalNumbersOfSold() {
        this.sellerTotalNumbersOfSold = 0;
        return this;
    }

    public Builder setStorageID() {
        Storage storage = new Storage();
        DataBase.storageMap.put(storage.getStoreID(), storage);
        this.storageID = storage.getStoreID();
        return this;
    }

    public Builder setSellerWalletID() {
        SellerWallet sellerWallet = new SellerWallet();
        DataBase.sellerWalletMap.put(sellerWallet.getSellerWalletID(), sellerWallet);
        this.sellerWalletID = sellerWallet.getSellerWalletID();
        return this;
    }

    public Builder setOrigin() {
        setSellerID();
        setSellerWalletID();
        setSellerStar();
        setStatus();
        setStorageID();
        setSellerTotalNumbersOfSold();
        return this;
    }

    @Override
    public Seller build() {
        Seller seller = new Seller(sellerID, sellerName, sellerPassword, sellerPhoneNumber, sellerEmail, status, sellerStar, sellerTotalNumbersOfSold, storageID, sellerWalletID);
        DataBase.storageMap.get(storageID).setSellerID(sellerID);
        return seller;
    }

}
