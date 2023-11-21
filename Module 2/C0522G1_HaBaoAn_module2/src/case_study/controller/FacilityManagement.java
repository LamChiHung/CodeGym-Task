package case_study.controller;

import case_study.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayFacility() {
        FacilityService facilityService = new FacilityService();
        do {
            System.out.println("Chào mừng đến với hệ thống Quản lý Cơ sở vật chất \n" +
                    "1.\tHiển thị danh sách các cơ sở \n" +
                    "2.\tThêm cơ sở mới \n" +
                    "3.\tHiển thị danh sách cơ sở cần bảo trì \n" +
                    "4.\tTrở lại menu chính ");
            try {

                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        facilityService.display();
                        break;
                    case 2:
                        facilityService.add();
                        break;
                    case 3:
                        facilityService.displayMaintenance();
                        break;
                    case 4:
                        return;
                    default:
                        throw new Exception("Vui lòng nhập đúng lựa chọn");
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
