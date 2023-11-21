package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số hàng");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số cột");
        int col = scanner.nextInt();
        double[][] array2d = new double[row][col];
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[0].length; j++) {
                array2d[i][j] = Math.floor(Math.random() * 100);
            }
        }
        for (int i = 0; i < array2d.length; i++) {
            System.out.print(Arrays.toString(array2d[i]));
            System.out.println();
        }
        double maxValue = array2d[0][0];
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[0].length; j++) {
                if (array2d[i][j] > maxValue) {
                    maxValue = array2d[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất là " + maxValue);
    }
}
