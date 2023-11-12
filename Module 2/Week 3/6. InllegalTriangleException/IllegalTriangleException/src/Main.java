import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean checkTriangle(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);

        if (a <= 0 | b <= 0 | c <= 0) {
            return false;
        } else if (arr[2] >= arr[0] + arr[1]) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input first side: ");
            int a = sc.nextInt();
            System.out.println("Input second side: ");
            int b = sc.nextInt();
            System.out.println("Input third side: ");
            int c = sc.nextInt();
            if (checkTriangle(a, b, c)) {
                System.out.println("This is triangle");
            } else {
                throw new IllegalTriangleException();
            }

        } catch (IllegalTriangleException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }
}