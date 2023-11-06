public class Main {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4.4, 5.5);
        System.out.printf("%.2f \n", rec1.getArea());
        System.out.printf("%.2f \n", rec1.getPerimeter());
        rec1.display();
    }
}