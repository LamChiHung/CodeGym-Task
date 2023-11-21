package ss13_binary_search.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;
        if (right >= left) {
            if (x == a[mid]) {
                return mid;
            }

            if (x > a[mid]) {
                return binarySearch(a, mid + 1, right, x);
            }

            return binarySearch(a, left, mid - 1, x);
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào sô phần tử của mảng");
        int[] arrays = new int[Integer.parseInt(scanner.nextLine())];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = (int) (Math.random() * 1000);
        }
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
        System.out.println("Nhập vào sô cần tìm");
        int x = Integer.parseInt(scanner.nextLine());


        System.out.println("Vj trí của số cần tìm trong mảng là: " + binarySearch(arrays, 0, arrays.length - 1, x));


    }


}
