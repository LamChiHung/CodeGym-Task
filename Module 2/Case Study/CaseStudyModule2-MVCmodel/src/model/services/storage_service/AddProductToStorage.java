package model.services.storage_service;

import main.StoreMain;
import model.models.imp.Product;
import model.utils.read_write_file.WriteSeller;

import java.util.Map;

public class AddProductToStorage {
    public static void addProductToStorage(String name, int unitPrice, int numbers) {
        if (checkValid(name)) {
            Product product = new Product(name, unitPrice, numbers);
            Map <String, Product> productMap = StoreMain.currentSeller.getStorage().getProductMap();
            productMap.put(product.getName(), product);
            System.out.println(product.getName() + " is added to storage successfully!");
            DisplayStorage.displayStorage();
            WriteSeller.writeSeller(StoreMain.currentSeller);
        } else {
            System.out.println("The product has already in store");
        }
    }

    private static boolean checkValid(String name) {
        Map <String, Product> productMap = StoreMain.currentSeller.getStorage().getProductMap();
        if (productMap.containsKey(name)) {
            return false;
        } else {
            return true;
        }
    }
}
