package service.coupon_service;

import database.DataBase;
import entity.Coupon;
import service.cart_service.CartService;
import service.coupon_service.coupon_service.AddCouponService;
import util.WriteAllData;
import view.SellerMenu;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CouponService {
    private static CouponService couponService;
    public Map <String, Coupon> couponMap;

    private CouponService() {
        this.couponMap = new HashMap <>();
        DataBase.couponMap.forEach((key, value) -> {
            if (DataBase.currentSeller == null) {
                DataBase.currentSeller = DataBase.sellerMap.get(CartService.getCartItemList().get(0).getSellerID());
            }
            if (value.getSellerID().equals(DataBase.currentSeller.getSellerID())) {
                couponMap.put(value.getCouponID(), value);
            }
        });
    }

    public static CouponService getCouponService() {
        if (couponService == null) {
            couponService = new CouponService();
            return couponService;
        } else return couponService;
    }

    public static void setCouponService(CouponService couponService) {
        CouponService.couponService = couponService;
    }

    public Map <String, Coupon> getCouponMap() {
        return couponMap;
    }

    public void setCouponMap(Map <String, Coupon> couponMap) {
        this.couponMap = couponMap;
    }

    public void viewCoupon() {
        couponMap.forEach((key, value) -> {
            System.out.println(value.toString());
        });
    }

    public void addCoupon() {
        AddCouponService addCouponService = new AddCouponService(this);
        addCouponService.addCoupon();
    }

    public void deleteCoupon() {
        viewCoupon();
        System.out.println("Input coupon code:");
        Scanner sc = new Scanner(System.in);
        String couponID = sc.nextLine();
        if (! couponMap.containsKey(couponID)) {
            System.out.println("Coupon is not exist");
            SellerMenu.sellerCouponMenu();
        }
        couponMap.remove(couponID);
        DataBase.couponMap.remove(couponID);
        System.out.println("Delete coupon success!");
        WriteAllData.getWriteAllData().writeData();
        viewCoupon();
    }

    public void applyCoupon() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input coupon code:");
        String couponCode = sc.nextLine();
        AtomicBoolean isExist = new AtomicBoolean(false);
        DataBase.couponMap.forEach((key, value) -> {
            if (value.getCouponID().equals(couponCode)) {
                if (value.getMinConditionMoney() < CartService.getCartService().calculatorCartTotalMoney()) {
                    isExist.set(true);
                    CartService.getCartService().setCurrentCoupon(value);
                } else {
                    System.out.println("The min condition money is not enough!");
                }
            }
        });
        if (isExist.get()) {
            System.out.println("Apply coupon successfully!");
            CartService.getCartService().viewCart();
        } else {
            System.out.println("Apply the coupon is not success!");
            CartService.getCartService().viewCart();
        }
    }

    public void deleteInValidCoupon() {
        List <String> deleteCouponID = new ArrayList <>();
        DataBase.couponMap.forEach((key, value) -> {
            if (Duration.between(LocalDateTime.now(), value.getEndTime()).toSeconds() < 0) {
                deleteCouponID.add(key);
            }
        });
        deleteCouponID.forEach((key) -> {
            DataBase.couponMap.remove(key);
        });
        WriteAllData.getWriteAllData().writeData();
    }
}
