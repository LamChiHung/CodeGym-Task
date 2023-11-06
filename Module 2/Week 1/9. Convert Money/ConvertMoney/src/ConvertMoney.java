import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input USD");
        double USD = sc.nextDouble();
        double VND = USD * 23000;
        System.out.printf("VND: %.0f VND ", VND);
    }
}
