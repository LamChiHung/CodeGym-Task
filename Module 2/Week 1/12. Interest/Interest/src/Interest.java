import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Money");
        double money = sc.nextDouble();
        System.out.println("ratio (%/year)");
        double ratio = sc.nextDouble();
        System.out.println("month");
        int month = sc.nextInt();
        double interest = 0;
        for (int i = 1; i <= month; i++) {
            interest += money * (ratio / 100 / 12) * month;
        }
        System.out.println("total interest: " + interest);
    }
}
