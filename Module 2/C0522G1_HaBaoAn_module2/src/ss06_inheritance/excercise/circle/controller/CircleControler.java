package ss06_inheritance.excercise.circle.controller;

import ss06_inheritance.excercise.circle.model.Circle;

public class CircleControler {
    public static void main(String[] args) {
        Circle circle = new Circle();

        circle.setRadius(10);
        circle.setColor("Blue");
        System.out.println(circle);
        System.out.println("Diện tích hình tròn là: " + circle.getArea());
    }
}
