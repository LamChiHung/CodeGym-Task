import Regex.PasswordRegex;
import Regex.UserNameRegex;
import Stores.Stores;
import appending_object_output_stream.ReadClient;
import appending_object_output_stream.ReadSeller;
import appending_object_output_stream.WriteClient;
import appending_object_output_stream.WriteSeller;
import client_seller.Client;
import client_seller.Seller;
import sign_in_and_sign_up.SignInAsClient;
import sign_in_and_sign_up.SignInAsSeller;
import sign_in_and_sign_up.SignUpAsClient;
import sign_in_and_sign_up.SignUpAsSeller;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Client currentClient;
    static Seller currentSeller;
    static Map <String, Seller> currentSellerMap;
    static Map <String, Client> currentClientMap;

    public static void main(String[] args) {
        do {
            System.out.println("===========================================================");
            System.out.println("Welcome to Hpee! Choice your action by select the number");
            System.out.println("1. Sign Up as Client");
            System.out.println("2. Sign Up as Seller");
            System.out.println("3. Sign In as Client");
            System.out.println("4. Sign In as Seller");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Input your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    signUpAsClient();
                    break;
                case "2":
                    signUpAsSeller();
                    break;
                case "3":
                    signInAsClient();
                    break;
                case "4":
                    signInAsSeller();
                    break;
                default:
                    System.out.println("Please choice the correct number!");
                    break;
            }
        } while (currentClient == null && currentSeller == null);
        if (currentSeller != null) {
            do {
                currentSellerMap = ReadSeller.readSeller();
                System.out.println("===========================================================");
                System.out.println("Seller Menu");
                System.out.println("1. Add product");
                System.out.println("2. Delete product");
                System.out.println("3. Edit numbers of product");
                System.out.println("4. Edit type of product");
                System.out.println("5. Edit unit price of product");
                System.out.println("6. Edit promote of product");
                System.out.println("7. Display storage");
                System.out.println("8. Set new password");
                System.out.println("9. Display Wallet");
                System.out.println("10. Close the app");
                System.out.println("-----------------------------------");
                System.out.println("Input your choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        addProductToSellerStorage();
                        break;
                    case "2":
                        deleteProductFromSellerStorage();
                        break;
                    case "3":
                        editNumbersOfProductInSellerStorage();
                        break;
                    case "4":
                        editTypeOfProductInSellerStorage();
                        break;
                    case "5":
                        editUnitPriceOfProductInSellerStorage();
                        break;
                    case "6":
                        editPromoteOfProductInSellerStorage();
                        break;
                    case "7":
                        currentSeller.sellerStorageInformation();
                        break;
                    case "8":
                        changeSellerPassword();
                        break;
                    case "9":
                        currentSeller.mainWallet.displayMoney();
                        break;
                    case "10":
                        System.out.println("Thank you for using Hpee! See you again!");
                        System.out.println("=========================================");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choice the correct number");
                        break;
                }
            } while (true);

        } else {
            do {
                Stores stores = Stores.accessStores();
                currentSellerMap = Stores.sellerMap;
                currentClientMap = ReadClient.readClient();
                System.out.println("===========================================================");
                System.out.println("Client Menu");
                System.out.println("1. View Store");
                System.out.println("2. Buy product");
                System.out.println("3. Delete product from Cart");
                System.out.println("4. Edit numbers of product in Cart");
                System.out.println("5. Search Product");
                System.out.println("6. Sort Product by Unit Price");
                System.out.println("7. View cart");
                System.out.println("8. Pay bill");
                System.out.println("9. View Wallet");
                System.out.println("10. Deposit money from Bank Wallet to Main Wallet");
                System.out.println("11. Deposit money from Momo Wallet to Main Wallet");
                System.out.println("12. Close the app!");
                System.out.println("-----------------------------------");
                System.out.println("Input your choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        stores.getStoresView();
                        break;
                    case "2":
                        stores.getStoresView();
                        buyProduct();
                        break;
                    case "3":
                        removeProduct();
                        break;
                    case "4":
                        editNumberOfProductInCart();
                        break;
                    case "5":
                        searchProduct(stores);
                        break;
                    case "6":
                        sortProductByPrice(stores);
                        break;
                    case "7":
                        currentClient.cart.displayCart();
                        break;
                    case "8":
                        payBill();
                        break;
                    case "9":
                        currentClient.mainWallet.displayMoney();
                        break;
                    case "10":
                        depositToMainWallet(0);
                        break;
                    case "11":
                        depositToMainWallet(1);
                        break;
                    case "12":
                        System.out.println("Thank you for using Hpee! See you again!");
                        System.out.println("=========================================");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choice the correct number");
                        break;
                }
            } while (true);
        }
    }

    private static void payBill() {
        currentClient.mainWallet.payBill(currentSellerMap);
        currentClientMap.put(currentClient.getUsername(), currentClient);
        WriteClient.writeClient(currentClientMap);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void sortProductByPrice(Stores stores) {
        System.out.println("Sort Product bu Unit Price: ");
        System.out.println("-------------------------------");
        stores.getStoresView();
        System.out.println("Input product name: ");
        String productName = sc.nextLine();
        stores.sortProductView(productName);
    }

    private static void searchProduct(Stores stores) {
        System.out.println("Search Product: ");
        System.out.println("------------------");
        System.out.println("Input product name");
        String productName = sc.nextLine();
        stores.searchProductView(productName);
    }

    private static void editNumberOfProductInCart() {
        System.out.println("Edit numbers of product: ");
        System.out.println("---------------------------");
        currentClient.cart.displayCart();
        System.out.println("Input product name: ");
        String productName = sc.nextLine();
        System.out.println("Input store name: ");
        String storeName = sc.nextLine();
        System.out.println("Edit numbers of product: ");
        int numbers = 0;
        try {
            numbers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentClient.cart.editProduct(currentSellerMap, storeName, productName, numbers);
        currentClientMap.put(currentClient.getUsername(), currentClient);
        WriteSeller.writeSeller(currentSellerMap);
        WriteClient.writeClient(currentClientMap);
    }

    private static void removeProduct() {
        System.out.println("Remove product: ");
        currentClient.cart.displayCart();
        System.out.println("Input the product name to remove from cart: ");
        String productName = sc.nextLine();
        System.out.println("Input the store name of product: ");
        String sellerName = sc.nextLine();
        currentClient.cart.removeProduct(currentSellerMap, sellerName, productName);
        currentClientMap.put(currentClient.getUsername(), currentClient);
        WriteClient.writeClient(currentClientMap);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void depositToMainWallet(int walletIndex) {
        System.out.println("Deposit money to Main Wallet:");
        currentClient.mainWallet.displayMoney();
        System.out.println("Input money deposite: ");
        int money = 0;
        try {
            money = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentClient.mainWallet.add(walletIndex, money);
        currentClientMap.put(currentClient.getUsername(), currentClient);
        WriteClient.writeClient(currentClientMap);
    }

    private static void buyProduct() {
        System.out.println("Buy product: ");
        System.out.println("--------------------------");
        System.out.println("Input the store name: ");
        String storeName = sc.nextLine();
        System.out.println("Input product name: ");
        String productName = sc.nextLine();
        System.out.println("Input numbers: ");
        int numbers = 0;
        try {
            numbers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentClient.cart.addProduct(currentSellerMap, storeName, productName, numbers);
        currentClientMap.put(currentClient.getUsername(), currentClient);
        WriteClient.writeClient(currentClientMap);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void changeSellerPassword() {
        System.out.println("Change password: ");
        System.out.println("--------------------");
        System.out.println("Input old password: ");
        String oldPassword = sc.nextLine();
        System.out.println("Input new password: (password include a-z and 1-9 chars and at least have 6 chars)");
        String newPassword = sc.nextLine();
        if (PasswordRegex.checkPasswordRegex(newPassword)) {
            currentSeller.changePassword(oldPassword, newPassword);
            currentSellerMap.put(currentSeller.getUsername(), currentSeller);
            WriteSeller.writeSeller(currentSellerMap);
        } else {
            System.out.println("New password is not valid!");
        }
    }

    private static void editPromoteOfProductInSellerStorage() {
        System.out.println("Edit Promote: ");
        System.out.println("----------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input product name: ");
        String name = sc.nextLine();
        System.out.println("Input new promote: ");
        int promote = 0;
        try {
            promote = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentSeller.sellerStorage.editPromote(name, promote);
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void editUnitPriceOfProductInSellerStorage() {
        System.out.println("Edit unit price: ");
        System.out.println("-------------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input product name: ");
        String name = sc.nextLine();
        System.out.println("Input new unit price");
        int uniPrice = 0;
        try {
            uniPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentSeller.sellerStorage.editUnitPrice(name, uniPrice);
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void editTypeOfProductInSellerStorage() {
        System.out.println("Edit Type Of Product: ");
        System.out.println("-----------------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input product name: ");
        String name = sc.nextLine();
        System.out.println("Input product type");
        String type = sc.nextLine();
        currentSeller.sellerStorage.editType(name, type);
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void editNumbersOfProductInSellerStorage() {
        System.out.println("Edit numbers of product: ");
        System.out.println("---------------------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input product name: ");
        String name = sc.nextLine();
        System.out.println("Input new numbers: ");
        int numbers = 0;
        try {
            numbers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentSeller.sellerStorage.editNumbers(name, numbers);
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void deleteProductFromSellerStorage() {
        System.out.println("Delete Product From Storage: ");
        System.out.println("------------------------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input the product name: ");
        String name = sc.nextLine();
        currentSeller.sellerStorage.delete(name);
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void addProductToSellerStorage() {
        System.out.println("Add New Product To Storage:");
        System.out.println("-----------------------------");
        currentSeller.sellerStorageInformation();
        System.out.println("Input product name: ");
        String name = sc.nextLine();
        System.out.println("Input product unit price");
        int unitPrice = 0;
        try {
            unitPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        System.out.println("Input product numbers");
        int numbers = 0;
        try {
            numbers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("PLease, input valid numbers");
            return;
        }
        sc.nextLine();
        currentSeller.sellerStorage.add(name, unitPrice, numbers);
        System.out.println("Seller Storage: ");
        currentSeller.sellerStorageInformation();
        currentSellerMap.put(currentSeller.getUsername(), currentSeller);
        WriteSeller.writeSeller(currentSellerMap);
    }

    private static void signInAsSeller() {
        System.out.println("Sign In As Seller: ");
        System.out.println("Input your username: ");
        String username = sc.nextLine();
        System.out.println("Input your password: ");
        String password = sc.nextLine();
        SignInAsSeller signInAsSeller = new SignInAsSeller();
        currentSeller = signInAsSeller.signInAsSeller(username, password);
    }

    private static void signUpAsSeller() {
        System.out.println("Sign Up As Selller: ");
        System.out.println("Input your username: (username include a-z and 1-9 chars but numbers can't at the head)");
        String username = sc.nextLine();
        System.out.println("Input your password: (password include a-z and 1-9 chars and at least have 6 chars)");
        String password = sc.nextLine();
        if (UserNameRegex.checkUserNameRegex(username) | PasswordRegex.checkPasswordRegex(password)) {
            SignUpAsSeller signUpAsSeller = new SignUpAsSeller();
            signUpAsSeller.signUpAsSeller(username, password);
        } else {
            System.out.println("Username or Password is not valid");
        }
    }

    private static void signInAsClient() {
        System.out.println("Sign In As Client: ");
        System.out.println("Input your username: ");
        String username = sc.nextLine();
        System.out.println("Input your password: ");
        String password = sc.nextLine();
        SignInAsClient signInAsClient = new SignInAsClient();
        currentClient = signInAsClient.signIn(username, password);
    }

    private static void signUpAsClient() {
        System.out.println("Sign Up At Client: ");
        System.out.println("Input your username: (username include a-z and 1-9 chars but numbers can't at the head)");
        String username = sc.nextLine();
        System.out.println("Input your password: (password include a-z and 1-9 chars and at least have 6 chars)");
        String password = sc.nextLine();
        if (UserNameRegex.checkUserNameRegex(username) | PasswordRegex.checkPasswordRegex(password)) {
            SignUpAsClient signUpAsClient = new SignUpAsClient();
            signUpAsClient.signUp(username, password);
        } else {
            System.out.println("Username or Password is not valid");
        }

    }
}