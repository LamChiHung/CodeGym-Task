import java.util.Scanner;

public class InsertElementInArray {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println("arr: ");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
        Scanner sc = new Scanner(System.in);
        int value;
        int index;
        System.out.println();
        do {
            System.out.println("Input Index: ");
            index = sc.nextInt();
            System.out.println("Input Value: ");
            value = sc.nextInt();
            if (index < 0 || index > arr.length) {
                System.out.println("out of bao");
            }
        } while (index < 0 || index > arr.length - 1);

        arr[index] = value;
        System.out.println("new arr: ");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
    }
}
