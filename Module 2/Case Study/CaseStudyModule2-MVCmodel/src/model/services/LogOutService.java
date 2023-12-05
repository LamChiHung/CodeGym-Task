package model.services;

import controller.SignInSignUpController;
import main.StoreMain;

public class LogOutService {
    public static void logOutService() {
        StoreMain.currentSeller = null;
        StoreMain.currenClient = null;
        SignInSignUpController.signInSignUpController();
    }
}
