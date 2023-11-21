package ss02_loop_array.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class AssignToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] integer = new int[n];
        for (int i = 0; i < integer.length; i++) {
            integer[i] = (int) (1 + Math.random() * 20);
        }
        System.out.println(Arrays.toString(integer));
        System.out.println("Nhập vào số bạn muốn chèn vào");
        int x = scanner.nextInt();
        int index;
        do {
            System.out.println("Nhập vào vị trí bạn muốn chèn");
            index = scanner.nextInt();
        } while (index < 0 || index > integer.length - 1);

        int[] newArray = new int[integer.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = integer[i];
        }
        newArray[index] = x;
        for (int j = index; j < integer.length; j++) {
            newArray[j + 1] = integer[j];
        }
        System.out.println(Arrays.toString(newArray));
    }
}
