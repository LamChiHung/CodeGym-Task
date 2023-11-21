package ss06_inheritance.excercise.circle.model;

public class Circle {
    private double radius = 5;
    private String color = "Yelow";

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Bán kính = " + radius +
                ", Màu sắc = '" + color + '\'' +
                '}';
    }
}
