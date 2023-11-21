package case_study.service.impl;

import case_study.service.IFacilityService;

import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);


    @Override
    public void add() {
        do {
            try {
                System.out.println("Vui lòng chọn dịch vụ bạn muốn thêm \n" +
                        "1.\tThêm mới Villa \n" +
                        "2.\tThêm mới nhà  \n" +
                        "3.\tThêm mới phòng \n" +
                        "4.\tTrở lại menu chính ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        VillaService villaService = new VillaService();
                        villaService.add();
                        break;
                    case 2:
                        HouseService houseService = new HouseService();
                        houseService.add();
                        break;
                    case 3:
                        RoomService roomService = new RoomService();
                        roomService.add();
                        break;
                    case 4:
                        return;
                    default:
                        throw new Exception("Bạn nhập sai số, vui lòng nhập lại");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    @Override
    public void display() {
        VillaService villaService = new VillaService();
        HouseService houseService = new HouseService();
        RoomService roomService = new RoomService();

        roomService.display();
        villaService.display();
        houseService.display();
    }

    @Override
    public void displayMaintenance() {

    }
}
