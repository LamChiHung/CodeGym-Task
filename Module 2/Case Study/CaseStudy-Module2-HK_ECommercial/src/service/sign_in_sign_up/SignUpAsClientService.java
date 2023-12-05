package service.sign_in_sign_up;

import database.DataBase;
import entity.user_imp.Client;
import entity_builder.builder_imp.ClientBuilder;
import util.ReadAllData;
import util.WriteAllData;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignUpAsClientService {
    private static SignUpAsClientService signUpAsClientService;

    private SignUpAsClientService() {

    }

    public static SignUpAsClientService getSignUpAsClientService() {
        if (signUpAsClientService == null) {
            signUpAsClientService = new SignUpAsClientService();
            return signUpAsClientService;
        } else return signUpAsClientService;
    }

    public void signUpAsClientService(String username, String password, String phoneNumber, String email) {
        ReadAllData.getReadAllData().readData();
        AtomicBoolean isValid = new AtomicBoolean(true);
        DataBase.clientMap.forEach((key, value) -> {
            if (value.getUsername().equals(username)) {
                isValid.set(false);
            }
        });
        if (isValid.get()) {
            ClientBuilder clientBuilder = ClientBuilder.getClientBuilder();
            clientBuilder.setOrigin();
            clientBuilder.setUsername(username);
            clientBuilder.setPassword(password);
            clientBuilder.setPhoneNumber(phoneNumber);
            clientBuilder.setEmail(email);
            Client client = clientBuilder.buid();
            DataBase.clientMap.put(client.getClientID(), client);
            System.out.println("Sign Up Sucessfully!");
            System.out.println("Please Sign In to continue");
            WriteAllData.getWriteAllData().writeData();
        } else {
            System.out.println("The username is already sign up!");
        }
    }
}
