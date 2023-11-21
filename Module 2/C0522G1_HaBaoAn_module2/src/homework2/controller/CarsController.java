package homework2.controller;

import homework2.service.IVehicalService;
import homework2.service.impl.CarsService;
import homework2.service.impl.VehicalService;

import java.util.Scanner;

public class CarsController {

    public static void menuCars() {
        IVehicalService iCarsService = new VehicalService();
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
                    iCarsService.add();
                    break;
                case 2:
                    iCarsService.remove();
                    break;
                case 3:
                    iCarsService.display();
                    break;
                case 4:
                    iCarsService.search();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
