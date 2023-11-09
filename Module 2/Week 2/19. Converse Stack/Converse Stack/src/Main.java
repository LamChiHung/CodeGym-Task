import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Stack <Integer> stack = new Stack <>();
        for (int j : arr) {
            stack.push(j);
        }
        System.out.println(stack.toString());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));

        String string = "abcdef";
        String[] strings = new String[string.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(string.charAt(i));
        }
        System.out.println(Arrays.toString(strings));
        Stack <String> stringStack = new Stack <>();
        for (int i = 0; i < strings.length; i++) {
            stringStack.push(strings[i]);
        }
        System.out.println(stringStack.toString());
        for (int i = 0; i < strings.length; i++) {
            strings[i] = stringStack.pop();
        }
        System.out.println(Arrays.toString(strings));
    }
}