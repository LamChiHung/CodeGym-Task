package entity.user_imp;

import entity.User;

import java.util.UUID;

public class Seller extends User {
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

    public Seller(UUID sellerID, String sellerName, String sellerPassword, String sellerPhoneNumber, String sellerEmail, boolean status, double sellerStar, int sellerTotalNumbersOfSold, UUID storageID, UUID sellerWalletID) {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.sellerPassword = sellerPassword;
        this.sellerPhoneNumber = sellerPhoneNumber;
        this.sellerEmail = sellerEmail;
        this.status = status;
        this.sellerStar = sellerStar;
        this.sellerTotalNumbersOfSold = sellerTotalNumbersOfSold;
        this.storageID = storageID;
        this.sellerWalletID = sellerWalletID;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public String getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setSellerPhoneNumber(String sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSellerStar() {
        return sellerStar;
    }

    public void setSellerStar(double sellerStar) {
        this.sellerStar = sellerStar;
    }

    public int getSellerTotalNumbersOfSold() {
        return sellerTotalNumbersOfSold;
    }

    public void setSellerTotalNumbersOfSold(int sellerTotalNumbersOfSold) {
        this.sellerTotalNumbersOfSold = sellerTotalNumbersOfSold;
    }

    public UUID getStorageID() {
        return storageID;
    }

    public void setStorageID(UUID storageID) {
        this.storageID = storageID;
    }

    public UUID getSellerWalletID() {
        return sellerWalletID;
    }

    public void setSellerWalletID(UUID sellerWalletID) {
        this.sellerWalletID = sellerWalletID;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerID=" + sellerID +
                ", sellerName='" + sellerName + '\'' +
                ", sellerPassword='" + sellerPassword + '\'' +
                ", sellerPhoneNumber=" + sellerPhoneNumber +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", status=" + status +
                ", sellerStar=" + sellerStar +
                ", sellerTotalNumbersOfSold=" + sellerTotalNumbersOfSold +
                ", storageID=" + storageID +
                ", sellerWalletID=" + sellerWalletID +
                '}';
    }

    public String toCSVFormat() {
        String csvFormat = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        return String.format(csvFormat, sellerID.toString(), sellerName, sellerPassword, sellerPhoneNumber, sellerEmail, String.valueOf(status), String.valueOf(sellerStar), String.valueOf(sellerTotalNumbersOfSold), storageID.toString(), sellerWalletID.toString());
    }
}
