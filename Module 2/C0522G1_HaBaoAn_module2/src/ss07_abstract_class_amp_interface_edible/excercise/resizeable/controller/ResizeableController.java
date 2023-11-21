package ss07_abstract_class_amp_interface_edible.excercise.resizeable.controller;

import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Circle;
import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Rectangle;
import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Shape;
import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Square;

import java.util.Scanner;

public class ResizeableController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tỉ lệ bạn muốn tăng từ 1-100");
        double input = sc.nextDouble();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(5, 10);
        shapes[1] = new Square(10);
        shapes[2] = new Circle(6);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Circle) {
                Shape shapex = (Circle) shape;
                System.out.println("Diện tích hình tròn sau khi thay đổi " + shapex.resize(input));
            }
            if (shape instanceof Square) {
                Shape shape1 = (Square) shape;
                System.out.println("Diện tích hình vuông sau khi thay đổi " + shape1.resize(input));
            }
            if (shape instanceof Rectangle) {
                Shape shape1 = (Rectangle) shape;
                System.out.println("Diện tích hình chữ nhật sau khi thay đổi " + shape1.resize(input));
            }


        }
    }
}
