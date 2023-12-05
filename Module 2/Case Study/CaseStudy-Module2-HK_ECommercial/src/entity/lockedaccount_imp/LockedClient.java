package entity.lockedaccount_imp;

import entity.LockedAccount;

import java.time.LocalDateTime;
import java.util.UUID;

public class LockedClient extends LockedAccount {
    private UUID clientID;
    LocalDateTime startTimeLocked;
    LocalDateTime endTimeLocked;

    public LockedClient(UUID clientID) {
        this.clientID = clientID;
        this.startTimeLocked = LocalDateTime.now();
        this.endTimeLocked = startTimeLocked.plusMinutes(1);
    }

    public LockedClient(UUID clientID, LocalDateTime startTimeLocked, LocalDateTime endTimeLocked) {
        this.clientID = clientID;
        this.startTimeLocked = startTimeLocked;
        this.endTimeLocked = endTimeLocked;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
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
        return String.format(csvFormat, clientID.toString(), startTimeLocked.toString(), endTimeLocked.toString());
    }
}
