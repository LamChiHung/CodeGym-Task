import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        String s = "Hello Hello";
        Scanner sc = new Scanner(System.in);
        System.out.println("Input char: ");
        String c = sc.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String s1 = Character.toString(s.charAt(i));
            if (s1.equals(c)) {
                count++;
            }
        }
        System.out.println("numbers of " + c + " is " + count);
    }
}
