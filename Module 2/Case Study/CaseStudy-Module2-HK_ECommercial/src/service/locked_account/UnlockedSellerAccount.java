package service.locked_account;

import database.DataBase;
import util.ReadAllData;
import util.write_data.WriteSellerData;

import java.time.Duration;
import java.time.LocalDateTime;

public class UnlockedSellerAccount {
    private static UnlockedSellerAccount unlockedSellerAccount;

    private UnlockedSellerAccount() {

    }

    public static UnlockedSellerAccount getUnlockedSellerAccount() {
        if (unlockedSellerAccount == null) {
            unlockedSellerAccount = new UnlockedSellerAccount();
            return unlockedSellerAccount;
        } else return unlockedSellerAccount;
    }


    public void runUnlockedSellerAccount() {
        ReadAllData readAllData = ReadAllData.getReadAllData();
        readAllData.readData();
        if (DataBase.lockedSellerMap != null) {
            DataBase.lockedSellerMap.forEach((key, value) -> {
                if (Duration.between(LocalDateTime.now(), value.getEndTimeLocked()).getSeconds() < 0) {
                    if (DataBase.sellerMap.get(value.getSellerID()) != null) {
                        DataBase.sellerMap.get(value.getSellerID()).setStatus(true);
                    }
                    WriteSellerData writeSellerData = WriteSellerData.getWriteSellerData();
                    writeSellerData.writeData();
                }
            });
        }
    }
}

