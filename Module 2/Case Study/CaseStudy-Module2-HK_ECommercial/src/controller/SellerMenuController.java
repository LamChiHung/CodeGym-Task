package controller;

import service.bill_service.BillService;
import service.coupon_service.CouponService;
import service.storage_item_service.StorageItemService;
import service.wallet_service.SellerWalletService;
import view.SellerMenu;
import view.SignInSignUpMenu;

public class SellerMenuController {
    private static SellerMenuController sellerMenuController;

    private SellerMenuController() {

    }

    public static SellerMenuController getSellerMenuController() {
        if (sellerMenuController == null) {
            sellerMenuController = new SellerMenuController();
            return sellerMenuController;
        } else return sellerMenuController;
    }

    public void sellerMainMenuController(String choice) {
        switch (choice) {
            case "1":
                SellerMenu.sellerStorageMenu();
                break;
            case "2":
                SellerMenu.sellerWalletMenu();
                break;
            case "3":
                SellerMenu.sellerCouponMenu();
                break;
            case "4":
                BillService.getBillService().viewBillforSeller();
                SellerMenu.sellerMainMenu();
                break;
            case "5":
                SignInSignUpMenu.signInsignUpMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                SellerMenu.sellerMainMenu();
                break;
        }
    }

    public void sellerStorageMenuController(String choice) {
        switch (choice) {
            case "1":
                StorageItemService.getStorageItemService().viewStore();
                SellerMenu.sellerStorageMenu();
                break;
            case "2":
                StorageItemService.getStorageItemService().addItem();
                SellerMenu.sellerStorageMenu();
                break;
            case "3":
                StorageItemService.getStorageItemService().deleteItem();
                SellerMenu.sellerStorageMenu();
                break;
            case "4":
                StorageItemService.getStorageItemService().editQuantityOfItem();
                SellerMenu.sellerStorageMenu();
                break;
            case "5":
                StorageItemService.getStorageItemService().editUnitPriceOfProduct();
                SellerMenu.sellerStorageMenu();
                break;
            case "6":
                StorageItemService.getStorageItemService().editPromoteOfProduct();
                SellerMenu.sellerStorageMenu();
                break;
            case "7":
                SellerMenu.sellerMainMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                SellerMenu.sellerStorageMenu();
                break;
        }
    }

    public void sellerWalletMenuController(String choice) {
        switch (choice) {
            case "1":
                System.out.println("-----------");
                System.out.println("Wallet money:");
                System.out.println(SellerWalletService.getSellerWalletService().getWalletMoney());
                SellerMenu.sellerWalletMenu();
                break;
            case "2":
                SellerWalletService.getSellerWalletService().viewTransactionHistory();
                SellerMenu.sellerWalletMenu();
                break;
            case "3":
                SellerMenu.sellerMainMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                SellerMenu.sellerStorageMenu();
                break;
        }
    }

    public void sellerCouponMenuController(String choice) {
        switch (choice) {
            case "1":
                System.out.println("-----------");
                System.out.println("Store Coupon:");
                CouponService.getCouponService().deleteInValidCoupon();
                CouponService.getCouponService().viewCoupon();
                SellerMenu.sellerCouponMenu();
                break;
            case "2":
                System.out.println("-----------");
                System.out.println("Add new coupon menu:");
                CouponService.getCouponService().addCoupon();
                SellerMenu.sellerCouponMenu();
                break;
            case "3":
                System.out.println("--------------");
                System.out.println("Delete coupon menu");
                CouponService.getCouponService().deleteCoupon();
                SellerMenu.sellerCouponMenu();
                break;
            case "4":
                SellerMenu.sellerMainMenu();
            default:
                System.out.println("Please input the valid choice!");
                SellerMenu.sellerCouponMenu();
                break;
        }
    }
}
