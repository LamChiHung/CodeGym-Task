package view;

import controller.SignInSignUpController;
import exception.InputRegexException;
import regex.EmailRegex;
import regex.PasswordRegex;
import regex.PhoneNumberRegex;
import regex.UserNameRegex;

import java.util.Scanner;

public class SignInSignUpMenu {
    static Scanner sc = new Scanner(System.in);

    public static void signInsignUpMenu() {
        System.out.println("============================");
        System.out.println("Welcome to HK E-Commercial");
        System.out.println("Please select your choice to continue!");
        System.out.println("[1] Sign up as seller");
        System.out.println("[2] Sign in as seller");
        System.out.println("[3] Sign up as client");
        System.out.println("[4] Sign in as client");
        System.out.println("---------------------------------------");
        System.out.println("Input your choice: ");
        String choice = sc.nextLine();
        SignInSignUpController signInSignUpController = SignInSignUpController.getSignInSignUpController();
        signInSignUpController.signInSignUpController(choice);
    }

    public static void signUpSellerMenu() {
        System.out.println("======================");
        System.out.println("Sign up menu");
        String username;
        do {
            try {
                System.out.println("Input your username: \n" +
                        "(The username must be lowercase, can't have the special character and number can't at first line )");
                username = sc.nextLine();
                if (! UserNameRegex.userNameRegex(username)) {
                    throw new InputRegexException();
                } else break;
            } catch (
                    InputRegexException e) {
                e.printStackTrace();
            }
        } while (true);
        String password = null;
        do {

            try {
                System.out.println("Input your password:\n" +
                        "(The password must Minimum eight characters, at least one UpperCase and one number: ");
                password = sc.nextLine();
                if (! PasswordRegex.passWordRegex(password)) {
                    throw new InputRegexException();
                }
            } catch (
                    InputRegexException e) {
                e.printStackTrace();
                continue;
            }
            System.out.println("Confirm your password:");
            String passwordConfirm = sc.nextLine();
            if (! passwordConfirm.equals(password)) {
                System.out.println("The password confirmation is not correct!");
            } else break;
        } while (true);
        String phoneNumber = null;
        do {
            try {
                System.out.println("Input your phone number:");
                phoneNumber = sc.nextLine();
                if (! PhoneNumberRegex.phoneNumberRegex(phoneNumber)) {
                    throw new InputRegexException();
                } else break;
            } catch (InputRegexException e) {
                e.printStackTrace();
                continue;
            }
        } while (true);
        String email;
        do {
            try {
                System.out.println("Input your email:");
                email = sc.nextLine();
                if (! EmailRegex.emailRegex(email)) {
                    throw new InputRegexException();
                } else break;
            } catch (InputRegexException e) {
                e.printStackTrace();
                continue;
            }
        } while (true);
        SignInSignUpController signInSignUpController = SignInSignUpController.getSignInSignUpController();
        signInSignUpController.signUpSellerController(username, password, phoneNumber, email);
    }

    public static void signInSellerMenu() {
        System.out.println("======================");
        System.out.println("Sign in menu");
        System.out.println("Input your username:");
        String username = sc.nextLine();
        System.out.println("Input your pass password");
        String password = sc.nextLine();
        SignInSignUpController signInSignUpController = SignInSignUpController.getSignInSignUpController();
        signInSignUpController.signInSellerController(username, password);

    }

    public static void signUpClientMenu() {
        System.out.println("======================");
        System.out.println("Sign up menu");
        String username;
        do {
            try {
                System.out.println("Input your username: \n" +
                        "(The username must be lowercase, can't have the special character and number can't at first line )");
                username = sc.nextLine();
                if (! UserNameRegex.userNameRegex(username)) {
                    throw new InputRegexException();
                } else break;
            } catch (
                    InputRegexException e) {
                e.printStackTrace();
            }
        } while (true);
        String password = null;
        do {

            try {
                System.out.println("Input your password:\n" +
                        "(The password must Minimum eight characters, at least one UpperCase and one number: ");
                password = sc.nextLine();
                if (! PasswordRegex.passWordRegex(password)) {
                    throw new InputRegexException();
                }
            } catch (
                    InputRegexException e) {
                e.printStackTrace();
                continue;
            }
            System.out.println("Confirm your password:");
            String passwordConfirm = sc.nextLine();
            if (! passwordConfirm.equals(password)) {
                System.out.println("The password confirmation is not correct!");
            } else break;
        } while (true);
        String phoneNumber = null;
        do {
            try {
                System.out.println("Input your phone number:");
                phoneNumber = sc.nextLine();
                if (! PhoneNumberRegex.phoneNumberRegex(phoneNumber)) {
                    throw new InputRegexException();
                } else break;
            } catch (InputRegexException e) {
                e.printStackTrace();
                continue;
            }
        } while (true);
        String email;
        do {
            try {
                System.out.println("Input your email:");
                email = sc.nextLine();
                if (! EmailRegex.emailRegex(email)) {
                    throw new InputRegexException();
                } else break;
            } catch (InputRegexException e) {
                e.printStackTrace();
                continue;
            }
        } while (true);
        SignInSignUpController.getSignInSignUpController().signUpClientController(username, password, phoneNumber, email);
    }

    public static void signInClientMenu() {
        System.out.println("======================");
        System.out.println("Sign in menu");
        System.out.println("Input your username:");
        String username = sc.nextLine();
        System.out.println("Input your pass password");
        String password = sc.nextLine();
        SignInSignUpController signInSignUpController = SignInSignUpController.getSignInSignUpController();
        signInSignUpController.signInClientController(username, password);
    }

}
