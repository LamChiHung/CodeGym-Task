import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 6, 2, 7, 9, 1, 5};
        System.out.println(Arrays.toString(array));
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}