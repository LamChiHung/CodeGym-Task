package model.services;

import main.StoreMain;
import model.models.imp.Client;
import model.models.imp.Seller;
import model.utils.read_write_file.ReadClient;
import model.utils.read_write_file.ReadSeller;

import java.util.Map;

public class SignInService {
    public static void signInAsClient(String username, String password) {
        Map <String, Client> clientMap = ReadClient.readClient();
        if (clientMap.containsKey(username)) {
            Client client = clientMap.get(username);
            if (client.getPassword().equals(password)) {
                StoreMain.currenClient = client;
                System.out.println("Sign In successfully!");
            } else {
                System.out.println("Username or Password is not correct, please check again!");
            }
        } else {
            System.out.println("Username or Password is not correct, please check again!");
        }
    }

    public static void signInAsSeller(String username, String password) {
        Map <String, Seller> sellerMap = ReadSeller.readSeller();
        if (sellerMap.containsKey(username)) {
            Seller seller = sellerMap.get(username);
            if (seller.getPassword().equals(password)) {
                StoreMain.currentSeller = seller;
                System.out.println("Sign In successfully!");
            } else {
                System.out.println("Username or Password is not correct, please check again!");
            }
        } else {
            System.out.println("Username or Password is not correct, please check again!");
        }
    }
}
