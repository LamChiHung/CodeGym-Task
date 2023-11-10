import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 7, 9, 1, 5};
        System.out.println(Arrays.toString(arr));
        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}