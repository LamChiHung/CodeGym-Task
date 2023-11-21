package ss04_class_object_in_java.practice;

import java.util.Scanner;

public class Rectangle {
    double width, height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {

        return this.width * this.height;
    }

    public double getPerimeter() {

        return (this.width + this.height) * 2;
    }

    public String display() {

        return "Hình chữ nhật {" + "Chiều rộng = " + width + " Chiều cao = " + height + "}";
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào chiều rộng");
            double width = scanner.nextDouble();
            System.out.println("Nhập vào chiều cao");
            double height = scanner.nextDouble();

            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("Hình chứ nhật của bạn \n" + rectangle.display());
            System.out.println("Chu vi hình chữ nhật: \n" + rectangle.getPerimeter());
            System.out.println("Diện tích hình chữ nhật \n" + rectangle.getArea());
        }

    }


}
