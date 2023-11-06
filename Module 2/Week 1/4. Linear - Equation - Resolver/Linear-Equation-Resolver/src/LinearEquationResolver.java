import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        Scanner sc = new Scanner(System.in);
        System.out.println("We will solve equation a * x + b = c ");
        System.out.println("Input a: ");
        a = sc.nextDouble();
        System.out.println("Input b: ");
        b = sc.nextDouble();
        System.out.println("Input c: ");
        c = sc.nextDouble();

        if (a == 0) {
            if (b == c) {
                System.out.println("The solition is all x");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = (c - b) / a;
            System.out.printf("Result: %.2f", x);
        }
    }
}
