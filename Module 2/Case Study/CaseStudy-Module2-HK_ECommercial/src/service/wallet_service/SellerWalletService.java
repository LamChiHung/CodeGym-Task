package service.wallet_service;

import database.DataBase;
import entity.user_imp.Client;
import entity.wallet_imp.SellerWalletLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SellerWalletService {
    private static SellerWalletService sellerWalletService;

    private SellerWalletService() {

    }

    public static SellerWalletService getSellerWalletService() {
        if (sellerWalletService == null) {
            sellerWalletService = new SellerWalletService();
            return sellerWalletService;
        } else return sellerWalletService;
    }

    public int getWalletMoney() {
        return DataBase.sellerWalletMap.get(DataBase.currentSeller.getSellerWalletID()).getMoney();
    }

    public void viewTransactionHistory() {
        List <SellerWalletLog> sellerWalletLogList = new ArrayList <>();
        Map <UUID, Client> clientMap = new HashMap <>();
        DataBase.sellerWalletLogMap.forEach((key, value) -> {
            if (value.getSellerWalletID().equals(DataBase.currentSeller.getSellerWalletID())) {
                sellerWalletLogList.add(value);
            }
        });
        DataBase.clientMap.forEach((key, value) -> {
            clientMap.put(value.getClientWalletID(), value);
        });
        sellerWalletLogList.forEach((value) -> {
            System.out.println("Frome client: " + clientMap.get(value.getClientWalletID()).getUsername() + ", " + value.toString());
        });
    }
}
