package ss01_introduction_to_java.excercise;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double usd;
        double vnd = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số tiền USD ");
        usd = scanner.nextDouble();
        double exchange = usd * vnd;
        System.out.println("Giá trị VND: " + exchange);

    }
}
