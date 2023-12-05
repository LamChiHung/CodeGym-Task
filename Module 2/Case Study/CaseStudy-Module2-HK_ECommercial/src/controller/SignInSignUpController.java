package controller;

import service.sign_in_sign_up.SignInAsClientService;
import service.sign_in_sign_up.SignInAsSellerService;
import service.sign_in_sign_up.SignUpAsClientService;
import service.sign_in_sign_up.SignUpAsSellerService;
import view.ClientMenu;
import view.SellerMenu;
import view.SignInSignUpMenu;

public class SignInSignUpController {
    private static SignInSignUpController signInSignUpController;

    private SignInSignUpController() {

    }

    public static SignInSignUpController getSignInSignUpController() {
        if (signInSignUpController == null) {
            signInSignUpController = new SignInSignUpController();
            return signInSignUpController;
        } else return signInSignUpController;
    }

    public void signInSignUpController(String choice) {
        switch (choice) {
            case "1":
                SignInSignUpMenu.signUpSellerMenu();
                break;
            case "2":
                SignInSignUpMenu.signInSellerMenu();
                break;
            case "3":
                SignInSignUpMenu.signUpClientMenu();
                break;
            case "4":
                SignInSignUpMenu.signInClientMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                SignInSignUpMenu.signInsignUpMenu();
                break;
        }
    }

    public void signUpSellerController(String username, String password, String phoneNumber, String email) {
        SignUpAsSellerService signUpAsSellerService = SignUpAsSellerService.getSignUpAsSellerService();
        signUpAsSellerService.signUpAsSellerService(username, password, phoneNumber, email);
        SignInSignUpMenu.signInsignUpMenu();
    }

    public void signInSellerController(String username, String password) {
        SignInAsSellerService signInAsSellerService = SignInAsSellerService.getSignInAsSellerService();
        boolean accountIsValid = signInAsSellerService.signInAsSellerService(username, password);
        if (accountIsValid) {
            SellerMenu.sellerMainMenu();
        } else {
            SignInSignUpMenu.signInsignUpMenu();
        }
    }

    public void signUpClientController(String username, String password, String phoneNumber, String email) {
        SignUpAsClientService.getSignUpAsClientService().signUpAsClientService(username, password, phoneNumber, email);
        SignInSignUpMenu.signInsignUpMenu();
    }

    public void signInClientController(String username, String password) {
        boolean accountIsValid = SignInAsClientService.getSigInAsClientService().signInAsClientService(username, password);
        if (accountIsValid) {
            ClientMenu.clientMainMenu();
        } else {
            SignInSignUpMenu.signInClientMenu();
        }
    }

}
