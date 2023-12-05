package service.locked_account;

import database.DataBase;
import entity.lockedaccount_imp.LockedSeller;
import entity.user_imp.Seller;
import util.write_data.WriteSellerLockedData;

import java.time.Duration;

public class LockedSellerService {
    private static LockedSellerService lockedSellerService;

    private LockedSellerService() {

    }

    public static LockedSellerService getLockedSellerService() {
        if (lockedSellerService == null) {
            lockedSellerService = new LockedSellerService();
            return lockedSellerService;
        } else return lockedSellerService;
    }

    public void lockedSellerService(Seller seller) {
        WriteSellerLockedData writeSellerLockedData = null;
        if (! DataBase.lockedSellerMap.containsKey(seller.getSellerID())) {
            LockedSeller lockedSeller = new LockedSeller(seller.getSellerID());
            DataBase.lockedSellerMap.put(lockedSeller.getSellerID(), lockedSeller);
            writeSellerLockedData = WriteSellerLockedData.getWriteSellerData();
            writeSellerLockedData.writeData();
        } else {
            LockedSeller lockedSeller = DataBase.lockedSellerMap.get(seller.getSellerID());
            double plusTime = Math.pow(1 + Duration.between(lockedSeller.getStartTimeLocked(), lockedSeller.getEndTimeLocked()).toHours(), 2);
            lockedSeller.setEndTimeLocked(lockedSeller.getEndTimeLocked().plusHours((long) plusTime));

        }
    }
}
