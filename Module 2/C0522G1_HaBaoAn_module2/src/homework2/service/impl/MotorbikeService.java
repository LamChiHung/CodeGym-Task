package homework2.service.impl;

import homework2.model.Motorbike;
import homework2.model.Vehical;
import homework2.service.IMotorbikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorbikeService implements IMotorbikeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Motorbike> motorbikeList = new ArrayList<>();
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

    public static Vehical infoMotorbike(){
        System.out.println("Nhập vào công suất của xe");
        int wattage = Integer.parseInt(scanner.nextLine());
        Vehical vehical = new Motorbike();
        return vehical;
    }


}
