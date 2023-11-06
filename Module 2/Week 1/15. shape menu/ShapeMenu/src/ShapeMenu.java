import java.util.Scanner;

public class ShapeMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = - 1;
        do {
            System.out.println("Shape Menu");
            System.out.println("1. Rectangle");
            System.out.println("2. Square triangle");
            System.out.println("3. Isosceles triangle");
            System.out.println("0. exit");
            System.out.println("Input your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 6; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choice again");
                    break;
            }
        } while (true);
    }
}
