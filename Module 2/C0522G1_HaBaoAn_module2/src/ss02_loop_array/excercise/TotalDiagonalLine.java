package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class TotalDiagonalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.println("Nhập vào độ dài của ma trận");
            length = scanner.nextInt();
            if (length < 1) {
                System.out.println("Nhập sai, yêu cầu nhập lại");
            }
        } while (length < 1);
        double[][] matrix = new double[length][length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Math.floor(Math.random() * 100);
            }
        }
        for (double[] doubles : matrix) {
            System.out.println(Arrays.toString(doubles));
            System.out.println();
        }
        double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        System.out.println("Tổng đường chéo chính của ma trận là: " + sum);
    }
}
