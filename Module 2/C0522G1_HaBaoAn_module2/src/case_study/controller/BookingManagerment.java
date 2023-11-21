package case_study.controller;

import java.util.Scanner;

public class BookingManagerment {
    public static Scanner scanner = new Scanner(System.in);

    public static void displayBooking() {
        do {
            System.out.println("Chào mừng bạn đến với hệ thống Quản lý đặt chỗ \n" +
                    "1.\tĐặt chỗ mới \n" +
                    "2.\tHiển thị danh sách đặt chỗ \n" +
                    "3.\tTạo hợp đồng mới \n" +
                    "4.\tHiển thị danh sách hợp đồng  \n" +
                    "5.\tChính sửa hợp đồng \n" +
                    "6.\tTrở lại menu chính ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return;
            }
        } while (true);
    }
}
