import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input column numbers: ");
        int i = sc.nextInt();

        int[][] arr = new int[i][];
        for (int k = 0; k < arr.length; k++) {
            System.out.println("Input row numbers at column " + (k + 1));
            int j = sc.nextInt();
            arr[k] = new int[j];
            for (int l = 0; l < arr[k].length; l++) {
                System.out.printf("Input value at arr[%d][%d]", k, l);
                arr[k][l] = sc.nextInt();
            }
        }
        int max = arr[0][0];
        for (int[] element : arr) {
            for (int j : element) {
                System.out.print(j + "\t");
                if (max < j) {
                    max = j;
                }
            }
            System.out.println();
        }
        System.out.println("max: " + max);
    }
}
