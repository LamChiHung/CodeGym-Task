import java.util.Scanner;

public class SumDiagonalLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input size");
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        int index1 = 0;

        for (int[] element1 : arr) {
            int index2 = 0;
            for (int element2 : element1) {
                System.out.printf("Input arr[%d][%d]", index1, index2);
                arr[index1][index2] = sc.nextInt();
                index2++;
            }
            index1++;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - 1 - i];
        }
        System.out.println("sum 1: " + sum1 + " sum 2: " + sum2);
    }
}
