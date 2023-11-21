package ss05_access_modifier.excercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Bán kính hình tròn là : " + circle.getRadius());
        System.out.println("Diên tích hình tròn là: " + circle.getArea());

        Circle circle1 = new Circle(5.0);
        System.out.println(circle1);
        System.out.println("Diên tích hình tròn là: " + circle1.getArea());

    }
}
