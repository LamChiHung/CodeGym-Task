package ss04_class_object_in_java.excercise.quaradtic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào a");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào b");
        double b = scanner.nextDouble();
        System.out.println("Nhập vào c");
        double c = scanner.nextDouble();

        QuaradticEquation quaradticEquation = new QuaradticEquation(a, b, c);
        double delta = quaradticEquation.getDiscriminant();
        double x1 = quaradticEquation.getRoot1();
        double x2 = quaradticEquation.getRoot2();
        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm: " + x1 + " " + x2);
        }
        if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm: " + x1);
        }
        if (delta<0){
            System.out.println("Phương trình vô nghiệm ");
        }
    }
}
