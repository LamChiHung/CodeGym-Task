package service.store_service;

import database.DataBase;
import entity.product.Product;
import entity.storage.StorageItem;
import entity.user_imp.Seller;
import service.comparator.StorageItemComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class StoreService {
    private static StoreService storeService;
    private Seller currentSeller;
    private List <StorageItem> storageItemList;

    private StoreService() {
        storageItemList = new ArrayList <>();
        storageItemList.addAll(DataBase.storageItemMap.values());
    }

    public static StoreService getStoreService() {
        if (storeService == null) {
            storeService = new StoreService();
            return storeService;
        } else return storeService;

    }

    public void viewAllItem() {
        DataBase.storageItemMap.forEach((key, value) -> {
            System.out.println(DataBase.producttMap.get(value.getProductID()).toString()
                    + ", store: " + DataBase.sellerMap.get(DataBase.storageMap.get(value.getStorageID()).getSellerID()).getSellerName()
                    + ", " + value);
        });
    }

    public void viewProductList() {
        storageItemList.forEach((value) -> {
            System.out.println(DataBase.producttMap.get(value.getProductID()).toString()
                    + ", store: " + DataBase.sellerMap.get(DataBase.storageMap.get(value.getStorageID()).getSellerID()).getSellerName()
                    + ", " + value);
        });
    }

    public boolean getInStore() {
        storageItemList.clear();
        Scanner sc = new Scanner(System.in);
        System.out.println("===================");
        System.out.println("Get in store menu");
        System.out.println("Input store name:");
        String sellerName = sc.nextLine();
        AtomicBoolean isValid = new AtomicBoolean(false);
        DataBase.sellerMap.forEach((key, value) -> {
            if (value.getSellerName().equals(sellerName)) {
                currentSeller = value;
                isValid.set(true);
            }
        });
        if (! isValid.get()) {
            System.out.println("The store is not exist, pleas try again!");
            return false;
        } else {
            DataBase.storageItemMap.forEach((key, value) -> {
                if (value.getStorageID().equals(currentSeller.getStorageID())) {
                    storageItemList.add(value);
                }
            });
            viewProductList();
        }
        return true;
    }

    public void findProductByName() {
        storageItemList.clear();
        Scanner sc = new Scanner(System.in);
        System.out.println("====================");
        System.out.println("Find product menu");
        System.out.println("Input product name:");
        String productName = sc.nextLine();
        AtomicBoolean isValid = new AtomicBoolean();
        AtomicReference <UUID> productID = new AtomicReference <>();
        Map <UUID, Product> productContainsNameMap = new HashMap <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                isValid.set(true);
                productID.set(key);
            } else if (value.getName().contains(productName)) {
                productContainsNameMap.put(key, value);
            }
        });
        if (! isValid.get()) {
            System.out.println("The product is not exist");
            if (! productContainsNameMap.isEmpty()) {
                System.out.println("Here are related searches");
                DataBase.storageItemMap.forEach((key, value) -> {
                    if (productContainsNameMap.containsKey(value.getProductID())) {
                        storageItemList.add(value);
                    }
                });
                viewProductList();
            }
        } else {
            DataBase.storageItemMap.forEach((key, value) -> {
                if (value.getProductID().equals(productID.get())) {
                    storageItemList.add(value);
                }
            });
            viewProductList();
        }
        if (! storageItemList.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("If you want to sort product by price: press 1\n" +
                    "if not: press any key to continue!");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                StorageItemComparator storageItemComparator = new StorageItemComparator();
                storageItemList.sort(storageItemComparator);
                viewProductList();
            }
        }
        storageItemList.clear();
        storageItemList.addAll(DataBase.storageItemMap.values());
    }

    public void findProductByType() {
        storageItemList.clear();
        Scanner sc = new Scanner(System.in);
        System.out.println("====================");
        System.out.println("Find product menu");
        System.out.println("Input type of product:");
        String productType = sc.nextLine();
        AtomicBoolean isValid = new AtomicBoolean();
        List <UUID> productIDList = new ArrayList <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getType().equals(productType)) {
                isValid.set(true);
                productIDList.add(key);
            }
        });
        if (! isValid.get()) {
            System.out.println("The type is not exist");
        } else {
            productIDList.forEach((value) -> {
                DataBase.storageItemMap.forEach((key, item) -> {
                    if (item.getProductID().equals(value)) {
                        storageItemList.add(item);
                    }
                });
            });
            viewProductList();
        }
        if (! storageItemList.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("If you want to sort product by price: press 1\n" +
                    "if not: press any key to continue!");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                StorageItemComparator storageItemComparator = new StorageItemComparator();
                storageItemList.sort(storageItemComparator);
                viewProductList();
            }
        }
        storageItemList.clear();
        storageItemList.addAll(DataBase.storageItemMap.values());
    }

    public List <StorageItem> getStorageItemList() {
        return storageItemList;
    }

    public static void setStoreService(StoreService storeService) {
        StoreService.storeService = storeService;
    }

    public Seller getCurrentSeller() {
        return currentSeller;
    }

    public void setCurrentSeller(Seller currentSeller) {
        this.currentSeller = currentSeller;
    }

    public void setStorageItemList(List <StorageItem> storageItemList) {
        this.storageItemList = storageItemList;
    }

}
