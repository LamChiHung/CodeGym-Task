package service.wallet_service;

import database.DataBase;
import entity.wallet_imp.ClientWalletLog;
import entity.wallet_imp.SellerWalletLog;
import util.WriteAllData;

public class CreateLogService {
    private static CreateLogService createLogService;

    private CreateLogService() {

    }

    public static CreateLogService getCreateLogService() {
        if (createLogService == null) {
            createLogService = new CreateLogService();
            return createLogService;
        } else return createLogService;
    }

    public void createClientLogService(int money, int moneyInWallet) {
        ClientWalletLog clientWalletLog = new ClientWalletLog(DataBase.currentSeller, DataBase.currentClient, money, moneyInWallet);
        DataBase.clientWalletLogMap.put(clientWalletLog.getClientWalletLogID(), clientWalletLog);
        WriteAllData.getWriteAllData().writeData();
    }

    public void createDepositClientLogService(int money, int moneyInWallet) {
        ClientWalletLog clientWalletLog = new ClientWalletLog(DataBase.currentClient, money, moneyInWallet);
        DataBase.clientWalletLogMap.put(clientWalletLog.getClientWalletLogID(), clientWalletLog);
        WriteAllData.getWriteAllData().writeData();
    }

    public void createSellerLogService(int money, int moneyInWallet) {
        SellerWalletLog sellerWalletLog = new SellerWalletLog(DataBase.currentSeller, DataBase.currentClient, money, moneyInWallet);
        DataBase.sellerWalletLogMap.put(sellerWalletLog.getSellerWalletLogID(), sellerWalletLog);
        WriteAllData.getWriteAllData().writeData();
    }


}
