package view;

import controller.ClientMenuController;

import java.util.Scanner;

public class ClientMenu {
    public static Scanner sc = new Scanner(System.in);

    public static void clientMainMenu() {
        System.out.println("=====================");
        System.out.println("Client Menu");
        System.out.println("[1] Store");
        System.out.println("[2] Cart");
        System.out.println("[3] Wallet");
        System.out.println("[4] Bills");
        System.out.println("[5] Logout");
        System.out.println("-------------------");
        System.out.println("Input your choice");
        String choice = sc.nextLine();
        ClientMenuController.getClientMenuController().clientMainMenuController(choice);
    }

    public static void clientStoreMenu() {
        System.out.println("======================");
        System.out.println("[1] View store");
        System.out.println("[2] Get in store");
        System.out.println("[3] Find product by name");
        System.out.println("[4] Find product by type");
        System.out.println("[5] Add product to cart");
        System.out.println("[6] Back to client main menu");
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Input your choice:");
        String choice = sc.nextLine();
        ClientMenuController.getClientMenuController().clientStoreMenuController(choice);
    }

    public static void clientCartMenu() {
        System.out.println("---------------------");
        System.out.println("[1] Buy more product");
        System.out.println("[2] Delete product");
        System.out.println("[3] Edit product quantity");
        System.out.println("[4] Payment");
        System.out.println("[5] Apply coupon");
        System.out.println("[6] Back to client main menu");
        System.out.println("-------------------------");
        System.out.println("Input your choice:");
        String choice = sc.nextLine();
        ClientMenuController.getClientMenuController().clientCartMenuController(choice);
    }

    public static void clientWalletMenu() {
        System.out.println("---------------------");
        System.out.println("[1] Deposit money");
        System.out.println("[2] Withdraw money");
        System.out.println("[3] View transaction history");
        System.out.println("[4] Back to client main menu");
        System.out.println("-------------------------");
        System.out.println("Input your choice:");
        String choice = sc.nextLine();
        ClientMenuController.getClientMenuController().clientWalletMenuController(choice);
    }
}
