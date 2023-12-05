package service.storage_item_service;

import database.DataBase;
import entity.storage.StorageItem;
import service.storage_item_service.storageitemservice.AddStorageItem;
import util.WriteAllData;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class StorageItemService {
    private static StorageItemService storageItemService;
    private final AddStorageItem addStorageItem = new AddStorageItem(this);
    private List <StorageItem> storageItemList;

    private StorageItemService() {
        storageItemList = new ArrayList <>();
        DataBase.storageItemMap.forEach((key, value) -> {
            if (value.getStorageID().equals(DataBase.currentSeller.getStorageID())) {
                storageItemList.add(value);
            }
        });

    }

    public static StorageItemService getStorageItemService() {
        if (storageItemService == null) {
            storageItemService = new StorageItemService();
            return storageItemService;
        } else return storageItemService;
    }

    public void updateStore() {
        storageItemList = new ArrayList <>();
        DataBase.storageItemMap.forEach((key, value) -> {
            if (value.getStorageID().equals(DataBase.currentSeller.getStorageID())) {
                storageItemList.add(value);
            }
        });
    }

    public void viewStore() {
        AtomicReference <String> infomation = new AtomicReference <>();
        updateStore();
        storageItemList.forEach((item) -> {
            DataBase.producttMap.forEach((key, product) -> {
                if (item.getProductID().equals(product.getProductID())) {
                    infomation.set(product.getName() + ", " + item.toString());
                    System.out.println(infomation.get());
                }
            });
        });
    }

    public void addItem() {
        addStorageItem.addItem();
    }

    public void deleteItem() {
        viewStore();
        System.out.println("----------------");
        System.out.println("Delete product menu");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input product name:");
        String productName = sc.nextLine();
        AtomicBoolean isValid = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        AtomicReference <UUID> storageItemID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                productID.set(value.getProductID());
                isValid.set(true);
            }
        });
        if (! isValid.get()) {
            System.out.println("The product is not exist in your store!");
        } else {
            isValid.set(false);
            storageItemList.forEach((value) -> {
                if (value.getProductID().equals(productID.get())) {
                    storageItemID.set(value.getItemID());
                    isValid.set(true);
                }
            });
            if (! isValid.get()) {
                System.out.println("The product is not exist in your store!");
            } else {
                StorageItem storageItem = DataBase.storageItemMap.get(storageItemID.get());
                storageItemService.getStorageItemList().remove(storageItem);
                DataBase.storageItemMap.remove(storageItemID.get());
                WriteAllData.getWriteAllData().writeData();
                System.out.println("Delete product success");
                viewStore();
            }
        }
    }

    public void editQuantityOfItem() {
        viewStore();
        System.out.println("----------------");
        System.out.println("Edit number of product menu");
        System.out.println("Input product name:");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine();
        int newQuantity;
        do {
            Scanner sc1 = new Scanner(System.in);
            try {
                System.out.println("Input new number");
                newQuantity = sc1.nextInt();
                if (newQuantity <= 0) {
                    throw new InputMismatchException();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not valid, please try again!");
            }
        } while (true);
        AtomicBoolean isValid = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        AtomicReference <UUID> storageItemID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                productID.set(value.getProductID());
                isValid.set(true);
            }
        });
        if (! isValid.get()) {
            System.out.println("The product is not exist in your store!");
        } else {
            isValid.set(false);
            storageItemList.forEach((value) -> {
                if (value.getProductID().equals(productID.get())) {
                    storageItemID.set(value.getItemID());
                    isValid.set(true);
                }
            });
            if (! isValid.get()) {
                System.out.println("The product is not exist in your store!");
            } else {
                DataBase.storageItemMap.get(storageItemID.get()).setQuantity(newQuantity);
                WriteAllData.getWriteAllData().writeData();
                System.out.println("Edit quantity of product success!");
                viewStore();
            }
        }
    }

    public void editUnitPriceOfProduct() {
        viewStore();
        System.out.println("---------------");
        System.out.println("Edit unit price of product menu");
        System.out.println("Input product name");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine();
        int newUnitPrice;
        do {
            Scanner sc1 = new Scanner(System.in);
            try {
                System.out.println("Input new unit price");
                newUnitPrice = sc1.nextInt();
                if (newUnitPrice < 1000) {
                    System.out.println("Unit price must higher 1000!");
                    throw new InputMismatchException();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not valid, please try again!");
            }
        } while (true);
        AtomicBoolean isValid = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        AtomicReference <UUID> storageItemID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                productID.set(value.getProductID());
                isValid.set(true);
            }
        });
        if (! isValid.get()) {
            System.out.println("The product is not exist in your store!");
        } else {
            isValid.set(false);
            storageItemList.forEach((value) -> {
                if (value.getProductID().equals(productID.get())) {
                    storageItemID.set(value.getItemID());
                    isValid.set(true);
                }
            });
            if (! isValid.get()) {
                System.out.println("The product is not exist in your store!");
            } else {
                DataBase.storageItemMap.get(storageItemID.get()).setOriginUnitPrice(newUnitPrice);
                WriteAllData.getWriteAllData().writeData();
                System.out.println("Edit unit price of product success!");
                viewStore();
            }
        }
    }

    public void editPromoteOfProduct() {
        viewStore();
        System.out.println("---------------");
        System.out.println("Edit promote of product menu");
        System.out.println("Input product name");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine();
        int newPromote;
        do {
            Scanner sc1 = new Scanner(System.in);
            try {
                System.out.println("Input new promote");
                newPromote = sc1.nextInt();
                if (newPromote < 0 || newPromote > 100) {
                    System.out.println("Promote can't not be negative numbers or higher than 100!");
                    throw new InputMismatchException();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not valid, please try again!");
            }
        } while (true);
        AtomicBoolean isValid = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        AtomicReference <UUID> storageItemID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                productID.set(value.getProductID());
                isValid.set(true);
            }
        });
        if (! isValid.get()) {
            System.out.println("The product is not exist in your store!");
        } else {
            isValid.set(false);
            storageItemList.forEach((value) -> {
                if (value.getProductID().equals(productID.get())) {
                    storageItemID.set(value.getItemID());
                    isValid.set(true);
                }
            });
            if (! isValid.get()) {
                System.out.println("The product is not exist in your store!");
            } else {
                DataBase.storageItemMap.get(storageItemID.get()).setPromote(newPromote);
                WriteAllData.getWriteAllData().writeData();
                System.out.println("Edit promote of product success!");
                viewStore();
            }
        }
    }

    public List <StorageItem> getStorageItemList() {
        return storageItemList;
    }


}
