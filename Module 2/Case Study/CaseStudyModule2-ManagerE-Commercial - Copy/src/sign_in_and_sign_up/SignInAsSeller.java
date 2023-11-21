package sign_in_and_sign_up;

import appending_object_output_stream.ReadSeller;
import client_seller.Seller;

import java.util.Map;

public class SignInAsSeller {
    Map <String, Seller> sellerMap;

    public Seller signInAsSeller(String username, String password) {
        sellerMap = ReadSeller.readSeller();
        Seller seller;
        if ((seller = checkvalidAccount(username, password)) == null) {
            System.out.println("Check your password or username again");
            return null;
        } else {
            System.out.println("Sign In Sucess!");
            return seller;
        }

    }

    public Seller checkvalidAccount(String username, String password) {
        if (sellerMap == null) {
            return null;
        }
        if (sellerMap.containsKey(username)) {
            Seller seller = sellerMap.get(username);
            if (password.equals(seller.getPassword())) {
                return seller;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
