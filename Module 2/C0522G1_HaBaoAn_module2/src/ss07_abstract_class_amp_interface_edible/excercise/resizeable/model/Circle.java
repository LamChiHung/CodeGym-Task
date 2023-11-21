package ss07_abstract_class_amp_interface_edible.excercise.resizeable.model;

import ss07_abstract_class_amp_interface_edible.excercise.resizeable.service.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Bán kính hình tròn = "
                + getRadius()+"Diện tích hình tròn "
                + getArea() +" "
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public double resize(double percent) {
        setRadius(getRadius()+getRadius()*percent/100);
        return getArea();
    }


}
