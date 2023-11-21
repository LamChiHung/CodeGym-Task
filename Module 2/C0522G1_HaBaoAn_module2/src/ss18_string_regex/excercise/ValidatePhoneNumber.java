package ss18_string_regex.excercise;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ValidatePhoneNumber {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            try {
                System.out.println("Nhập vào Số điện thoại");
                String phoneNumber = SCANNER.nextLine();
                if (phoneNumber.matches("[(][0-9][0-9][)][-][(][0][0-9]{9}[)]")) {
                    System.out.println(phoneNumber + " Là số điện thoại hợp lệ");
                    break;
                } else {
                    System.out.println(phoneNumber + "Số điện thoại không hợp lệ, hãy nhập lại");
                }
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);

    }
}
