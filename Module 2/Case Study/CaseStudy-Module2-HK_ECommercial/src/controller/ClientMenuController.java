package controller;

import service.bill_service.BillService;
import service.cart_service.CartService;
import service.coupon_service.CouponService;
import service.store_service.StoreService;
import service.wallet_service.ClientWalletService;
import view.ClientMenu;
import view.SignInSignUpMenu;

public class ClientMenuController {
    private static ClientMenuController clientMenuController;

    private ClientMenuController() {

    }

    public static ClientMenuController getClientMenuController() {
        if (clientMenuController == null) {
            clientMenuController = new ClientMenuController();
            return clientMenuController;
        } else return clientMenuController;
    }

    public void clientMainMenuController(String choice) {
        switch (choice) {
            case "1":
                ClientMenu.clientStoreMenu();
                break;
            case "2":
                CartService.getCartService().viewCart();
                ClientMenu.clientCartMenu();
                break;
            case "3":
                ClientWalletService.getClientWalletService().viewWalletMoney();
                ClientMenu.clientWalletMenu();
                break;
            case "4":
                BillService.getBillService().viewBillforClient();
                break;
            case "5":
                SignInSignUpMenu.signInsignUpMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                ClientMenu.clientMainMenu();
                break;
        }
    }

    public void clientStoreMenuController(String choice) {
        switch (choice) {
            case "1":
                StoreService.getStoreService().viewAllItem();
                ClientMenu.clientStoreMenu();
                break;
            case "2":
                StoreService.getStoreService().getInStore();
                ClientMenu.clientStoreMenu();
                break;
            case "3":
                StoreService.getStoreService().findProductByName();
                ClientMenu.clientStoreMenu();
                break;
            case "4":
                StoreService.getStoreService().findProductByType();
                ClientMenu.clientStoreMenu();
                break;
            case "5":
                CartService.getCartService().addCartItem();
                ClientMenu.clientStoreMenu();
            case "6":
                ClientMenu.clientMainMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                ClientMenu.clientStoreMenu();
                break;
        }
    }

    public void clientCartMenuController(String choice) {
        switch (choice) {
            case "1":
                StoreService.getStoreService().viewAllItem();
                ClientMenu.clientStoreMenu();
                break;
            case "2":
                CartService.getCartService().deleteItem();
                ClientMenu.clientCartMenu();
                break;
            case "3":
                CartService.getCartService().editItemQuantity();
                ClientMenu.clientCartMenu();
                break;
            case "4":
                CartService.getCartService().payMent();
                ClientMenu.clientCartMenu();
                break;
            case "5":
                CouponService.getCouponService().deleteInValidCoupon();
                CouponService.getCouponService().viewCoupon();
                CouponService.getCouponService().applyCoupon();
                ClientMenu.clientCartMenu();
                break;
            case "6":
                ClientMenu.clientMainMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                ClientMenu.clientStoreMenu();
                break;
        }
    }

    public void clientWalletMenuController(String choice) {
        switch (choice) {
            case "1":
                ClientWalletService.getClientWalletService().depositMoney();
                ClientMenu.clientWalletMenu();
                break;
            case "2":
                ClientWalletService.getClientWalletService().withdrawMoney();
                ClientMenu.clientWalletMenu();
                break;
            case "3":
                ClientWalletService.getClientWalletService().viewTransactionHistory();
                ClientMenu.clientWalletMenu();
                break;
            case "4":
                ClientMenu.clientMainMenu();
                break;
            default:
                System.out.println("Please input the valid choice!");
                ClientMenu.clientStoreMenu();
                break;
        }
    }
}
