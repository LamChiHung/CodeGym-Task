package service.storage_item_service.storageitemservice;

import database.DataBase;
import entity.storage.StorageItem;
import service.storage_item_service.StorageItemService;
import util.WriteAllData;

import java.util.InputMismatchException;
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
        int quantity = 0;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Input quantity");
                quantity = sc1.nextInt();
                sc1.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input the valid value");
            }
        } while (true);
        int originUnitPrice = 0;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Input origin unit price");
                originUnitPrice = sc1.nextInt();
                sc1.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input the valid value");
            }
        } while (true);
        int promote = 0;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Input promote");
                promote = sc1.nextInt();
                sc1.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input the valid value");
            }
        } while (true);
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