package case_study.controller;

import java.util.Scanner;

public class FuramaController {
    public static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        do {
            try {


                System.out.println("===Chào mừng bạn đến với Furama Resort=== \n" +
                        "1.\tQuản lý nhân viên \n" +
                        "2.\tQuản lý khách hàng \n" +
                        "3.\tQuản lý cơ sở vật chất \n" +
                        "4.\tQuản lý dịch vụ đặt chỗ \n" +
                        "5.\tQuản lý Hạng thành viên \n" +
                        "6.\tThoát chương trình ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        EmployeeManagement.menuEmployee();
                        break;
                    case 2:
                        CustomerManagement.displayCustomer();
                        break;
                    case 3:
                        FacilityManagement.displayFacility();
                        break;
                    case 4:
                        BookingManagerment.displayBooking();
                        break;
                    case 5:
                        PromotionManagement.menuPromotion();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập đúng lựa chọn");
                        throw new Exception("Vui lòng nhập đúng số trong Menu lựa chọn");
                }
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
