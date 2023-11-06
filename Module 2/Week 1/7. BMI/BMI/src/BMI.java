import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input height");
        double height = sc.nextDouble();
        System.out.println("Input weight");
        double weight = sc.nextDouble();
        double BMI = weight / Math.pow(height, 2);
        if (BMI < 18.5) {
            System.out.printf("Your weight: %-20.2f%s", weight, "Underweight");
        } else if (BMI < 25) {
            System.out.printf("Your weight: %-20.2f%s", weight, "Normal");
        } else if (BMI < 30) {
            System.out.printf("Your weight: %-20.2f%s", weight, "Overweight");
        } else {
            System.out.printf("Your weight: %-20.2f%s", weight, "Obese");
        }
    }
}
