package model.services.storage_service;

import main.StoreMain;
import model.models.imp.Product;
import model.utils.read_write_file.WriteSeller;

public class EditPromoteProductInStorage {
    public static void editPromoteProductInStorage(String name, int promote) {
        if (promote > 0 && promote < 100) {
            Product product = StoreMain.currentSeller.getStorage().getProductMap().get(name);
            if (product != null) {
                product.setPromote(promote);
                System.out.println("Edit promote successfully!");
                WriteSeller.writeSeller(StoreMain.currentSeller);
            } else {
                System.out.println("Can't find the product");
            }
        } else {
            System.out.println("The promote input is not valid");
        }
    }
}
