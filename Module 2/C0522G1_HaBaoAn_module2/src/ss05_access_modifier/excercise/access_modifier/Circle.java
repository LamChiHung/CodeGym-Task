package ss05_access_modifier.excercise.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    protected Circle() {
    }

    protected Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
