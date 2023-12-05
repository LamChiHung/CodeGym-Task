package entity.lockedaccount_imp;

import entity.LockedAccount;

import java.time.LocalDateTime;
import java.util.UUID;

public class LockedSeller extends LockedAccount {
    private UUID sellerID;
    LocalDateTime startTimeLocked;
    LocalDateTime endTimeLocked;

    public LockedSeller(UUID sellerID) {
        this.sellerID = sellerID;
        this.startTimeLocked = LocalDateTime.now();
        this.endTimeLocked = startTimeLocked.plusMinutes(1);
    }

    public LockedSeller(UUID sellerID, LocalDateTime startTimeLocked, LocalDateTime endTimeLocked) {
        this.sellerID = sellerID;
        this.startTimeLocked = startTimeLocked;
        this.endTimeLocked = endTimeLocked;
    }

    public UUID getSellerID() {
        return sellerID;
    }

    public void setSellerID(UUID sellerID) {
        this.sellerID = sellerID;
    }

    public LocalDateTime getStartTimeLocked() {
        return startTimeLocked;
    }

    public void setStartTimeLocked(LocalDateTime startTimeLocked) {
        this.startTimeLocked = startTimeLocked;
    }

    public LocalDateTime getEndTimeLocked() {
        return endTimeLocked;
    }

    public void setEndTimeLocked(LocalDateTime endTimeLocked) {
        this.endTimeLocked = endTimeLocked;
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s";
        return String.format(csvFormat, sellerID.toString(), startTimeLocked.toString(), endTimeLocked.toString());
    }
}
