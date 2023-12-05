package service.locked_account;

import database.DataBase;
import util.ReadAllData;
import util.write_data.WriteClientData;

import java.time.Duration;
import java.time.LocalDateTime;

public class UnlockedClientAccount {
    private static UnlockedClientAccount unlockedClientAccount;

    private UnlockedClientAccount() {

    }

    public static UnlockedClientAccount getUnlockedClientAccount() {
        if (unlockedClientAccount == null) {
            unlockedClientAccount = new UnlockedClientAccount();
            return unlockedClientAccount;
        } else return unlockedClientAccount;
    }


    public void runUnlockedClientAccount() {
        ReadAllData readAllData = ReadAllData.getReadAllData();
        readAllData.readData();
        if (DataBase.lockedClientMap != null) {
            DataBase.lockedClientMap.forEach((key, value) -> {
                if (Duration.between(LocalDateTime.now(), value.getEndTimeLocked()).getSeconds() < 0) {
                    if (DataBase.clientMap.get(value.getClientID()) != null) {
                        DataBase.clientMap.get(value.getClientID()).setStatus(true);
                    }
                    WriteClientData writeClientData = WriteClientData.getWriteClientData();
                    writeClientData.writeData();
                }
            });
        }
    }
}
