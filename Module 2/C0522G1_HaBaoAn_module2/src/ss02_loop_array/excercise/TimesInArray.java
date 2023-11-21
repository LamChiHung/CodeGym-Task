package ss02_loop_array.excercise;

import java.util.Scanner;

public class TimesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi ");
        String str = scanner.nextLine();
        System.out.println("Nhập vào kí tự bất kì");
        char character = scanner.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Số lần kí tự " + character + " xuất hiện trong chuỗi là: " + count);
    }
}
