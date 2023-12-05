package main;

import controller.SellerController;
import controller.SignInSignUpController;
import model.models.imp.Client;
import model.models.imp.Seller;

import java.util.HashMap;
import java.util.Map;

public class StoreMain {
    public static Map <String, Seller> currentSellerMap = new HashMap <>();
    public static Map <String, Client> currentClientMap = new HashMap <>();
    public static Seller currentSeller;
    public static Client currenClient;


    public static void main(String[] args) {
        SignInSignUpController.signInSignUpController();
        if (currentSeller != null) {
            SellerController.sellerController();
        } else if (currenClient != null) {

        }
    }
}