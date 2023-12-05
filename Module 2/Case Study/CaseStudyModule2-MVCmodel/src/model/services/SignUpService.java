package model.services;

import model.models.imp.Client;
import model.models.imp.Seller;
import model.utils.read_write_file.ReadClient;
import model.utils.read_write_file.ReadSeller;
import model.utils.read_write_file.WriteClient;
import model.utils.read_write_file.WriteSeller;

import java.util.Map;

public class SignUpService {
    public static void signUpAsClient(String username, String password) {
        Map <String, Client> clientMap = ReadClient.readClient();
        if (clientMap == null | ! clientMap.containsKey(username)) {
            Client client = new Client(username, password);
            WriteClient.writeClient(client);
            System.out.println("Sign Up successfully!");
        } else {
            System.out.println("The username has already Sign Up!");
        }
    }

    public static void signUpAsSeller(String username, String password) {
        Map <String, Seller> sellerMap = ReadSeller.readSeller();
        boolean isValid = false;
        if (sellerMap == null) {
            isValid = true;
        } else if (! sellerMap.containsKey(username)) {
            isValid = true;
        }
        if (isValid) {
            Seller seller = new Seller(username, password);
            WriteSeller.writeSeller(seller);
            System.out.println("Sign Up successfully!");
        } else {
            System.out.println("The username has already Sign Up!");
        }
    }
}
