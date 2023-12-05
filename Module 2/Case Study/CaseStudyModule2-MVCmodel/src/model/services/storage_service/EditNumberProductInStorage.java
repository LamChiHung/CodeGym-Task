package model.services.storage_service;

import main.StoreMain;
import model.models.imp.Product;
import model.utils.read_write_file.WriteSeller;

public class EditNumberProductInStorage {
    public static void editNumberProductInStorage(String name, int numbers) {
        if (numbers > 0) {
            Product product = StoreMain.currentSeller.getStorage().getProductMap().get(name);
            if (product != null) {
                product.setNumbers(numbers);
                System.out.println("Edit numbers of product success!");
                DisplayStorage.displayStorage();
                WriteSeller.writeSeller(StoreMain.currentSeller);
            } else {
                System.out.println("Can't find the product to edit");
            }

        } else {
            System.out.println("The numbers is not valid");
        }
    }
}
