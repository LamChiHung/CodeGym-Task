package model.services;

import model.services.storage_service.AddProductToStorage;
import model.services.storage_service.DeleteProductFromStorage;
import model.services.storage_service.DisplayStorage;
import model.services.storage_service.EditNumberProductInStorage;
import model.services.storage_service.EditPromoteProductInStorage;
import model.services.storage_service.EditUnitPriceProductInStorage;

public class StorageService {
    public static void addProduct(String name, int unitPrice, int numbers) {
        AddProductToStorage.addProductToStorage(name, unitPrice, numbers);
    }

    public static void deleteProduct(String name) {
        DeleteProductFromStorage.deleteProductFromStorage(name);
    }

    public static void displayProduct() {
        DisplayStorage.displayStorage();
    }

    public static void editNumbersOfProduct(String name, int numbers) {
        EditNumberProductInStorage.editNumberProductInStorage(name, numbers);
    }

    public static void editUnitPriceOfProduct(String name, int unitPrice) {
        EditUnitPriceProductInStorage.editUnitPriceProductInStorage(name, unitPrice);
    }

    public static void editPromoteOfProduct(String name, int promote) {
        EditPromoteProductInStorage.editPromoteProductInStorage(name, promote);
    }
}
