import java.util.Scanner;

public class Convert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Convert C to F");
            System.out.println("2. Convert F to C");
            System.out.println("0. exit");
            System.out.println("Input your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Input C degree");
                    System.out.println("F degree: " + convertCtoF(sc.nextDouble()));
                    break;
                case 2:
                    System.out.println("Input F degree");
                    System.out.println("C degree: " + convertFtoC(sc.nextDouble()));
                    break;
                default:
                    System.out.println("Please input the valid choice");
                    break;
            }
        } while (true);
    }

    public static double convertCtoF(double c) {
        double f;
        f = (9.0 / 5) * c + 32;
        return f;
    }

    public static double convertFtoC(double f) {
        double c;
        c = (5.0 / 9) * (f - 32);
        return c;
    }
}
