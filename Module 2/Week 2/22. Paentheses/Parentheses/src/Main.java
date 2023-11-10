import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String string = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        Stack <String> stack = new Stack <>();
        boolean check = true;
        for (int i = 0; i < string.length(); i++) {
            String charAtString = String.valueOf(string.charAt(i));
            if (charAtString.equals("(")) {
                stack.push(charAtString);
            } else if (charAtString.equals(")")) {
                if (stack.isEmpty()) {
                    check = false;
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (check && ! stack.isEmpty()) {
            check = false;
        }
        System.out.println(check);
    }
}