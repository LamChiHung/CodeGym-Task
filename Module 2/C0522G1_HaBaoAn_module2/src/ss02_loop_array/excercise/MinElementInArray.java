package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng");
        int index = scanner.nextInt();
        int[] integer = new int[index];
        for (int i = 0; i < integer.length; i++) {
            integer[i] = Math.incrementExact((int) (Math.random() * 100 + 1));
        }
        System.out.println(Arrays.toString(integer));

        int minValue = integer[0];
        for (int i = 0; i < integer.length; i++) {
            if (integer[i] < minValue) {
                minValue = integer[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + minValue);
    }
}
