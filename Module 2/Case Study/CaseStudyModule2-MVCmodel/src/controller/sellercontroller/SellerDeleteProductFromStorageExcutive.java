package controller.sellercontroller;

import model.services.StorageService;
import model.services.storage_service.DisplayStorage;

import java.util.Scanner;

public class SellerDeleteProductFromStorageExcutive {
    public static void sellerDeleteProductFromStorageExcutive() {
        Scanner sc = new Scanner(System.in);
        DisplayStorage.displayStorage();
        System.out.println("2. Delete product");
        System.out.println("Input product name");
        String name = sc.nextLine();
        StorageService.deleteProduct(name);
    }
}
