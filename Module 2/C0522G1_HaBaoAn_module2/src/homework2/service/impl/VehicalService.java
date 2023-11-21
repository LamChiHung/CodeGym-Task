package homework2.service.impl;

import homework2.model.Vehical;
import homework2.service.IVehicalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicalService implements IVehicalService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Vehical> vehicalList = new ArrayList<>();

    @Override
    public void add() {
        Vehical vehical = infoVehical();
        vehicalList.add(vehical);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        for (Vehical vehical:vehicalList){
            System.out.println(vehical);
        }

    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập biển số xe cần xóa");
        int licenseRemove = Integer.parseInt(scanner.nextLine());
        boolean isFlag = false;
        for (Vehical vehical: vehicalList){
            if (vehical.getLicensePlate() == licenseRemove){
                System.out.println("Bạn có chắc chắn xóa phương tiện không \n" +
                        " 1. Có \n" +
                        " 2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());
                if (chooseYesNo ==1){
                    vehicalList.remove(vehical);
                    System.out.println("Xóa thành công!");
                }
                isFlag = true;
                break;
            }
        }
        if (!isFlag){
            System.out.println("Không tìm thấy");
        }
    }

    @Override
    public void search() {
        System.out.println("Mời bạn nhập biển số xe cần tim!");
        int licenseSearch = Integer.parseInt(scanner.nextLine());
        for (Vehical vehical:vehicalList){
            if (vehical.getLicensePlate()==licenseSearch){
                System.out.println(vehical);
                break;
            }
        }

    }

    public static Vehical infoVehical() {
        System.out.println("Nhập biển kiểm soát");
        int licensePlate = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập năm sản xuất");
        int yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên chủ sở hữu");
        String owner = scanner.nextLine();
        Vehical vehical = new Vehical(licensePlate,manufacturer,yearOfManufacture,owner);
        return vehical;

    }
}
