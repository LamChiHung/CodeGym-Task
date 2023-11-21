package case_study.controller;

import java.util.Scanner;

public class PromotionManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static void menuPromotion() {
        do {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý thành viên \n" +
                    "1.\tHiển thị danh sách khách hàng sử dụng dịch vụ \n" +
                    "2.\tHiển thị danh sách khách hàng nhận được voucher \n" +
                    "3.\tTrở lại menu chính");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                case 2:
                case 3:
                    return;
            }
        } while (true);
    }
}
