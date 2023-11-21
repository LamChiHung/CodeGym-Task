package ss11_dsa_stack_queue.excercise.reverse;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReverseArray {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] integer = new int[n];
        for (int i = 0; i < integer.length; i++) {
            integer[i] = (int) (1 + Math.random() * 20);
        }
        System.out.println("Mảng đã tạo: " + Arrays.toString(integer));
        Stack<Integer> integerStack = new Stack<>();

        for (int k : integer) {
            integerStack.push(k);
        }

        for (int i = 0; i < integer.length; i++) {
            integer[i] = integerStack.pop();
        }
        System.out.println("Mảng đảo ngược: " + Arrays.toString(integer));
    }
}
