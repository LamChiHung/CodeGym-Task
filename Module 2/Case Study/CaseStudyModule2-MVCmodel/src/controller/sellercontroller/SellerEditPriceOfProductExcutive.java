package controller.sellercontroller;

import model.services.StorageService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SellerEditPriceOfProductExcutive {
    public static void sellerEditPriceOfProductExcutive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("4. Edit unit price of product");
        System.out.println("Input product name");
        String name = sc.nextLine();
        try {
            System.out.println("Input new unit price");
            int unitPrice = sc.nextInt();
            sc.nextLine();
            StorageService.editUnitPriceOfProduct(name, unitPrice);
        } catch (InputMismatchException e) {
            System.out.println("Please input valid information");
        }
    }
}
