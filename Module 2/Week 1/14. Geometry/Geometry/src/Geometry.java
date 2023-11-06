import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = - 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("triangle\n" +
                            "--------------------------------");
                    break;
                case 2:
                    System.out.println("square \n" +
                            "--------------------------------");
                    break;
                case 3:
                    System.out.println("rectangle \n" +
                            "--------------------------------");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choice again \n" +
                            "--------------------------------");
            }
        } while (true);
    }
}
