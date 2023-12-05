package service.sign_in_sign_up;

import database.DataBase;
import service.locked_account.LockedClientService;
import service.locked_account.UnlockedClientAccount;
import util.ReadAllData;
import util.WriteAllData;
import util.read_data.ReadLockedClientData;
import view.SignInSignUpMenu;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SignInAsClientService {
    private static SignInAsClientService sigInAsClientService;

    private SignInAsClientService() {

    }

    public static SignInAsClientService getSigInAsClientService() {
        if (sigInAsClientService == null) {
            sigInAsClientService = new SignInAsClientService();
            return sigInAsClientService;
        } else return sigInAsClientService;
    }

    public boolean signInAsClientService(String username, String password) {
        ReadAllData.getReadAllData().readData();
        UnlockedClientAccount.getUnlockedClientAccount().runUnlockedClientAccount();
        AtomicBoolean isValid = new AtomicBoolean(false);
        if (DataBase.clientMap.isEmpty()) {
            System.out.println("Username or password is incorrect, please check again!");
        } else {
            DataBase.clientMap.forEach((key, value) -> {
                if (value.getUsername().equals(username) && value.getPassword().equals(password)) {
                    DataBase.currentClient = DataBase.clientMap.get(key);
                    if (DataBase.currentClient.isStatus()) {
                        isValid.set(true);
                        System.out.println("Sign in successfully as: " + username);
                        DataBase.lockedClientMap.remove(DataBase.currentClient.getClientID());
                        DataBase.signInIncorrectClientList.clear();
                    } else {
                        System.out.println("Your account is locked to: " + DataBase.lockedClientMap.get(DataBase.currentClient.getClientID()).getEndTimeLocked().toString());
                    }
                }
            });
            if (! isValid.get()) {
                System.out.println("Username or password is incorrect, please check again!");
                DataBase.signInIncorrectClientList.add(username);
                AtomicInteger count = new AtomicInteger();
                DataBase.signInIncorrectClientList.forEach((value) -> {
                    if (value.equals(username)) {
                        count.getAndIncrement();
                        if (count.get() > 4) {
                            DataBase.clientMap.forEach((key, client) -> {
                                if (client.getUsername().equals(username)) {
                                    client.setStatus(false);
                                    WriteAllData.getWriteAllData().writeData();
                                    LockedClientService.getLockedClientService().lockedClientService(client);
                                    ReadLockedClientData.getReadLockedClientData().readData();
                                    System.out.println("Your account is locked to: " + DataBase.lockedClientMap.get(client.getClientID()).getEndTimeLocked());
                                    SignInSignUpMenu.signInsignUpMenu();
                                }
                            });
                            System.out.println("You account is locked!");
                            SignInSignUpMenu.signInsignUpMenu();
                        }
                    }
                });
                System.out.println("You have " + (5 - count.get()) + " times left to sign in!");
                count.set(0);

            }

        }
        return isValid.get();
    }
}
