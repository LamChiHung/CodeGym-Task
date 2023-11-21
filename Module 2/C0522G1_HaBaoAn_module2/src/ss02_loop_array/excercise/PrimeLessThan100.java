package ss02_loop_array.excercise;

import java.util.Scanner;

public class PrimeLessThan100 {
    public static void main(String[] args) {
        System.out.print("Các số nguyên tố nhỏ hơn 100  \n");
        int n = 2;
        while (true) {
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    index++;
                }
            }
            if (index == 2) {
                System.out.print(n + " ");
            }
            n++;
            if (n >= 100) {
                break;
            }
        }
    }
}
