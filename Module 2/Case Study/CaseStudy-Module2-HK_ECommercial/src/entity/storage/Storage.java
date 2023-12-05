package entity.storage;

import java.time.LocalDateTime;
import java.util.UUID;

public class Storage {
    private UUID storeID;
    private LocalDateTime dateTimeCreate;
    private UUID sellerID;

    public Storage() {
        this.storeID = UUID.randomUUID();
        dateTimeCreate = LocalDateTime.now();
    }

    public Storage(UUID storeID, LocalDateTime dateTimeCreate, UUID sellerID) {
        this.storeID = storeID;
        this.dateTimeCreate = dateTimeCreate;
        this.sellerID = sellerID;
    }

    public UUID getStoreID() {
        return storeID;
    }

    public void setStoreID(UUID storeID) {
        this.storeID = storeID;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storeID=" + storeID +
                ", dateTimeCreate=" + dateTimeCreate +
                '}';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s";
        return String.format(csvFormat, storeID.toString(), dateTimeCreate.toString(), sellerID.toString());
    }
}
