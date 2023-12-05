package controller.sellercontroller;

import model.services.StorageService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SellerEditNumbersOfProductExcutive {
    public static void sellerEditNumbersOfProductExcutive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("3. Edit numbers of product");
        System.out.println("Input product name");
        String name = sc.nextLine();
        try {
            System.out.println("Input new numbers");
            int number = sc.nextInt();
            sc.nextLine();
            StorageService.editNumbersOfProduct(name, number);
        } catch (InputMismatchException e) {
            System.out.println("Please input the valid infomation");
        }
    }
}
