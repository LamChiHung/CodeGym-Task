import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Input number: ");
        int number = sc.nextInt();
        int p = 2;
        while (count < number) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(p);
                count++;
            }
            p++;
        }
    }
}



