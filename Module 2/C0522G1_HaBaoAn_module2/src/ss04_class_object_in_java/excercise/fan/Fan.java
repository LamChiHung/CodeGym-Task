package ss04_class_object_in_java.excercise.fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    boolean status = false;
    int speed = SLOW;
    String color = "Màu xanh";
    double radius = 5;

    Fan() {

    }

    private Fan(boolean status, int speed, String color, double radius) {
        this.status = status;
        this.speed = speed;
        this.color = color;
        this.radius = radius;
    }

    private int getSLOW() {
        return this.SLOW;
    }

    private int getMEDIUM() {
        return this.MEDIUM;
    }

    private int getFAST() {
        return this.FAST;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private boolean isStatus() {
        return this.status;
    }

    private int getSpeed() {
        return this.speed;
    }

    private boolean turnOn() {
        return this.status = true;
    }

    private boolean turnOff() {
        return this.status;
    }

    private double radius() {
        return this.radius;
    }

    private String color() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Fan{" +
                " speed = " + speed +
                ", color = '" + color + '\'' +
                ", radius = " + radius +
                '}';
    }
}
