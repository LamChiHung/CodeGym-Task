package homework2.service.impl;

import homework2.model.Truck;
import homework2.model.Vehical;
import homework2.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
   private static Scanner scanner = new Scanner(System.in);
   private static List<Truck> truckList = new ArrayList<>();

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
    public static Vehical infoTruck(){
        System.out.println("Nhập tải trọng");
        int weight = Integer.parseInt(scanner.nextLine());
        Vehical vehical = new Truck();
        return vehical;
    }
}
