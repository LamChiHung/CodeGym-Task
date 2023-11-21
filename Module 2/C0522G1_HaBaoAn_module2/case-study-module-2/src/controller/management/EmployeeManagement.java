package controller.management;

import service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuEmployee() {
        EmployeeService employeeService = new EmployeeService();
        do {
            try {
                System.out.println("Chào mừng bạn đến với hệ thống quản lý nhân viên \n" +
                        "1\tHiển thị tất cả nhân viên \n" +
                        "2\tThêm mới nhân viên \n" +
                        "3\tThay đổi thông tin nhân viên \n" +
                        "4\tQuay lại menu");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
//                        employeeService.add();
                        break;
                    case 3:
//                        employeeService.edit();
                        break;
                    case 4:
                        return;
                    default:
                        throw new NumberFormatException("Vui lòng nhập đúng lựa chọn");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Vui lòng hãy nhập sô");
            }
        } while (true);
    }
}
