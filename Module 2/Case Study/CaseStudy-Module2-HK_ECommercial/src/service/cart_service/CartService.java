package service.cart_service;

import database.DataBase;
import entity.Coupon;
import entity.cart.CartItem;
import entity.coupon_imp.CouponMoney;
import entity.storage.StorageItem;
import entity.wallet_imp.ClientWallet;
import entity.wallet_imp.SellerWallet;
import service.bill_service.BillService;
import service.store_service.StoreService;
import service.wallet_service.CreateLogService;
import util.WriteAllData;
import view.ClientMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CartService {

    private static List <CartItem> cartItemList;
    private static CartService cartService;
    private Coupon currentCoupon;

    private CartService() {

    }

    public static CartService getCartService() {
        if (cartService == null) {
            cartService = new CartService();
            cartItemList = new ArrayList <>();
            return cartService;
        } else return cartService;
    }

    public void addCartItem() {
        StoreService storeService = StoreService.getStoreService();
        if (! storeService.getInStore()) {
            ClientMenu.clientStoreMenu();
        }
        if (DataBase.currentSeller == null) {
            DataBase.currentSeller = storeService.getCurrentSeller();
        } else if (DataBase.currentSeller != storeService.getCurrentSeller()) {
            do {
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println("If you choose product from difference store, all the product in your cart will be delete!\n" +
                        "Press '1' if you agree\n" +
                        "Press '2' if you want to decline ");
                Scanner sc = new Scanner(System.in);
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        List <UUID> list = new ArrayList <>();
                        DataBase.currentSeller = storeService.getCurrentSeller();
                        DataBase.cartItemMap.forEach((key, value) -> {
                            if (value.getCartID().equals(DataBase.currentClient.getCartID())) {
                                list.add(key);
                            }
                        });
                        list.forEach((key) -> {
                            DataBase.cartItemMap.remove(key);
                        });
                        break;
                    case "2":
                        ClientMenu.clientStoreMenu();
                        break;
                    default:
                        System.out.println("Input valid choice!");
                }
                if (choice.equals("1")) {
                    break;
                }
            } while (true);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Input product name: ");
        String productName = sc.nextLine();
        AtomicBoolean isExist = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                productID.set(key);
                isExist.set(true);
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientStoreMenu();
        }
        isExist.set(false);
        AtomicReference <UUID> itemID = new AtomicReference <>();
        storeService.getStorageItemList().forEach((value) -> {
            if (value.getProductID().equals(productID.get())) {
                itemID.set(value.getItemID());
                isExist.set(true);
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientStoreMenu();
        }
        StorageItem storageItem = DataBase.storageItemMap.get(itemID.get());
        int quantity;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Input quantity: ");
                quantity = sc1.nextInt();
                if (quantity <= 0 || quantity > storageItem.getQuantity()) {
                    throw new InputMismatchException();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("The input value is not valid!\n" +
                        "The value can't negative, can't equal '0' and can't higher than store item quantity! ");
            }
        } while (true);

        CartItem cartItem = new CartItem(storageItem.getItemID(), DataBase.currentSeller.getSellerID(), DataBase.currentClient.getCartID(), productID.get(), quantity, storageItem.getOriginUnitPrice(), storageItem.getCurrentUnitPrice(), storageItem.getPromote());
        DataBase.cartItemMap.put(cartItem.getItemID(), cartItem);
        WriteAllData.getWriteAllData().writeData();
        System.out.println("Add product to cart success!");
    }

    public int calculatorCartTotalMoney() {
        AtomicInteger totalMoney = new AtomicInteger();
        DataBase.cartItemMap.forEach((key, value) -> {
            if (value.getCartID().equals(DataBase.currentClient.getCartID())) {
                totalMoney.addAndGet(value.getTotalPrice());
            }
        });
        if (currentCoupon == null) {
            return totalMoney.get();
        } else if (currentCoupon instanceof CouponMoney) {
            if (totalMoney.get() - currentCoupon.getPromote() < currentCoupon.getMaxPromoteMoney()) {
                totalMoney.set(totalMoney.get() - currentCoupon.getPromote());
            } else {
                System.out.println("The promote money is higher than max promote money, so you just can minus equal the max promote money");
                totalMoney.set(totalMoney.get() - currentCoupon.getMaxPromoteMoney());
            }
            return totalMoney.get();
        } else {
            if ((totalMoney.get() * (100 - currentCoupon.getPromote()) / 100) < currentCoupon.getMaxPromoteMoney()) {
                totalMoney.set(totalMoney.get() * (100 - currentCoupon.getPromote()) / 100);
            } else {
                System.out.println("The promote money is higher than max promote money, so you just can minus equal the max promote money");
                totalMoney.set(totalMoney.get() - currentCoupon.getMaxPromoteMoney());
            }
            return totalMoney.get();
        }
    }

    public String viewCart() {
        StringBuilder infomation = new StringBuilder();
        cartItemList.clear();
        DataBase.cartItemMap.forEach((key, value) -> {
            if (value.getCartID().equals(DataBase.currentClient.getCartID())) {
                cartItemList.add(value);
            }
        });
        System.out.println("-------------");
        System.out.println("Cart menu: ");
        cartItemList.forEach((value) -> {
            System.out.println(value.toString());
            infomation.append(value.toString());
        });
        System.out.println("Total Money:");
        System.out.println(calculatorCartTotalMoney());
        return infomation.toString();
    }

    public void deleteItem() {
        viewCart();
        System.out.println("---------------");
        System.out.println("Delete Item");
        System.out.println("Input product name:");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine();
        AtomicBoolean isExist = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                isExist.set(true);
                productID.set(key);
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientCartMenu();
        }
        isExist.set(false);
        AtomicReference <UUID> itemID = new AtomicReference <>();
        cartItemList.forEach((value) -> {
            if (value.getProductID().equals(productID.get())) {
                isExist.set(true);
                itemID.set(value.getItemID());
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientCartMenu();
        }
        DataBase.cartItemMap.remove(itemID.get());
        WriteAllData.getWriteAllData().writeData();
        System.out.println("Delete item success!");
        viewCart();
    }

    public void editItemQuantity() {
        viewCart();
        System.out.println("----------------------");
        System.out.println("Edit item quantity");
        System.out.println("Input product name:");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine();
        AtomicBoolean isExist = new AtomicBoolean(false);
        AtomicReference <UUID> productID = new AtomicReference <>();
        DataBase.producttMap.forEach((key, value) -> {
            if (value.getName().equals(productName)) {
                isExist.set(true);
                productID.set(key);
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientCartMenu();
        }
        isExist.set(false);
        AtomicReference <UUID> itemID = new AtomicReference <>();
        cartItemList.forEach((value) -> {
            if (value.getProductID().equals(productID.get())) {
                isExist.set(true);
                itemID.set(value.getItemID());
            }
        });
        if (! isExist.get()) {
            System.out.println("The product is not exist");
            ClientMenu.clientCartMenu();
        }
        int newQuantity;
        do {
            try {
                System.out.println("Input new quantity");
                newQuantity = sc.nextInt();
                if (newQuantity < 0 || newQuantity > DataBase.storageItemMap.get(itemID.get()).getQuantity()) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input value is not valid, please input again!");
            }
        } while (true);
        DataBase.cartItemMap.get(itemID.get()).setQuantity(newQuantity);
        WriteAllData.getWriteAllData().writeData();
        System.out.println("Edit successfully!");
        viewCart();
    }

    public void payMent() {
        if (! cartItemList.isEmpty()) {
            ClientWallet clientWallet = DataBase.clientWalletMap.get(DataBase.currentClient.getClientWalletID());
            if (DataBase.currentSeller == null) {
                DataBase.currentSeller = DataBase.sellerMap.get(cartItemList.get(0).getSellerID());
            }
            SellerWallet sellerWallet = DataBase.sellerWalletMap.get(DataBase.currentSeller.getSellerWalletID());
            if (clientWallet.getMoney() > calculatorCartTotalMoney()) {
                BillService.getBillService().createBill(calculatorCartTotalMoney());
                clientWallet.setMoney(clientWallet.getMoney() - calculatorCartTotalMoney());
                sellerWallet.setMoney(sellerWallet.getMoney() + calculatorCartTotalMoney());
                CreateLogService.getCreateLogService().createClientLogService(- calculatorCartTotalMoney(), clientWallet.getMoney());
                CreateLogService.getCreateLogService().createSellerLogService(calculatorCartTotalMoney(), sellerWallet.getMoney());
                System.out.println("Payment successfully!");
                cartItemList.forEach((value) -> {
                    StorageItem storeItem = DataBase.storageItemMap.get(value.getItemID());
                    storeItem.setQuantity(storeItem.getQuantity() - value.getQuantity());
                    DataBase.cartItemMap.remove(value.getItemID());
                });
                WriteAllData.getWriteAllData().writeData();
            } else {
                System.out.println("The wallet doesn't has enough money, please deposit!");
            }
        } else {
            System.out.println("The cart is empty, please adding some items");
        }
    }

    public static List <CartItem> getCartItemList() {
        return cartItemList;
    }

    public static void setCartItemList(List <CartItem> cartItemList) {
        CartService.cartItemList = cartItemList;
    }

    public static void setCartService(CartService cartService) {
        CartService.cartService = cartService;
    }

    public Coupon getCurrentCoupon() {
        return currentCoupon;
    }

    public void setCurrentCoupon(Coupon currentCoupon) {
        this.currentCoupon = currentCoupon;
    }
}
