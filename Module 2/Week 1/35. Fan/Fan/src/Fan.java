public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = Fan.SLOW;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public Fan(int speed, boolean status, double radius, String color) {
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getStatus() {
        return this.status;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "speed=" + speed +
                ", status=" + status +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
