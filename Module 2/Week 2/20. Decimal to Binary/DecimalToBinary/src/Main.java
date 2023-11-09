import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int number = 30;
        Stack <Integer> stack = new Stack <>();
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        System.out.println(stack.toString());
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        System.out.println(Arrays.toString(result));
    }
}