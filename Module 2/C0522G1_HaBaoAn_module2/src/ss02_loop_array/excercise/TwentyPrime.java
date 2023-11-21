package ss02_loop_array.excercise;

import java.util.Scanner;

public class TwentyPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    index++;
                }
            }
            if (index == 2) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
}


