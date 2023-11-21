package ss11_dsa_stack_queue.excercise;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {


    public static boolean checkBracket(String string) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Character> characterStack1 = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                characterStack.push(string.charAt(i));
            } else if (string.charAt(i) == ')') {
                if (characterStack.isEmpty()) {
                    return false;
                } else {
                    characterStack1.push(string.charAt(i));
                }
            }
        }
        return characterStack.size() == characterStack1.size();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi");
        String string = scanner.nextLine();

        System.out.println(checkBracket(string));
    }
}
