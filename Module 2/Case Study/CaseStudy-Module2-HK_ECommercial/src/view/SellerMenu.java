package view;

import controller.SellerMenuController;

import java.util.Scanner;

public class SellerMenu {
    static Scanner sc = new Scanner(System.in);

    public static void sellerMainMenu() {
        System.out.println("===================");
        System.out.println("Seller Menu");
        System.out.println("[1] Storage");
        System.out.println("[2] Wallet");
        System.out.println("[3] Coupon");
        System.out.println("[4] Bills");
        System.out.println("[5] Logout");
        System.out.println("-------------------");
        System.out.println("Input your choice");
        String choice = sc.nextLine();
        SellerMenuController.getSellerMenuController().sellerMainMenuController(choice);
    }

    public static void sellerStorageMenu() {
        System.out.println("========================");
        System.out.println("Seller storage menu");
        System.out.println("[1] View storage");
        System.out.println("[2] Add product to storage");
        System.out.println("[3] Delete product to storage");
        System.out.println("[4] Edit numbers of product");
        System.out.println("[5] Edit unit price of product");
        System.out.println("[6] Edit promote of product");
        System.out.println("[7] Back to seller main menu");
        String choice = sc.nextLine();
        SellerMenuController.getSellerMenuController().sellerStorageMenuController(choice);

    }

    public static void sellerWalletMenu() {
        System.out.println("========================");
        System.out.println("Seller wallet menu");
        System.out.println("[1] View money in wallet");
        System.out.println("[2] View transaction history");
        System.out.println("[3] Back to seller main menu");
        String choice = sc.nextLine();
        SellerMenuController.getSellerMenuController().sellerWalletMenuController(choice);
    }

    public static void sellerCouponMenu() {
        System.out.println("========================");
        System.out.println("Seller coupon menu");
        System.out.println("[1] View coupon");
        System.out.println("[2] Add coupon");
        System.out.println("[3] Delete coupon");
        System.out.println("[4] Back to seller main menu");
        String choice = sc.nextLine();
        SellerMenuController.getSellerMenuController().sellerCouponMenuController(choice);
    }
}
