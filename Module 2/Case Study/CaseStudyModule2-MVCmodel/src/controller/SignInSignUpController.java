package controller;

import main.StoreMain;
import model.services.SignInService;
import model.services.SignUpService;

import java.util.Scanner;

public class SignInSignUpController {
    public static void signInSignUpController() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=======================================================");
            System.out.println("Welcome to HK E-Commercial!\n" +
                    "Please choice your selection to continue: ");
            System.out.println("---------------------------------");
            System.out.println("1. Sign Up As Seller");
            System.out.println("2. Sign In As Seller");
            System.out.println("3. Sign Up As Client");
            System.out.println("4. Sign In As Client");
            System.out.println("---------------------------------");
            System.out.println("Input your choice: ");
            String choice = sc.nextLine();
            System.out.println("----------------------------------");
            switch (choice) {
                case "1":
                    System.out.println("1. Sign Up As Seller");
                    System.out.println("------------------------");
                    System.out.println("Input username: ");
                    String username = sc.nextLine();
                    System.out.println("Input password: ");
                    String password = sc.nextLine();
                    SignUpService.signUpAsSeller(username, password);
                    break;
                case "2":
                    System.out.println("2. Sign In As Seller");
                    System.out.println("-------------------------");
                    System.out.println("Input username: ");
                    username = sc.nextLine();
                    System.out.println("Input password: ");
                    password = sc.nextLine();
                    SignInService.signInAsSeller(username, password);
                    break;
                case "3":
                    System.out.println("3. Sign Up As Client");
                    System.out.println("-----------------------");
                    System.out.println("Input username: ");
                    username = sc.nextLine();
                    System.out.println("Input password: ");
                    password = sc.nextLine();
                    SignUpService.signUpAsClient(username, password);
                    break;
                case "4":
                    System.out.println("4. Sign In As Client");
                    System.out.println("-----------------------");
                    System.out.println("Input username: ");
                    username = sc.nextLine();
                    System.out.println("Input password: ");
                    password = sc.nextLine();
                    SignInService.signInAsClient(username, password);
                    break;
                default:
                    System.out.println("Please input the valid choice!");
                    break;
            }
        } while (StoreMain.currentSeller == null & StoreMain.currenClient == null);
    }
}
