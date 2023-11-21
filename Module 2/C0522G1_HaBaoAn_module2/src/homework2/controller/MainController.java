package homework2.controller;

import java.util.Scanner;


public class MainController {
    public static void mainController() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chào mừng bạn đến với Hệ thống quản lý phương tiện giao thông \n" +
                    "Chọn chức năng theo số \n " +
                    " 1.Quản lý Xe máy \n" +
                    " 2.Quản lý Ô tô \n" +
                    " 3.Quản lý xe tải \n" +
                    " 4. Thoát chương trình ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    MotorbikeController motorbikeController = new MotorbikeController();
                   motorbikeController.menuMotobike();
                    break;
                case 2:
                    CarsController carsController = new CarsController();
                    carsController.menuCars();
                    break;
                case 3:
                    TruckController truckController = new TruckController();
                    truckController.menuTruck();
                    break;
                case 4:
                    System.exit(1);
            }
        } while (true);
    }
}
