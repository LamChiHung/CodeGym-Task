package model.services.storage_service;

import main.StoreMain;

public class DisplayStorage {
    public static void displayStorage() {
        StoreMain.currentSeller.getStorage().getProductMap().forEach((key, value) -> {
            System.out.println(value);
        });
    }
}
