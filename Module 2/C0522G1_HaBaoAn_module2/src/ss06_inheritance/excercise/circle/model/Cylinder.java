package ss06_inheritance.excercise.circle.model;

import ss06_inheritance.excercise.circle.model.Circle;

public class Cylinder extends Circle {
    private double height = 6;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder() {
    }

    public double getVolume() {
        return this.height * getArea();
    }

    @Override
    public String toString() {
        return "Cylinder {" +
                "Chiều cao = " + height + " " +
                "Thể tích =  " + getVolume() +
                '}';
    }
}
