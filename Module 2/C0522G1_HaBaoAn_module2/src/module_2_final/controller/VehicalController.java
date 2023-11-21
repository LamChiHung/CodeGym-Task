package module_2_final.controller;

import homework2.controller.CarsController;
import homework2.controller.MotorbikeController;
import homework2.controller.TruckController;
import module_2_final.model.License;
import module_2_final.service.impl.LicenseService;

import java.util.Scanner;

public class VehicalController {
    public static void mainController() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Chào mừng bạn đến với Hệ thống quản lý phương tiện giao thông \n" +
                        "Chọn chức năng theo số \n " +
                        " 1.Đăng kí phương tiện \n" +
                        " 2.Xem danh sách phương tiện \n" +
                        " 3.Hủy đăng kí phương tiện \n" +
                        " 4. Thoát chương trình ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        do {
                            try {
                                System.out.println(
                                        "Chọn loại phương tiện bạn muốn đăng kí theo số \n " +
                                                " 1.Đăng kí Ô tô \n" +
                                                " 2.Đăng kí xe tải \n" +
                                                " 3. Quay lại menu chính ");
                                int input = Integer.parseInt(scanner.nextLine());
                                switch (input) {
                                    case 1:

                                        break;
                                    case 2:
                                        LicenseService licenseService = new LicenseService();
                                        licenseService.add();
                                        break;
                                    case 3:

                                        return;

                                }

                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                            }

                        } while (true);
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        System.exit(1);
                    default:
                        System.out.println("Vui lòng chọn đúng mục đã hướng dẫn");
                        throw new NumberFormatException("Vui lòng nhập số");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
