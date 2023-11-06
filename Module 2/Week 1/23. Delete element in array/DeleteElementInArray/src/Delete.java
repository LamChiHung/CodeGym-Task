import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Scanner sc = new Scanner(System.in);
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println();
        System.out.println("Input delete value");
        int deleteValue = sc.nextInt();
        int deleteIndex = 0;
        boolean exits = false;
        for (int i = 0; i < arr.length; i++) {
            if (deleteValue == arr[i]) {
                deleteIndex = i;
                exits = true;
            }
        }
        if (exits) {
            for (int i = 0; i < arr.length; i++) {
                if (i >= deleteIndex && i != arr.length - 1) {
                    arr[i] = arr[i + 1];
                } else if (i == arr.length - 1) {
                    arr[i] = 0;
                }
            }
            System.out.println("new array: ");
            for (int value : arr) {
                System.out.print(value + "\t");
            }
        } else {
            System.out.println("value not exist");
        }
    }
}
