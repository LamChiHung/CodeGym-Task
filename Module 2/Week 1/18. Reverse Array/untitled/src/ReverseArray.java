import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length;
        do {
            System.out.println("Input length of array: ");
            length = sc.nextInt();
            if (length > 20) {
                System.out.println("PLease input length < 20!");
            }
        } while (length > 20);

        int[] arr = new int[length];
        int i = 0;
        while (i < length) {
            System.out.printf("Input the arr[%d]", i);
            arr[i] = sc.nextInt();
            i++;
        }

        System.out.print("The array is:");
        for (int j = 0; j < length; j++) {
            System.out.print(arr[j] + "\t");
        }

        for (int j = 0; j < length / 2; j++) {
            int temp = arr[j];
            arr[j] = arr[length - 1 - j];
            arr[length - 1 - j] = temp;
        }
        System.out.println();
        System.out.print("The reverse array is:");
        for (int j = 0; j < length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}
