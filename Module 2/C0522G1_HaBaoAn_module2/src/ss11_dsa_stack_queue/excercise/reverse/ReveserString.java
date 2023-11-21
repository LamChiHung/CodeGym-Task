package ss11_dsa_stack_queue.excercise.reverse;

import java.util.Scanner;
import java.util.Stack;

public class ReveserString {
    public static void main(String[] args) {
        Stack<Character> stringStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(stringStack.pop());
        }
    }
}
