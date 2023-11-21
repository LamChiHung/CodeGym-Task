package homework2.service.impl;

import homework2.model.Cars;
import homework2.model.Vehical;
import homework2.service.ICarsService;
import homework2.service.IVehicalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarsService implements ICarsService, IVehicalService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cars> carsList = new ArrayList<>();

    @Override
    public void add() {

    }

    @Override
    public void display() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void search() {

    }

    public static Vehical inforCars(){
        System.out.println("Nhập vào kiểu xe");
        String vehicalType = scanner.nextLine();
        System.out.println("Nhập vào số chỗ ngồi");
        int seats = Integer.parseInt(scanner.nextLine());
        Vehical vehical = new Cars();
        return vehical;
    }
}
