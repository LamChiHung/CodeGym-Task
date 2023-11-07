public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("red", false, 3, 4, 5);
        System.out.println(triangle);
        Circle circle = new Circle(4, "red", false);
        System.out.println(circle.getRadius());
        circle.resize(50);
        System.out.println(circle.getRadius());
    }
}