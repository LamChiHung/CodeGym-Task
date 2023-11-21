package case_study.service.impl;

import case_study.exception.NegativeCostException;
import case_study.exception.OutOfRangeException;
import case_study.model.Villa;
import case_study.service.IFacilityService;
import case_study.utils.ReadVillaUtils;
import case_study.utils.WriteVillaUtils;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class VillaService implements IFacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATHVILLA = "src/case_study/data/facility_file/villa.csv";

    @Override
    public void add() {
        Map<Villa, Integer> villaIntegerMap = ReadVillaUtils.reaVillaFile(PATHVILLA);
        String serviceID;
        do {
            try {
                System.out.println("Nhập vào mã dịch vụ");
                serviceID = SCANNER.nextLine();
                if (serviceID.matches("^(SVVL-\\d{4})$")) {
                    break;
                }
                System.out.println("Vui lòng nhập đúng định dạng của mã dịch vụ \n" +
                        "Villa là SVVL-xxxx\n" +
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
                if (serviceName.matches("Villa")) {
                    break;
                }
                System.out.println("Vui lòng nhập đúng tên dịch vụ\n" +
                        "Villa");
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
                if (maxPeople < 1 || maxPeople > 20) {
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

        double poolArea;
        do {
            try {
                System.out.println("Nhập vào diện tích hồ bơi(m^2)");
                poolArea = Double.parseDouble(SCANNER.nextLine());
                if (poolArea >= 30) {
                    break;
                }
                System.out.println("Diện tích hồ bơi phải trên 30 m^2");
                throw new OutOfRangeException("Vui lòng nhập lại");
            } catch (OutOfRangeException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

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


        villaIntegerMap.put(new Villa(serviceID, serviceName, area, rentalcost, maxPeople, type, standardRoom, poolArea, floor), 0);

        WriteVillaUtils.writeVillaFile(PATHVILLA, villaIntegerMap);
    }

    @Override
    public void display() {

        Map<Villa, Integer> villaIntegerMap = ReadVillaUtils.reaVillaFile(PATHVILLA);
        Set<Villa> villas = villaIntegerMap.keySet();
        for (Villa villa: villas){
            System.out.println(villa + " Số lần sử dụng: " + villaIntegerMap.get(villa));
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
