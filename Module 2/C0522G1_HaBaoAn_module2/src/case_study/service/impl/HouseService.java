package case_study.service.impl;

import case_study.exception.NegativeCostException;
import case_study.exception.OutOfRangeException;
import case_study.model.House;
import case_study.service.IFacilityService;
import case_study.utils.ReadHouseUtils;
import case_study.utils.WriteHouseUtils;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class HouseService implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATHHOUSE = "src/case_study/data/facility_file/house.csv";

    @Override
    public void add() {
        Map<House, Integer> houseIntegerMap = ReadHouseUtils.reaHouseFile(PATHHOUSE);
        String serviceID;
        do {
            try {
                System.out.println("Nhập vào mã dịch vụ");
                serviceID = SCANNER.nextLine();
                if (serviceID.matches("^(SVHO-\\d{4})$")) {
                    break;
                }
                System.out.println("Vui lòng nhập đúng định dạng của mã dịch vụ \n" +
                        "House là SVHO-xxxx\n" +
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
                        "House");
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

        String standardRoom = standarRoom();

        int floor;
        do {
            try {
                System.out.println("Nhập vào số tầng");
                floor = Integer.parseInt(SCANNER.nextLine());
                if (floor < 0) {
                    throw new NegativeCostException("Số tầng phải là số lớn hơn 0, vui lòng nhập lại");
                }
                break;
            } catch (NegativeCostException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);

        houseIntegerMap.put(new House(serviceID, serviceName, area, rentalcost, maxPeople, type, standardRoom, floor), 0);

        WriteHouseUtils.writeHouseFile(PATHHOUSE, houseIntegerMap);
    }

    @Override
    public void display() {
        Map<House, Integer> houseIntegerMap = ReadHouseUtils.reaHouseFile(PATHHOUSE);
        Set<House> houses = houseIntegerMap.keySet();
        for (House house : houses) {
            System.out.println(house + " Số lần sử dụng: " + houseIntegerMap.get(house));
        }


    }


    private String standarRoom() {

        System.out.println("Nhập vào lựa chọn tiêu chuẩn phòng \n" +
                "1. Nội thất cổ điển \n" +
                "2. Nội thất hiện đại \n" +
                "3. Nội thất đồng quê \n" +
                "4. Nội thất Bắc Âu \n" +
                "5. Nội thất Vintage");
        do {
            try {
                int choose = Integer.parseInt(SCANNER.nextLine());
                switch (choose) {
                    case 1:
                        return "Nội thất cổ điển";
                    case 2:
                        return "Nội thất hiện đại";
                    case 3:
                        return "Nội thất đồng quê";
                    case 4:
                        return "Nội thất Bắc Âu ";
                    case 5:
                        return "Nội thất Vintage";
                    default:
                        throw new Exception("Bạn nhập sai lựa chọn vui lòng nhập lại");
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    @Override
    public void displayMaintenance() {

    }
}

