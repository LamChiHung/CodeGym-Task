package ss13_binary_search.excercise;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestConsecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();

        System.out.println("Nhập vào chuỗi");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }

            list.add(string.charAt(i));

            if (list.size()>max.size()){
                max.clear();
                max.addAll(list);
            }
        }

        for (Character ch :max){
            System.out.print(ch);
        }
    }
}
