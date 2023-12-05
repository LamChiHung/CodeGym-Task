package controller;

import controller.sellercontroller.SellerAddProductToStorageExcutive;
import controller.sellercontroller.SellerDeleteProductFromStorageExcutive;
import controller.sellercontroller.SellerEditNumbersOfProductExcutive;
import controller.sellercontroller.SellerEditPriceOfProductExcutive;
import main.StoreMain;
import model.services.LogOutService;
import model.services.StorageService;

import java.util.Scanner;

public class SellerController {
    public static void sellerController() {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("===========================================================");
            System.out.println(StoreMain.currentSeller);
            System.out.println("------------");
            System.out.println("Seller Menu");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Edit numbers of product");
            System.out.println("4. Edit unit price of product");
            System.out.println("5. Edit promote of product");
            System.out.println("6. Display storage");
            System.out.println("7. Display numbers of product have sold");
            System.out.println("8. Set new password");
            System.out.println("9. Display Wallet");
            System.out.println("10. Log Out!");
            System.out.println("-----------------------------------");
            System.out.println("Input your choice: ");
            choice = sc.nextLine();
            System.out.println("------------------------------------");
            switch (choice) {
                case "1":
                    SellerAddProductToStorageExcutive.sellerAddProDuctToStorageExcutive();
                    break;
                case "2":
                    SellerDeleteProductFromStorageExcutive.sellerDeleteProductFromStorageExcutive();
                    break;
                case "3":
                    SellerEditNumbersOfProductExcutive.sellerEditNumbersOfProductExcutive();
                    break;
                case "4":
                    SellerEditPriceOfProductExcutive.sellerEditPriceOfProductExcutive();
                    break;
                case "5":

                    break;
                case "6":
                    break;
                case "7":
                    StorageService.displayProduct();
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    LogOutService.logOutService();
                    break;
                default:
                    System.out.println("Please input the valid choice!");
                    break;
            }
        } while (true);


    }
}
