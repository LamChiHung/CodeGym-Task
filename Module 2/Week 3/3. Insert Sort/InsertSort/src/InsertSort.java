public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pos = i;
            while (arr[pos] < arr[pos - 1]) {
                int temp = arr[pos];
                arr[pos] = arr[pos - 1];
                arr[pos - 1] = temp;
                pos--;
                if (pos == 0) {
                    break;
                }
            }
        }
    }
}
