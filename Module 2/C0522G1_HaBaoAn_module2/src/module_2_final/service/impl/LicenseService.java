package module_2_final.service.impl;

import module_2_final.model.License;
import module_2_final.service.IVehicalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LicenseService implements IVehicalService {
    private static final String PATHGDKPT = "src/module_2_final/data/gdkpt.csv";
    private static final String PATHTRUCK = "src/module_2_final/data/vehical.csv";
    private static final Scanner SCANNER = new Scanner(System.in) ;
    private static List<License> teacherList = new ArrayList<>();

    public static License info() {
        System.out.println("Nhập vào số đăng kí");
        int signID = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Nhập vào tên chủ phương tiện");
        String name = SCANNER.nextLine();

        System.out.println("Nhập vào ngày đăng kí");
        String date = SCANNER.nextLine();

        System.out.println("Thêm mới thành công");
        License license =new License();
        return license;
    }

    @Override
    public void add() {
        License license = info();
        teacherList.add(license);


    }

    @Override
    public void display() {

    }

    @Override
    public void remove() {

    }
}
