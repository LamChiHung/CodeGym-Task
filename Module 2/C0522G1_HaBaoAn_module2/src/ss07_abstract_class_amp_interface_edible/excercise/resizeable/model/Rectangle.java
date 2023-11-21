package ss07_abstract_class_amp_interface_edible.excercise.resizeable.model;

import ss07_abstract_class_amp_interface_edible.excercise.resizeable.service.Resizeable;

import java.util.Scanner;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }



    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    public double getPercent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập phần trăm muốn tăng lên");
        double percent = sc.nextDouble();
        return  percent / 100;
    }

    public double getNewArea(){
        return getArea() * getPercent();
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }


    @Override
    public double resize(double percent) {
        setLength(getLength()+getLength()*percent);
        setWidth(getWidth()+getWidth()*percent);
        return getArea();
    }
}