package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class TotalOfPillar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số hàng");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số cột");
        int col = scanner.nextInt();
        double[][] array2d = new double[row][col];
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[0].length; j++) {
                array2d[i][j] = Math.random() * 100;
            }
        }
        for (double[] doubles : array2d) {
            System.out.print(Arrays.toString(doubles));
            System.out.println();
        }
        int number;
        boolean isInvalidCol;
        do {
            System.out.println("Nhập vào vị trí của cột bạn muốn tính tổng");
            number = scanner.nextInt();
            isInvalidCol = number < 0 || number > array2d[0].length;
            if (isInvalidCol) {
                System.out.println("Bạn nhập sai rồi");
            }
        } while (isInvalidCol);
        double count = 0.0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j <= array2d[0].length; j++) {
                if (j + 1 == number) {
                    count += array2d[i][j];
                }
            }
        }
        System.out.println("Tổng của cột " + (number) + " là: " + count);
    }
}
