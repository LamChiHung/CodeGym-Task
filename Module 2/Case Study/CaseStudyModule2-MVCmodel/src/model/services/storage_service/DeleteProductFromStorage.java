package model.services.storage_service;

import main.StoreMain;
import model.models.imp.Product;
import model.utils.read_write_file.WriteSeller;

import java.util.Map;

public class DeleteProductFromStorage {
    public static void deleteProductFromStorage(String name) {
        Map <String, Product> productMap = StoreMain.currentSeller.getStorage().getProductMap();
        if (productMap.containsKey(name)) {
            Product product = productMap.get(name);
            System.out.println(product.getName() + " is deleted from storage sucessfully!");
            productMap.remove(product.getName());
        } else {
            System.out.println("Can't find the product");
        }
        DisplayStorage.displayStorage();
        WriteSeller.writeSeller(StoreMain.currentSeller);
    }
}
