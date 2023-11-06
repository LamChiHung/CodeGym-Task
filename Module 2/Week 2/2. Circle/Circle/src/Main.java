public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5, "greed");

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5);
        System.out.println(cylinder);
        cylinder = new Cylinder(6, 6, "red");
        System.out.println(cylinder);
    }
}