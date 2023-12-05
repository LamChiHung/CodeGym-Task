package service.coupon_service.coupon_service;

import database.DataBase;
import entity.Coupon;
import entity.coupon_imp.CouponMoney;
import entity.coupon_imp.CouponPercent;
import project_enum.CouponType;
import service.coupon_service.CouponService;
import util.WriteAllData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCouponService {
    private final CouponService couponService;

    public AddCouponService(CouponService couponService) {
        this.couponService = couponService;
    }

    public void addCoupon() {
        Scanner sc = new Scanner(System.in);
        couponService.viewCoupon();
        System.out.println("----------------");
        System.out.println("Add new coupon");
        System.out.println("Choose coupon type:");
        System.out.println("[1] Percent coupon");
        System.out.println("[2] Money coupon");
        System.out.println("Choice: ");
        String choice;
        do {
            Scanner sc1 = new Scanner(System.in);
            choice = sc1.nextLine();
            if (choice.equals("1") || choice.equals("2")) {
                break;
            } else {
                System.out.println("Please input valid choice");
            }
        } while (true);
        CouponType couponType;
        if (choice.equals("1")) {
            couponType = CouponType.PERCENT;
        } else {
            couponType = CouponType.MONEY;
        }
        System.out.println("Create coupon code");
        String couponID;
        do {
            couponID = sc.nextLine();
            if (! DataBase.couponMap.containsKey(couponID)) {
                break;
            } else {
                System.out.println("This coupon code is already exist, please creat again!");
            }
        } while (true);

        System.out.println("Input promote value");
        int promote;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                promote = sc1.nextInt();
                sc1.nextLine();
                if (choice.equals("1")) {
                    if (promote < 0 || promote > 100) {
                        throw new InputMismatchException();
                    }
                } else {
                    if (promote < 0) {
                        throw new InputMismatchException();
                    }
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input valid value");
            }
        } while (true);
        int minConditionMoney;
        do {
            try {
                System.out.println("Input min condition money: ");
                Scanner sc1 = new Scanner(System.in);
                minConditionMoney = sc1.nextInt();
                if (minConditionMoney < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input valid value");
            }
        } while (true);
        int maxPromoteMoney;
        do {
            try {
                System.out.println("Input max promote money:");
                Scanner sc1 = new Scanner(System.in);
                maxPromoteMoney = sc1.nextInt();
                if (maxPromoteMoney < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input valid value");
            }
        } while (true);
        long dayDuration;
        do {
            try {
                System.out.println("Input duration day of coupon: ");
                Scanner sc1 = new Scanner(System.in);
                dayDuration = sc1.nextInt();
                if (dayDuration < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input valid value");
            }
        } while (true);
        Coupon coupon;
        if (choice.equals("1")) {
            coupon = new CouponPercent(couponID, DataBase.currentSeller.getSellerID(), promote, minConditionMoney, maxPromoteMoney, dayDuration);
        } else {
            coupon = new CouponMoney(couponID, DataBase.currentSeller.getSellerID(), promote, minConditionMoney, maxPromoteMoney, dayDuration);
        }
        DataBase.couponMap.put(coupon.getCouponID(), coupon);
        couponService.getCouponMap().put(coupon.getCouponID(), coupon);
        WriteAllData.getWriteAllData().writeData();
        couponService.viewCoupon();
    }
}