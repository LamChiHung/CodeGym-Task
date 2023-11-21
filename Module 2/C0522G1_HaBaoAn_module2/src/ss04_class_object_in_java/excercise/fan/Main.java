package ss04_class_object_in_java.excercise.fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        if (fan.status) {
            System.out.println(fan);
        } else {
            System.out.println("Quạt đang tắt");
        }
        Fan fan1 = new Fan();
        fan1.setRadius(10);
        fan1.setSpeed(3);
        fan1.setStatus(true);
        fan1.setColor("Màu tím");
        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan1.setRadius(5);
        fan1.setSpeed(1);
        fan1.setStatus(true);
        fan1.setColor("Màu đỏ");
        System.out.println(fan2);
    }
}

