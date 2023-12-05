package service.storage_item_service.storageitemservice;

import database.DataBase;
import entity.storage.StorageItem;
import service.storage_item_service.StorageItemService;
import util.WriteAllData;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class AddStorageItem {
    private final StorageItemService storageItemService;

    public AddStorageItem(StorageItemService storageItemService) {
        this.storageItemService = storageItemService;
    }

    public void addItem() {
        storageItemService.viewStore();
        System.out.println("------------------");
        System.out.println("Add new product menu");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input product name");
        String name = sc.nextLine();
        System.out.println("Input quantity");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Input origin unit price");
        int originUnitPrice = sc.nextInt();
        sc.nextLine();
        System.out.println("Input promote");
        int promote = sc.nextInt();
        sc.nextLine();
        AtomicBoolean isValid = new AtomicBoolean(true);
        StorageItem storageItem = new StorageItem(name, quantity, originUnitPrice, promote);
        storageItemService.getStorageItemList().forEach((value) -> {
            if (value.getProductID().equals(storageItem.getProductID())) {
                isValid.set(false);
            }
        });
        if (isValid.get()) {
            DataBase.storageItemMap.put(storageItem.getItemID(), storageItem);
            storageItemService.getStorageItemList().add(storageItem);
            WriteAllData.getWriteAllData().writeData();
            System.out.println("Add new product success");
        } else {
            System.out.println("The product is already exist in your store, please check again!");
        }
    }
}