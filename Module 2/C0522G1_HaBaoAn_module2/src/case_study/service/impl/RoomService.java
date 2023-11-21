package case_study.service.impl;

import case_study.exception.NegativeCostException;
import case_study.exception.OutOfRangeException;
import case_study.model.Room;
import case_study.service.IFacilityService;
import case_study.utils.ReadRoomUtils;
import case_study.utils.WriteRoomUtils;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class RoomService implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATHROOM = "src/case_study/data/facility_file/room.csv";

    @Override
    public void add() {
        Map<Room, Integer> roomMap = ReadRoomUtils.reaRoomFile(PATHROOM);
        String serviceID;
        do {
            try {
                System.out.println("Nhập vào mã dịch vụ");
                serviceID = SCANNER.nextLine();
                if (serviceID.matches("^(SVRO-\\d{4})$")) {
                    break;
                }
                System.out.println("Vui lòng nhập đúng định dạng của mã dịch vụ \n" +
                        "Room là SVRO-xxxx\n" +
                        "với x là các số tự nhiên");
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

        String serviceName;
        do {
            try {
                System.out.println("Nhập vào tên dịch vụ");
                serviceName = SCANNER.nextLine();
                if (serviceName.matches("House")) {
                    break;
                }
                System.out.println("Vui lòng nhập đúng tên dịch vụ\n" +
                        "Room");
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

        double area;
        do {
            try {
                System.out.println("Nhập vào diện tích sử dụng(m^2)");
                area = Double.parseDouble(SCANNER.nextLine());
                if (area >= 30) {
                    break;
                }
                System.out.println("Diện tích sử dụng phải trên 30 m^2");
                throw new OutOfRangeException("Vui lòng nhập lại");
            } catch (OutOfRangeException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        double rentalcost;
        do {
            try {
                System.out.println("Nhập vào giá thuê (USD)");
                rentalcost = Double.parseDouble(SCANNER.nextLine());
                if (rentalcost < 0) {
                    throw new NegativeCostException("Giá thuê phải là số dương");
                }
                break;
            } catch (NumberFormatException | NegativeCostException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        int maxPeople;
        do {
            try {
                System.out.println("Nhập vào số người tối đa");
                maxPeople = Integer.parseInt(SCANNER.nextLine());
                if (maxPeople < 1 | maxPeople > 20) {
                    throw new OutOfRangeException("Số lượng người vượt quá quy định\n" +
                            "tối thiểu 1 người và tối đa 20 người");
                }
                break;
            } catch (OutOfRangeException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String type;
        do {
            try {
                System.out.println("Nhập vào kiểu thuê");
                type = SCANNER.nextLine();
                if (type.matches("^(Ngày|Tháng|Năm)$")) {
                    break;
                }
                System.out.println("Vui lòng nhập 1 trong 3 kiểu thuê\n" +
                        "Ngày\n" +
                        "Tháng\n" +
                        "Năm");
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Nhập vào dịch vụ miễn phí đi kèm");
        String freeService = SCANNER.nextLine();

        roomMap.put(new Room(serviceID, serviceName, area, rentalcost, maxPeople, type, freeService), 0);
        WriteRoomUtils.writeRoomFile(PATHROOM, roomMap);


    }

    @Override
    public void display() {
        Map<Room, Integer> roomFile = ReadRoomUtils.reaRoomFile(PATHROOM);
        Set<Room> roomSet = roomFile.keySet();
        for (Room room : roomSet) {
            System.out.println(room + "Số lần sử dụng: " + roomFile.get(room));
        }
    }

    @Override
    public void displayMaintenance() {

    }
}
