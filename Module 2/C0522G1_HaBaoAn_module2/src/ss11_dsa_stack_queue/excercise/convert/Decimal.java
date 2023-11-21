package ss11_dsa_stack_queue.excercise.convert;

import java.util.Scanner;
import java.util.Stack;

public class Decimal {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số thập phân");
        int number = Integer.parseInt(scanner.nextLine());
        while (number>0){
           integerStack.push(number%2);
           number/= 2;
        }
        while (!integerStack.isEmpty()){
            System.out.print(integerStack.pop());
        }
    }


}
