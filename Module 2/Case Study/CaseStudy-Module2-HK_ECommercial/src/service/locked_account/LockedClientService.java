package service.locked_account;

import database.DataBase;
import entity.lockedaccount_imp.LockedClient;
import entity.user_imp.Client;
import util.write_data.WriteClientLockedData;

import java.time.Duration;

public class LockedClientService {
    private static LockedClientService lockedClientService;

    private LockedClientService() {

    }

    public static LockedClientService getLockedClientService() {
        if (lockedClientService == null) {
            lockedClientService = new LockedClientService();
            return lockedClientService;
        } else return lockedClientService;
    }

    public void lockedClientService(Client client) {
        WriteClientLockedData writeClientLockedData = null;
        if (! DataBase.lockedClientMap.containsKey(client.getClientID())) {
            LockedClient lockedClient = new LockedClient(client.getClientID());
            DataBase.lockedClientMap.put(lockedClient.getClientID(), lockedClient);
            writeClientLockedData = WriteClientLockedData.getWriteClientData();
            writeClientLockedData.writeData();
        } else {
            LockedClient lockedClient = DataBase.lockedClientMap.get(client.getClientID());
            double plusTime = Math.pow(1 + Duration.between(lockedClient.getStartTimeLocked(), lockedClient.getEndTimeLocked()).toHours(), 2);
            lockedClient.setEndTimeLocked(lockedClient.getEndTimeLocked().plusHours((long) plusTime));
            WriteClientLockedData.getWriteClientData().writeData();
        }
    }
}
