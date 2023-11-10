import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String string = "Able was I ere I saw Elba";
        Stack <String> stack = new Stack <>();
        Queue <String> queue = new LinkedList <>();
        for (int i = 0; i < string.length(); i++) {
            stack.push(String.valueOf(string.charAt(i)));
            queue.add(String.valueOf(string.charAt(i)));
        }
        boolean same = true;
        for (int i = 0; i < string.length(); i++) {
            String charStack = stack.pop();
            String charQueue = queue.remove();
            if (charStack.compareToIgnoreCase(charQueue) != 0) {
                System.out.println(charStack + " " + charQueue);
                same = false;
            }
        }
        if (same) {
            System.out.println("Palindrome");
        } else {
            System.out.println("not Palindrome!");
        }
    }
}