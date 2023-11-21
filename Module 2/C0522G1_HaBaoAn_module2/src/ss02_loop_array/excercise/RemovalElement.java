package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class RemovalElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] integer = new int[n];
        for (int i = 0; i < integer.length; i++) {
            integer[i] = (int) (1 + Math.random() * 20);
        }
        System.out.println(Arrays.toString(integer));
        System.out.println("Nhập vào số muốn xóa: ");
        int x = scanner.nextInt();

        int count = -1;
        for (int i = 0; i < integer.length; i++) {
            if (x == integer[i]) {
                count = i;
            }
        }
        if (count != -1) {
//            for (int j = 0; j < integer.length - 1; j++) {
            for (int i = count; i < integer.length - 1; i++) {
                integer[i] = integer[i + 1];
            }
            integer[integer.length - 1] = 0;
            System.out.println(Arrays.toString(integer));


        } else {
            System.out.println(x + "Không tồn tại trong mảng");
        }

    }
}
