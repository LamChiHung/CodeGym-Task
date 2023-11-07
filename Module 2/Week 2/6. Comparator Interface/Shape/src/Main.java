import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.5, "indigo", false);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(0.5, "indigo", false);
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        System.out.println("-------------------------");
        Arrays.sort(circles);
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}