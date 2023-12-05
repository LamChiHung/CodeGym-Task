package model.services.storage_service;

import main.StoreMain;
import model.models.imp.Product;
import model.utils.read_write_file.WriteSeller;

public class EditUnitPriceProductInStorage {
    public static void editUnitPriceProductInStorage(String name, int unitPrice) {
        Product product = StoreMain.currentSeller.getStorage().getProductMap().get(name);
        if (product != null) {
            if (unitPrice > 0) {
                product.setUnitPrice(unitPrice);
                System.out.println("Edit unit price successfully!");
                WriteSeller.writeSeller(StoreMain.currentSeller);
                DisplayStorage.displayStorage();
            } else {
                System.out.println("The price is not valid!");
            }
        } else {
            System.out.println("Can't find the product");
        }
    }
}
