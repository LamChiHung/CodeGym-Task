package ss11_dsa_stack_queue.excercise;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Queue<Character> characterQueue = new LinkedList<>();
        Stack<Character> characterStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            characterQueue.add(string.charAt(i));
            characterStack.push(string.charAt(i));
        }

        boolean isFalse = false;
        while (characterQueue.isEmpty() && characterStack.isEmpty()) {
            if (characterQueue.poll() != characterStack.pop()) {
                isFalse = true;
                break;
            }
        }
        if (isFalse) {
            System.out.println("Không phải Palindrome");
        } else {
            System.out.println("Là Palindrome");
        }
//
    }
}
