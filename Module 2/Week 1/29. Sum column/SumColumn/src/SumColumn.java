import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input column");
        int column = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][column];
        }
        System.out.println(sum);
    }
}
