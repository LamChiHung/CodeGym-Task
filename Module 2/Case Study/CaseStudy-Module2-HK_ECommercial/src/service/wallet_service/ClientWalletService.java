package service.wallet_service;

import database.DataBase;
import entity.user_imp.Seller;
import entity.wallet_imp.ClientWallet;
import entity.wallet_imp.ClientWalletLog;
import util.WriteAllData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class ClientWalletService {
    private static ClientWalletService clientWalletService;

    private ClientWalletService() {

    }

    public static ClientWalletService getClientWalletService() {
        if (clientWalletService == null) {
            clientWalletService = new ClientWalletService();
            return clientWalletService;
        } else return clientWalletService;
    }

    public int getWalletMoney() {
        return DataBase.clientWalletMap.get(DataBase.currentClient.getClientWalletID()).getMoney();
    }

    public void viewWalletMoney() {
        System.out.println("Wallet money: " + getWalletMoney());
    }

    public void depositMoney() {
        System.out.println("----------------------------");
        System.out.println("Deposit money to wallet");
        System.out.println("Input money: ");
        Scanner sc = new Scanner(System.in);
        int plusMoney;
        do {
            try {
                plusMoney = sc.nextInt();
                if (plusMoney < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("The input value is not valid, please try again");
            }
        } while (true);
        ClientWallet clientWallet = DataBase.clientWalletMap.get(DataBase.currentClient.getClientWalletID());
        clientWallet.setMoney(clientWallet.getMoney() + plusMoney);
        WriteAllData.getWriteAllData().writeData();
        System.out.println("Deposit money success");
        viewWalletMoney();
        CreateLogService.getCreateLogService().createDepositClientLogService(plusMoney, clientWallet.getMoney());
    }

    public void withdrawMoney() {
        System.out.println("----------------------------");
        System.out.println("Deposit money to wallet");
        System.out.println("Input money: ");
        Scanner sc = new Scanner(System.in);
        int minusMoney;
        do {
            try {
                minusMoney = sc.nextInt();
                minusMoney *= - 1;
                if (minusMoney > 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("The input value is not valid, please try again");
            }
        } while (true);
        ClientWallet clientWallet = DataBase.clientWalletMap.get(DataBase.currentClient.getClientWalletID());
        clientWallet.setMoney(clientWallet.getMoney() + minusMoney);
        WriteAllData.getWriteAllData().writeData();
        System.out.println("Withdraw money success");
        viewWalletMoney();
        CreateLogService.getCreateLogService().createDepositClientLogService(minusMoney, clientWallet.getMoney());
    }

    public void viewTransactionHistory() {
        List <ClientWalletLog> clientWalletLogList = new ArrayList <>();
        Map <UUID, Seller> sellerMap = new HashMap <>();
        DataBase.clientWalletLogMap.forEach((key, value) -> {
            if (value.getClientWalletID().equals(DataBase.currentClient.getClientWalletID())) {
                clientWalletLogList.add(value);
            }
        });
        DataBase.sellerMap.forEach((key, value) -> {
            sellerMap.put(value.getSellerWalletID(), value);
        });
        clientWalletLogList.forEach((value) -> {
            if (sellerMap.get(value.getSellerWalletID()) == null) {
                System.out.println("Deposit or Withdraw: " + value.toString());
            } else {
                System.out.println("To store: " + sellerMap.get(value.getSellerWalletID()).getSellerName() + ", " + value.toString());
            }
        });
    }
}
