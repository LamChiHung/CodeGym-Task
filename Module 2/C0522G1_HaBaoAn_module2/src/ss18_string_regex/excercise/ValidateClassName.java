package ss18_string_regex.excercise;


import ss10_dsa_list.excercise.method_arraylist.model.Person;
import ss10_dsa_list.excercise.method_arraylist.model.Student;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ValidateClassName {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            try {
                System.out.println("Nhập vào tên lớp");
                String className = SCANNER.nextLine();
                if (className.matches("[CAP][0-9]{4}[GHIKLM]")) {
                    System.out.println(className + " Là tên hợp lệ");
                    break;
                } else {
                    System.out.println(className + "Tên không hợp lệ, hãy nhập lại");
                }
            }catch (PatternSyntaxException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);
    }

}
