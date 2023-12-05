package service.sign_in_sign_up;

import database.DataBase;
import entity.user_imp.Seller;
import entity_builder.builder_imp.SellerBuilder;
import util.ReadAllData;
import util.WriteAllData;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignUpAsSellerService {
    private static SignUpAsSellerService signUpAsSellerService;

    private SignUpAsSellerService() {

    }

    public static SignUpAsSellerService getSignUpAsSellerService() {
        if (signUpAsSellerService == null) {
            signUpAsSellerService = new SignUpAsSellerService();
            return signUpAsSellerService;
        } else return signUpAsSellerService;
    }

    public void signUpAsSellerService(String username, String password, String phoneNumber, String email) {
        ReadAllData readAllData = ReadAllData.getReadAllData();
        readAllData.readData();
        AtomicBoolean isValid = new AtomicBoolean(true);
        DataBase.sellerMap.forEach((key, value) -> {
            if (value.getSellerName().equals(username)) {
                isValid.set(false);
            }
        });
        if (isValid.get()) {
            SellerBuilder sellerBuilder = SellerBuilder.getSellerBuilder();
            sellerBuilder.setSellerName(username);
            sellerBuilder.setSellerPassword(password);
            sellerBuilder.setSellerEmail(email);
            sellerBuilder.setSellerPhoneNumber(phoneNumber);
            sellerBuilder.setOrigin();
            Seller seller = sellerBuilder.build();
            DataBase.sellerMap.put(seller.getSellerID(), seller);
            System.out.println("Sign Up Sucessfully!");
            System.out.println("Please Sign In to continue");
            WriteAllData writeAllData = WriteAllData.getWriteAllData();
            writeAllData.writeData();
        } else {
            System.out.println("Username has already sign up!");
        }
    }
}
