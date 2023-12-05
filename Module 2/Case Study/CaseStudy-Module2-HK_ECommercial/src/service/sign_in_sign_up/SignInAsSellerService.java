package service.sign_in_sign_up;

import database.DataBase;
import entity.lockedaccount_imp.LockedSeller;
import entity.user_imp.Seller;
import service.locked_account.LockedSellerService;
import service.locked_account.UnlockedSellerAccount;
import util.ReadAllData;
import util.WriteAllData;
import view.SignInSignUpMenu;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignInAsSellerService {
    private static SignInAsSellerService signInAsSellerService;

    private SignInAsSellerService() {

    }

    public static SignInAsSellerService getSignInAsSellerService() {
        if (signInAsSellerService == null) {
            signInAsSellerService = new SignInAsSellerService();
            return signInAsSellerService;
        } else return signInAsSellerService;
    }

    public boolean signInAsSellerService(String username, String password) {
        AtomicBoolean accountStatus = new AtomicBoolean(true);
        ReadAllData readAllData = ReadAllData.getReadAllData();
        readAllData.readData();
        UnlockedSellerAccount.getUnlockedSellerAccount().runUnlockedSellerAccount();
        AtomicBoolean isValid = new AtomicBoolean(false);
        DataBase.sellerMap.forEach((key, value) -> {
            if (value.getSellerName().equals(username) && value.getSellerPassword().equals(password)) {
                DataBase.currentSeller = value;
                if (value.isStatus()) {
                    accountStatus.set(true);
                    isValid.set(true);
                } else {
                    accountStatus.set(false);
                }
            }
        });
        if (isValid.get()) {
            System.out.println("Sign in success as: " + DataBase.currentSeller.getSellerName());
            DataBase.lockedSellerMap.remove(DataBase.currentSeller.getSellerID());
            DataBase.signInIncorrectSellerList.clear();
            WriteAllData.getWriteAllData().writeData();
            return isValid.get();
        } else if (! accountStatus.get()) {
            System.out.println("Your account is locked to: " + DataBase.lockedSellerMap.get(DataBase.currentSeller.getSellerID()).getEndTimeLocked().toString());
            SignInSignUpMenu.signInsignUpMenu();
            return accountStatus.get();
        } else {
            System.out.println("The username or password is incorrect, please check again!");
            DataBase.signInIncorrectSellerList.add(username);
            for (int i = 0; i < DataBase.signInIncorrectSellerList.size(); i++) {
                if (DataBase.signInIncorrectSellerList.get(i).equals(username)) {
                    DataBase.countSignInIncorrect++;
                    if (DataBase.countSignInIncorrect > 4) {
                        DataBase.sellerMap.forEach((key, value) -> {
                            if (value.getSellerName().equals(username)) {
                                Seller seller = DataBase.sellerMap.get(key);
                                seller.setStatus(false);
                                LockedSellerService.getLockedSellerService().lockedSellerService(seller);
                                LockedSeller lockedSeller = DataBase.lockedSellerMap.get(seller.getSellerID());
                                System.out.println("Your account is locked to: " + lockedSeller.getEndTimeLocked().toString());
                                WriteAllData.getWriteAllData().writeData();
                                SignInSignUpMenu.signInsignUpMenu();
                            }
                        });
                    }
                }
            }
            System.out.println("You have " + (5 - DataBase.countSignInIncorrect) + " times left to sign in");
            DataBase.countSignInIncorrect = 0;
            return isValid.get();
        }
    }
}
