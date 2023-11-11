import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int[] createRandomArray() {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static int findNumber(int index, int[] arr) {
        return arr[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vị trí cần tìm:");
        int index = sc.nextInt();
        int[] arr = createRandomArray();
        try {
            index = findNumber(index, arr);
            System.out.println(Arrays.toString(arr));
            System.out.println(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("Program end");
    }
}