package homework2.controller;

import java.util.Scanner;

public class TruckController {
    public static void menuTruck() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Thêm mới phương tiện \n" +
                    " 2. Xóa phương tiện \n" +
                    " 3. Hiển thị phương tiện \n" +
                    " 4. Tìm kiếm phương tiện \n" +
                    " 5. Quay về Menu chính ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return;
            }
        } while (true);
    }
}
