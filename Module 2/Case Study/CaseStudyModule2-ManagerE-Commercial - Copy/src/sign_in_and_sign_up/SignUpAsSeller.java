package sign_in_and_sign_up;

import appending_object_output_stream.ReadSeller;
import appending_object_output_stream.WriteSeller;
import client_seller.Seller;

import java.util.Map;

public class SignUpAsSeller {
    Map <String, Seller> sellerMap;

    public void signUpAsSeller(String username, String password) {
        sellerMap = ReadSeller.readSeller();
        if (sellerMap == null | checkValidAccount(username) == null) {
            Seller seller = new Seller(username, password);
            sellerMap.put(seller.getUsername(), seller);
            WriteSeller.writeSeller(sellerMap);
            System.out.println("Register sucess!");
        } else {
            System.out.println("User was registered!");
        }

    }

    public Seller checkValidAccount(String username) {
        if (sellerMap == null) {
            return null;
        }
        if (sellerMap.containsKey(username)) {
            return sellerMap.get(username);
        } else {
            return null;
        }
    }
}
