import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input fist number: ");
        int first = sc.nextInt();
        System.out.println("Input second number: ");
        int second = sc.nextInt();
        int a = Math.max(first, second);
        int b = Math.min(first, second);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println(a);
    }
}
