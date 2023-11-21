package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class LinkedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử mảng thứ nhất");
        int elementArrayFirst = scanner.nextInt();
        System.out.println("Nhập vào số phần tử mảng thứ hai");
        int elementArraySecond = scanner.nextInt();
        int[] arrayFirst = new int[elementArrayFirst];
        for (int i = 0; i < arrayFirst.length; i++) {
            arrayFirst[i] = (int) (1 + Math.random() * 20);
        }
        System.out.println("Các phần tử của mảng thứ 1: " + Arrays.toString(arrayFirst));

        int[] arraySecond = new int[elementArraySecond];
        for (int i = 0; i < arraySecond.length; i++) {
            arraySecond[i] = (int) (1 + Math.random() * 20);
        }
        System.out.println("Các phần tử của mảng thứ 2 " + Arrays.toString(arraySecond));

        int[] arrayThird = new int[elementArrayFirst + elementArraySecond];
        for (int i = 0; i < arrayFirst.length; i++) {
            arrayThird[i] = arrayFirst[i];
        }
        for (int j = 0; j < arraySecond.length; j++) {
            arrayThird[j + arrayFirst.length] = arraySecond[j];
        }
        System.out.println("Mảng gộp có các phần tử  " + Arrays.toString(arrayThird));
    }
}
