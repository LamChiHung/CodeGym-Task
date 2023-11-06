import java.util.Scanner;

public class OneHundredPrimeNumbers {
        public static void main(String[] args) {
            int p = 2;
            while (p <= 100) {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(p); i++) {
                    if (p % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(p);
                }
                p++;
                ;
            }
        }
    }