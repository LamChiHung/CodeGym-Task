package case_study.controller;

import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static void displayCustomer() {
        CustomerService customer = new CustomerService();
        do {
            System.out.println("Chào mừng đến với hệ thống quản lý khách hàng \n" +
                    "1.\tHiển thị danh sách khách hàng \n" +
                    "2.\tThêm khách hàng mới \n" +
                    "3.\tChỉnh sửa thông tin khách hàng \n" +
                    "4.\tTrở lại menu chính ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customer.display();
                    break;
                case 2:
                    customer.add();
                    break;
                case 3:
                    customer.edit();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }
}
