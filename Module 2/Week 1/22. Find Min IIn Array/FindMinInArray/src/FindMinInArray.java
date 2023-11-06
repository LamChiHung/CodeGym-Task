import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int size;

        do {
            System.out.println("Input size of array");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Input size <=20");
            }
        } while (size > 20);
        arr = new int[size];
        int i = 0;
        while (i < size) {
            System.out.printf("Input value at arr[%d]", i);
            arr[i] = sc.nextInt();
            i++;
        }
        int min = arr[0];
        int index = 0;
        int minIndex = 0;
        for (int number : arr) {
            if (min > number) {
                min = number;
                minIndex = index;
            }
            index++;
        }
        System.out.println("The max value is: " + min + " at position: " + minIndex);
    }
}
