package controller.sellercontroller;

import model.services.StorageService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SellerAddProductToStorageExcutive {
    public static void sellerAddProDuctToStorageExcutive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add product");
        System.out.println("Input product name");
        String username = sc.nextLine();
        try {
            System.out.println("Input unit price");
            int unitPrice = sc.nextInt();
            sc.nextLine();
            System.out.println("Input numbers");
            int numbers = sc.nextInt();
            sc.nextLine();
            StorageService.addProduct(username, unitPrice, numbers);
        } catch (InputMismatchException e) {
            System.out.println("Please input the valid information!");
        }
    }
}
