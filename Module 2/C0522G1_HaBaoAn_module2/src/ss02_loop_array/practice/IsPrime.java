package ss02_loop_array.practice;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
//        int number = scanner.nextInt();
//        if (number < 2) {
//            System.out.println(number + " is not a prime");
//        } else {
//            int i = 2;
//            boolean check = true;
//            while (i <= Math.sqrt(number)) {
//                if (number % i == 0) {
//                    check = false;
//                    break;
//                }
//                i++;
//            }
//            if (check)
//                System.out.println(number + " is a prime");
//            else
//                System.out.println(number + " is not a prime");
//        }
        IsPrime number = new IsPrime();
    }

     static boolean isPrime(int a) {

        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

}

