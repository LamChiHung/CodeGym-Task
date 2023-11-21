package ss15_exception.excercise.view;


import ss15_exception.excercise.exception.IllegalTriangleException;
import ss15_exception.excercise.model.Triangle;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int a;
        int b;
        int c;

        while (true) {
            try {
                System.out.println("Nhập canh thứ nhất");
                a = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh thứ hai");
                b = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh thứ ba");
                c = Integer.parseInt(scanner.nextLine());
                Triangle triangle = new Triangle(a, b, c);
                System.out.println(triangle);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập đúng cạnh");
            }

        }
    }
}

